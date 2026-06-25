#!/usr/bin/env bash
# Smoke test for the Expense Tracker API (curl).
# Usage:  ./smoke-test.sh            # tests http://localhost:8080
#         ./smoke-test.sh 8090       # tests http://localhost:<port>
#
# Note: 400 (validation), 404 (not found) and persistence work only after steps 5/6/4
# are implemented (branch main/final). On the `start` branch only list/POST/total/delete pass.

set -u
PORT="${1:-8080}"
HOST="http://localhost:${PORT}"
pass=0; fail=0
ok(){ echo "  ✅ $1"; pass=$((pass+1)); }
no(){ echo "  ❌ $1 (got: $2)"; fail=$((fail+1)); }

code(){ curl -s -o /dev/null -w '%{http_code}' "$@"; }

echo "→ Testing ${HOST}"

# 1) list
[ "$(code ${HOST}/expenses)" = "200" ] && ok "GET /expenses = 200" || no "GET /expenses" "$(code ${HOST}/expenses)"

# 2) create
id=$(curl -s -X POST ${HOST}/expenses -H 'Content-Type: application/json' \
       -d '{"description":"Lunch at restaurant","amount":150}' | sed -n 's/.*"id":\([0-9]*\).*/\1/p')
[ -n "$id" ] && ok "POST /expenses created id=$id" || no "POST /expenses" "no id"

# 3) get by id
[ "$(code ${HOST}/expenses/${id:-0})" = "200" ] && ok "GET /expenses/$id = 200" || no "GET /expenses/$id" "$(code ${HOST}/expenses/${id:-0})"

# 4) total
[ "$(code ${HOST}/expenses/total)" = "200" ] && ok "GET /expenses/total = 200" || no "GET /expenses/total" "$(code ${HOST}/expenses/total)"

# 5) validation -> 400  (steps 5)
c=$(code -X POST ${HOST}/expenses -H 'Content-Type: application/json' -d '{"description":"","amount":-5}')
[ "$c" = "400" ] && ok "POST invalid = 400" || no "POST invalid (expect 400; needs step 5)" "$c"

# 6) not found -> 404  (step 6)
c=$(code ${HOST}/expenses/9999)
[ "$c" = "404" ] && ok "GET /expenses/9999 = 404" || no "GET missing (expect 404; needs step 6)" "$c"

# 7) delete
[ "$(code -X DELETE ${HOST}/expenses/${id:-0})" = "200" ] && ok "DELETE /expenses/$id = 200" || no "DELETE /expenses/$id" "$(code -X DELETE ${HOST}/expenses/${id:-0})"

# 8) swagger UI reachable
[ "$(code ${HOST}/swagger-ui/index.html)" = "200" ] && ok "Swagger UI = 200" || no "Swagger UI" "$(code ${HOST}/swagger-ui/index.html)"

echo "→ passed: $pass, failed: $fail"
[ "$fail" = "0" ]
