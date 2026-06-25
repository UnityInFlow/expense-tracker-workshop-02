-- STEP 1 — SQLite setup: the expenses table. Spring runs this on startup (spring.sql.init.mode=always).
CREATE TABLE IF NOT EXISTS expenses (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    description TEXT    NOT NULL,
    amount      INTEGER NOT NULL,
    date        TEXT    NOT NULL
);
