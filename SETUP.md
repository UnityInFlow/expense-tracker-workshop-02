# Setup Guide — Expense Tracker Workshop Session 2

## Predpoklad: absolvovana Session 1

Tento workshop navazuje na Session 1. Predpokladame ze mas:
- IntelliJ IDEA Community Edition nainstalovanou
- JDK 21 nainstalovanou
- Znalost zakladu Spring Boot z Session 1

## 1. IntelliJ IDEA Community Edition

### macOS
1. Stahni z https://www.jetbrains.com/idea/download/ (Community Edition — zdarma)
2. Otevri `.dmg`, pretahni do Applications
3. Spust IntelliJ IDEA

### Windows
1. Stahni z https://www.jetbrains.com/idea/download/ (Community Edition — zdarma)
2. Spust installer, vse ponech na vychozich hodnotach
3. Spust IntelliJ IDEA

### Linux
```bash
sudo snap install intellij-idea-community --classic
```

## 2. JDK 21

### Pres SDKMAN (doporuceno — macOS / Linux)
```bash
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install java 21-tem
```

### Manualne (Windows)
1. Stahni z https://adoptium.net/temurin/releases/?version=21
2. Spust installer
3. Over v terminalu: `java -version` → melo ukazat `openjdk version "21..."`

### Overeni
```bash
java -version
# ocekavany vystup: openjdk version "21.x.x" ...
```

## 3. sqlite3 CLI

### macOS
```bash
brew install sqlite3
```

### Linux
```bash
apt install sqlite3
```

### Windows
Stahni z https://www.sqlite.org/download.html (sqlite-tools-win-x64)

### Overeni
```bash
sqlite3 --version
```

## 4. Git + Workshop repo

```bash
git clone https://github.com/UnityInFlow/expense-tracker-workshop-02.git
cd expense-tracker-workshop-02
```

## 5. Otevreni projektu v IntelliJ

1. Otevri IntelliJ IDEA
2. File → Open → vyber slozku `step-01-start/` (nebo aktualniho kroku)
3. Pockej az IntelliJ stahne zavislosti (dole progress bar)
4. V pravem dolnim rohu over ze je nastaveny JDK 21

## Troubleshooting

**IntelliJ nerozpoznava Kotlin:**
→ File → Settings → Plugins → over ze Kotlin plugin je enabled

**java -version ukazuje starou verzi:**
→ `sdk use java 21-tem` (SDKMAN) nebo nastav JAVA_HOME rucne

**Git clone selhava:**
→ Over ze mas `git` nainstalovaný: `git --version`

**IntelliJ stahuje zavislosti prilis dlouho:**
→ Normalni pri prvnim otevreni. Pockej 2-5 minut.
