# Setup Guide — Expense Tracker Workshop Session 2

## Prerequisite: completed Session 1

This workshop builds on Session 1. We assume you have:
- IntelliJ IDEA Community Edition installed
- JDK 21 installed
- Knowledge of Spring Boot basics from Session 1

## 1. IntelliJ IDEA Community Edition

### macOS
1. Download from https://www.jetbrains.com/idea/download/ (Community Edition — free)
2. Open `.dmg`, drag to Applications
3. Launch IntelliJ IDEA

### Windows
1. Download from https://www.jetbrains.com/idea/download/ (Community Edition — free)
2. Run the installer, leave all settings at their defaults
3. Launch IntelliJ IDEA

### Linux
```bash
sudo snap install intellij-idea-community --classic
```

## 2. JDK 21

### Via SDKMAN (recommended — macOS / Linux)
```bash
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install java 21-tem
```

### Manually (Windows)
1. Download from https://adoptium.net/temurin/releases/?version=21
2. Run the installer
3. Verify in terminal: `java -version` → should show `openjdk version "21..."`

### Verification
```bash
java -version
# expected output: openjdk version "21.x.x" ...
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
Download from https://www.sqlite.org/download.html (sqlite-tools-win-x64)

### Verification
```bash
sqlite3 --version
```

## 4. Git + Workshop repo

```bash
git clone https://github.com/UnityInFlow/expense-tracker-workshop-02.git
cd expense-tracker-workshop-02
```

## 5. Opening the project in IntelliJ

1. Open IntelliJ IDEA
2. File → Open → select the `step-01-start/` folder (or current step)
3. Wait for IntelliJ to download dependencies (progress bar at the bottom)
4. Check in the bottom right corner that JDK 21 is configured

## Troubleshooting

**IntelliJ does not recognize Kotlin:**
→ File → Settings → Plugins → verify the Kotlin plugin is enabled

**java -version shows an old version:**
→ `sdk use java 21-tem` (SDKMAN) or set JAVA_HOME manually

**Git clone fails:**
→ Verify that you have `git` installed: `git --version`

**IntelliJ is downloading dependencies for too long:**
→ Normal on first open. Wait 2-5 minutes.
