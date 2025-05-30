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
│   ├── /view
│       ├── AccidentReportUI.java
│       ├── AdminDashboardUI.java
│       ├── LoginWindow.java
│       ├── MainMenu.java
│       ├── ResponderDasbooardUI.java
│       ├── StatusUpdateUI.java
│       ├── UserDashboardUI.java
│    ├──  /model
│       ├── AlertDispatcher.java
│       ├── CallAlert.java
│       ├── CameraSensor.java
│       ├── Dashboard.java
│       ├── IIUMAmbulance.java
│       ├── IoTSensor.java
│       ├── MonitorDashboard.java
│       └── OSEM.java
│       ├── Responder.java
│       ├── ResponderDashboard.java
│       ├── Sensor.java
│       ├── SMSAlert.java
│       ├── StatusUpdate.java
│       ├── UserDashboard.java
│
│   
├── MainApp.java
│
│  
├── accident_data.txt
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
4. Run `MainApp.java`.

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


