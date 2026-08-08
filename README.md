# Keystone Property Management System 🗝️🏡

![Kotlin](https://img.shields.io/badge/Kotlin-B125EA?style=for-the-badge&logo=kotlin&logoColor=white)
![C#](https://img.shields.io/badge/C%23-239120?style=for-the-badge&logo=c-sharp&logoColor=white)
![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)
![Firebase](https://img.shields.io/badge/Firebase-FFCA28?style=for-the-badge&logo=firebase&logoColor=white)

Keystone is a decoupled, custom Property Management System (PMS) designed to streamline rental operations for landlords while providing an accessible, offline-capable portal for tenants to handle payments, maintenance requests, and contract retrieval. 

This project is architected with a strict **zero-cost infrastructure strategy**, utilizing free-tier cloud services without sacrificing reliability or security.

## ✨ Key Features

### 📱 Tenant Mobile App (Android / Kotlin)
*   **Single Sign-On (SSO):** Secure invite-only registration and login using Firebase Authentication (Google SSO).
*   **Offline-First Emergency Reports:** Tenants can log emergencies and attach photos even without internet access. Built with **RoomDB** and **WorkManager** to automatically sync data once connectivity is restored.
*   **Payment Hub:** Submit Proof of Payment (POP) images and declare paid amounts.
*   **Multi-Language Support:** Dynamic UI switching between English, isiZulu, and Afrikaans using Android Preferences DataStore and native string resources.
*   **Document Vault:** Secure, read-only access to active lease agreements via time-limited signed URLs.

### 💻 Landlord Dashboard (Web / Netlify)
*   **Financial Dashboard:** Visualize cash flow and track provisional (tenant-reported) vs. verified income.
*   **Ledger System:** Interface to verify tenant POP submissions and track rental arrears.
*   **Maintenance Kanban:** A ticket tracking board for managing routine complaints and emergency repairs.
*   **Real-Time Alerts:** Immediate server-side **Firebase Cloud Messaging (FCM)** push notifications whenever a tenant uploads a POP or submits an emergency report.

## 🛠️ Technology Stack

*   **Tenant Client:** Native Android (Kotlin), RoomDB, Retrofit, WorkManager.
*   **Admin Client:** Responsive Web App (HTML/CSS/JS) hosted on Netlify.
*   **Backend API:** RESTful API built with C# (ASP.NET Core).
*   **Database:** Relational SQL (SQL Server / MySQL) hosted on Oracle Cloud Infrastructure (OCI) Always Free Tier.
*   **Object Storage:** Cloudflare R2 / Azure Blob Storage for handling POP images and PDF contracts.
*   **Authentication & Notifications:** Firebase Auth & Firebase Cloud Messaging (FCM).

## 🚀 Getting Started

### Prerequisites
*   Android Studio (for the Kotlin mobile app)
*   Visual Studio or Rider (for the C# API)
*   A Firebase Console Project
*   Oracle Cloud Free Tier Account

### Installation & Setup

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/yourusername/keystone-pms.git](https://github.com/yourusername/keystone-pms.git)
    ```
2.  **Backend (C# API):**
    *   Navigate to the `/backend` directory.
    *   Update `appsettings.json` with your Oracle Database connection string and Firebase Project keys.
    *   Run Entity Framework migrations to generate the SQL schema: `dotnet ef database update`.
    *   Start the API server.
3.  **Frontend (Android):**
    *   Open the `/android` directory in Android Studio.
    *   Add your `google-services.json` file from Firebase to the `app/` directory.
    *   Update the `BASE_URL` in your Retrofit client to point to your local or hosted C# API.
    *   Build and run the project on an emulator or physical device.

## 🔒 Security & Architecture Notes
*   **Role-Based Access Control (RBAC):** Strict separation of concerns between Admin and Tenant roles.
*   **Stateless Authentication:** All API requests are secured via Firebase JWT validation in the ASP.NET Core middleware.
*   **Secure File Serving:** Private documents and photos are never public. They are served dynamically via temporary signed URLs.

## 👨‍💻 Author
**Kamvelihle Athabile Dyantyi**
