# IIUM Accident Detection System

## 👨‍💻 Team Members
| Name                                     | Matric No | Role                |
|------------------------------------------|-----------|---------------------|
| Sarah Yasmin Binti Rodzman               | 2413034   | Project Manager     |
| Nur Balqis Binti Mohd Kamarulzaman       | (Insert)  | File Handler        |
| Putri Aimi Batrisyia Binti Muhammad Yusri| 2320206   | Backend Developer   |
| Nurin Sofina Binti Yusdi                 | 2221372   | GUI Designer        |

---

## 🚀 Project Description
This JavaFX application simulates an Accident Detection and Severity Analysis System tailored for the IIUM campus. It uses simulated sensor inputs and AI engine analysis to determine the severity of detected accidents, dispatch alerts, and notify emergency responders. It also includes a dashboard interface for monitoring.

---

## 📁 Folder Structure
```
/AccidentDetectionSystem
│
├── /src
│   ├── MainApp.java
│   ├── Sensor.java
│   ├── IotSensor.java
│   ├── CameraSensor.java
│   ├── AIEngine.java
│   ├── AlertDispatcher.java
│   ├── Responder.java
│   └── Dashboard.java
│
├── /resources
│   └── images/, styles.css, .fxml files
│
├── accident_data.txt
├── README.md
└── .gitignore
```

---

## 💡 How to Run
1. Clone the repo:
```bash
git clone https://github.com/your-username/your-repo-name.git
```

2. Open in **IntelliJ IDEA** or **Eclipse** with JavaFX support.
3. Ensure you add the correct **JavaFX SDK** to project libraries.
4. Run `MainApp.java`.

---

## 🛠 Dependencies
- Java 17+
- JavaFX SDK 17+
- Git (for version control)

---

## ⚙️ Features
- Simulated impact detection via Sensor classes
- Severity analysis with AIEngine logic
- Alert dispatching via SMS and call alert classes
- Dashboard monitoring for admin/user views

---

## 📋 .gitignore
```
/out/
*.class
*.log
.idea/
*.iml
*.DS_Store
*.fxml
/build/
.gradle/
*.jar
```

---

