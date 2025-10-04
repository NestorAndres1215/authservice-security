# 🔐 Spring Security Demo - Autenticación y Autorización con Roles

Este proyecto es un ejemplo práctico de cómo implementar **autenticación y autorización** en una aplicación **Spring Boot (JDK 17)** utilizando **Spring Security**, **MySQL** y **Lombok**.  
Se incluyen dos roles principales:  

- 👤 **USER** → puede acceder al endpoint `/user`.  
- 👨‍💼 **ADMIN** → puede acceder a `/admin` y a los endpoints de USER.  

---

## 📌 Características

- Registro de usuarios con rol **USER** o **ADMIN**.  
- Login básico con **HTTP Basic Auth** (se puede extender a JWT).  
- Protección de endpoints según rol.  
- Uso de **Lombok** para simplificar los modelos y servicios.  
- Persistencia de usuarios y roles en **MySQL**.  

---
## ⚙️ Dependencias Principales

- **Spring Boot Starter Web** → Para construir la API REST.  
- **Spring Boot Starter Security** → Para la autenticación/autorización.  
- **Spring Data JPA** → Persistencia de usuarios y roles.  
- **MySQL Driver** → Conexión con base de datos MySQL.  
- **Lombok** → Elimina código repetitivo (getters/setters, constructors).  

---
