# IIUM Accident Detection System

## 👨‍💻 Team Members
| Name                                     | Matric No | Role                |
|------------------------------------------|-----------|---------------------|
| Sarah Yasmin Binti Rodzman               | 2413034   | Project Manager     |
| Nur Balqis Binti Mohd Kamarulzaman       | 2410006   | File Handler        |
| Putri Aimi Batrisyia Binti Muhammad Yusri| 2320206   | Backend Developer   |
| Nurin Sofina Binti Yusdi                 | 2221372   | GUI Designer        |

---

## 🚀 Project Description
This JavaFX application simulates an Accident Detection and Severity Analysis System tailored for the IIUM campus. It uses simulated sensor inputs and AI engine analysis to determine the severity of detected accidents, dispatch alerts, and notify emergency responders. It also includes a dashboard interface for monitoring.

---

## 📁 Folder Structure
```
/IIUMAccidentDetectionSystem
│
├── /src
│ ├── /alert
│       ├── AlertDispatcher.java
│       ├── CallAlert.java
│       ├── SMSAlert.java
│ ├── /dashboard
│       ├── Dashboard.java
│       ├── MonitorDashboard.java
│       ├── ResponderDashboard.java
│       ├── StatusUpdate.java
│       ├── UserDashboard.java
│  ├── /main
│       ├── MainApp.java
│  ├── /responder
│       └── OSEM.java
│       ├── Responder.java
│       ├── SMSAlert.java
│  ├── /sensor
│       ├── CameraSensor.java
│       ├── IoTSensor.java
│       ├── Sensor.java
│  ├── /ui
│       ├── AccidentReportUI.java
│       ├── AdminDashboardUI.java
│       ├── LoginWindow.java
│       ├── ResponderDasbooardUI.java
│       ├── StatusUpdateUI.java
│       ├── UserDashboardUI.java
│
│
│  
├── accidents.txt
├── README.md
```

---

## 💡 How to Run
1. Clone the repo:
```bash
git clone https://github.com/Sarah-Yas/IIUM-Accident-Detection-System.git
```

2. Open in **IntelliJ IDEA** or **Netbeans** with JavaFX support.
3. Ensure you add the correct **JavaFX SDK** to project libraries.
4. Run `MainApp.java` inside main folder.

---

## 🛠 Dependencies
- Java 17+
- JavaFX SDK 17+

---

## ⚙️ Features
- Simulated impact detection via Sensor classes
- Severity analysis with AIEngine logic
- Alert dispatching via SMS and call alert classes
- Dashboard monitoring for admin/user views

---


