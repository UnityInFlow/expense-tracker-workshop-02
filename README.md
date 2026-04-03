# Expense Tracker Workshop — Session 2

## SQLite + Repository + Validace

Navazujici workshop na Session 1. Ucastnici pridaji SQLite databazi, Repository vrstvu, validaci a error handling. Controller se nezmeni ani radek — validace architektury ze Session 1.

Na konci workshopu budete mit production-ready API kde data preziji restart.

---

## Predpoklady

- Absolvovana **Session 1** ([expense-tracker-workshop-01](https://github.com/UnityInFlow/expense-tracker-workshop-02)) nebo znalost Spring Boot zakladu
- IntelliJ IDEA Community + JDK 21
- sqlite3 CLI (`brew install sqlite3` / `apt install sqlite3`)

---

## Struktura workshopu

| Krok | Tema | Co postavime |
|------|------|-------------|
| Step 1 | SQLite setup a schema | `expenses.db` soubor na disku |
| Step 2 | Repository: INSERT a SELECT | `ExpenseRepository` s `JdbcTemplate` |
| Step 3 | Repository: DELETE a findById | Kompletni CRUD Repository |
| Step 4 | Service → Repository propojeni | Data preziji restart! |
| Step 5 | Validace requestu @Valid | API odmitne nevalidni data |
| Step 6 | Error handling | Konzistentni chybove odpovedi |
| Step 7 | OpenAPI finalizace | Production-ready Swagger dokumentace |

Kazdy krok ma:
- **start** — projekt s TODO komentare (vase ukoly)
- **final** — kompletni reseni s vysvetlujicimi komentare

---

## Jak pracovat s timto repozitarem

### Varianta A — Slozky (doporuceno pro zacatecniky)

Nepotrebujete umet git. Staci stahnout a otvirat slozky.

**1. Stahnete repozitar:**

Kliknete na zelene tlacitko **Code** → **Download ZIP** na teto strance.
Rozbalte ZIP soubor.

**2. Zaciname — Step 1:**

- Otevrete IntelliJ IDEA
- File → Open → vyberte slozku `step-01-start`
- Pockejte az se stahnou zavislosti
- Doplnte kod kde vidite `// TODO:` komentare
- Spustte: `./mvnw spring-boot:run`

**3. Kdyz jste hotovi nebo se zasekli:**

Otevrete slozku `step-01-final/` v IntelliJ — tam je kompletni reseni.

**4. Pokracujte na dalsi krok:**

Zavrete projekt a otevrete `step-02-start/`.

**Postup krok za krokem:**
```
step-01-start/  →  doplnte TODO  →  porovnejte s  →  step-01-final/
step-02-start/  →  doplnte TODO  →  porovnejte s  →  step-02-final/
step-03-start/  →  doplnte TODO  →  porovnejte s  →  step-03-final/
step-04-start/  →  doplnte TODO  →  porovnejte s  →  step-04-final/  ← KLICOVY MOMENT!
step-05-start/  →  doplnte TODO  →  porovnejte s  →  step-05-final/
step-06-start/  →  doplnte TODO  →  porovnejte s  →  step-06-final/
step-07-start/  →  doplnte TODO  →  porovnejte s  →  step-07-final/  ← FINALNI STAV
```

**Tip — overeni dat v databazi:**
```bash
sqlite3 expenses.db ".tables"              # zobrazi tabulky
sqlite3 expenses.db "SELECT * FROM expenses;"  # zobrazi data
```

---

### Varianta B — Git branches (pro pokrocile)

Kazdy krok ma vlastni branch. Branch obsahuje POUZE soubory daneho kroku (na urovni root) — kompletni Maven projekt.

**1. Naklonujte repozitar:**

```bash
git clone https://github.com/UnityInFlow/expense-tracker-workshop-02.git
cd expense-tracker-workshop-02
```

**2. Prepnete na prvni krok:**

```bash
git checkout step-01-start
```

Nyni vidite kompletni Maven projekt v rootu. Otevrete ho v IntelliJ.

**3. Pracujte na ukolech:**

Upravte soubory primo — doplnte kod kde vidite `// TODO:`.
Spustte: `./mvnw spring-boot:run`

**4. Kdyz jste hotovi nebo se zasekli:**

```bash
git stash                     # ulozi vase zmeny stranou
git checkout step-01-final    # prepne na reseni
```

**5. Pokracujte dalsim krokem:**

```bash
git checkout step-02-start    # dalsi krok
```

**Vsechny dostupne branches:**
```
step-01-start    step-01-final
step-02-start    step-02-final
step-03-start    step-03-final
step-04-start    step-04-final    ← data preziji restart!
step-05-start    step-05-final
step-06-start    step-06-final
step-07-start    step-07-final    ← finalni stav
```

**Tip — porovnani vasi prace s resenim:**
```bash
# Na step-02-start po vasi praci:
git diff step-02-final -- src/
```

**Tip — skok na libovolny krok (kdyz zaosavate):**
```bash
git checkout step-04-start    # preskocte na Step 4
# Pokracujte odtud — vsechny predchozi kroky jsou hotove
```

---

## Klicove momenty

| Krok | Co se stane |
|------|------------|
| Step 4 final | **Data preziji restart!** HashMap vymenena za SQLite. Controller se nezmenil. |
| Step 5 final | API odmitne prazdny popis a zapornou castku — validace funguje. |
| Step 6 final | Vsechny chyby ve stejnem JSON formatu — konzistentni. |
| Step 7 final | Swagger UI s priklady hodnot a chybovymi kody — production ready. |

---

## Nastroje

| Nastroj | Pouziti |
|---------|---------|
| IntelliJ IDEA Community | Vsechny kroky |
| JDK 21 | Kompilace a spusteni |
| sqlite3 CLI | Overeni dat v databazi |
| Swagger UI | Testovani API v prohlizeci |

Podrobny navod k instalaci: [SETUP.md](SETUP.md)

---

## Souvisejici

**Session 1 — Kotlin & Spring Boot Basics**
https://github.com/UnityInFlow/expense-tracker-workshop-01

**Dalsi kroky po workshopu:**
- W01 Kotlin Idioms — idiomaticky Kotlin pro backend
- W02 Spring Boot Basics — pokrocile Spring Boot patterny
