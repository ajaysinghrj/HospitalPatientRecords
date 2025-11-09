# 🏥 Hospital Patient Records Management System  

### 💡 Overview  
The **Hospital Patient Records Management System** is a Java-based desktop application designed to streamline hospital record keeping.  
Built using **Java Swing** for the frontend and **SQLite** as the backend database, this project enables secure and efficient management of patient data — including name, age, and disease details.  

This system demonstrates how **Object-Oriented Programming (OOP)** concepts, **exception handling**, and **database connectivity (JDBC)** can be integrated to build a robust and interactive healthcare solution.  

---

### ⚙️ Tech Stack  
- **Programming Language:** Java  
- **Frontend:** Java Swing (GUI)  
- **Backend:** SQLite Database  
- **Architecture:** Modular MVC Design  
- **IDE Used:** Eclipse  

---

### 🧩 Project Modules  
| Module | Description |
|--------|-------------|
| **1. UI Package (ui)** | Handles user interface and user input components using Java Swing (`MainFrame.java`). |
| **2. DAO Package (dao)** | Manages database operations and SQL connections (`DatabaseManager.java`, `GenericDAO.java`). |
| **3. Model Package (model)** | Contains data classes like `Patient.java`, representing the structure of patient information. |
| **4. Service Package (service)** | Manages the logic for saving and retrieving records (`DataHandler.java`, `ThreadedBackupManager.java`). |
| **5. Network Package (network)** | Provides optional networking functionality (`Client.java`, `Server.java`). |
| **6. Main Application (mainapp)** | Launches the system (`App.java`) and integrates all modules. |
| **7. Exception Handling (exceptions)** | Custom error handling using `DataNotFoundException.java`. |

---

### 💻 Features  
✅ Add new patient records (Name, Age, Disease)  
✅ Store records securely in an SQLite database  
✅ View all patients in a formatted table view  
✅ Clear all records with a single click  
✅ Automatic backup creation  
✅ Custom exception handling for missing or invalid data  
✅ User-friendly and responsive GUI  

---

### 🧠 Future Enhancements  
🚀 Integration with cloud-based databases like **Supabase** or **Firebase**  
🔐 Add user authentication (Admin / Staff Login)  
📊 Include data visualization for patient trends  
🧾 Generate printable patient reports  
☁️ Deploy the system as a web-based application  
📱 Create
