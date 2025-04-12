# MEDTrack 🏥

**MEDTrack** is a hospital management system designed to facilitate seamless appointment scheduling, patient management, and secure authentication. Built using **Spring Boot**, **Spring Security**, and **MySQL**, this application helps healthcare providers manage appointments, track patient details, and ensure secure login for both admins and users.

---

## Table of Contents 📚
1. [Introduction](#introduction)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Installation](#installation)
5. [Usage](#usage)
6. [Contributing](#contributing)
7. [License](#license)

---

## Introduction 🌟

**MEDTrack** simplifies the management of hospital operations with a modern web-based platform. This system allows users (patients and hospital staff) to interact with the system for tasks like booking appointments, managing patient records, and ensuring secure access.

---

## Features 🎯

- **Appointment Scheduling**: Patients can book appointments with doctors, select the time, and view available slots.
- **Patient Management**: Admins can view and manage patient records, including personal details and medical history.
- **Doctor's Dashboard**: Doctors can view and manage their appointments and patient details.
- **Authentication & Security**: Spring Security is used for secure authentication and user roles, ensuring that only authorized personnel have access to sensitive data.
- **User Roles**: Admins, doctors, and patients have different levels of access:
  - **Admin**: Manages the system, views patient records, schedules appointments.
  - **Doctor**: Manages their appointments and views their patients' medical history.
  - **Patient**: Schedules appointments and views their medical records.

---

## Technologies Used ⚙️

- **Frontend**:
  - HTML
  - CSS (Bootstrap for responsive UI)

- **Backend**:
  - Spring Boot
  - Spring Security (for authentication and authorization)

- **Database**:
  - MySQL

---

## Installation 🛠️

Follow the steps below to set up **MEDTrack** locally on your machine:

### Prerequisites 🔑

Make sure you have the following installed:

- **Java** (JDK 8 or higher)
- **Maven** (for building the project)
- **MySQL** (for database management)

### 1. Clone the repository

```bash
git clone https://github.com/av-coder-hub/hospitalmanagement.git
```

### 2. Navigate to the project folder

```bash
cd hospitalmanagement
```

### 3. Set up the database

Create a MySQL database called `medtrack`:

```sql
CREATE DATABASE medtrack;
```

Update the database connection details in the `application.properties` file (located in the `src/main/resources` folder) with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/medtrack
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 4. Build the project

Use Maven to build the Spring Boot project:

```bash
mvn clean install
```

### 5. Run the application

To run the Spring Boot application, use the following command:

```bash
mvn spring-boot:run
```

Once the application is running, navigate to `http://localhost:8080` in your web browser.

---

## Usage 🚀

- **Admin**: 
  - Log in to manage hospital operations, create new doctor profiles, and manage appointments.
- **Doctor**:
  - Log in to view and manage patient appointments, view medical histories, and schedule consultations.
- **Patient**:
  - Register and log in to book appointments, view past consultations, and track appointment status.

---

## Contributing 🤝

We welcome contributions to **MEDTrack**! If you'd like to contribute, follow these steps:

1. Fork this repository.
2. Create a new branch (`git checkout -b feature-name`).
3. Make your changes and commit them (`git commit -am 'Add new feature'`).
4. Push to your branch (`git push origin feature-name`).
5. Open a pull request to merge your changes into the main repository.

---

