# Crud con Thymeleaf 

Aplicación web para gestionar empresas, vehículos y conductores.

---

## Tecnologías utilizadas

- **Frontend:** Thymeleaf 3.1.1
- **Backend:** JPA 3.1, Hibernate 6.1.7, Spring Boot 3.0.6, Maven 3.8.6
- **Base de datos:** MySQL 8

---

## Funcionalidades principales

- **Empresas:** Crear, consultar, actualizar, eliminar empresas y asociar vehículos a una empresa.
- **Vehículos:** Crear, consultar, actualizar y eliminar vehículos.
- **Conductores:** Crear, consultar, actualizar y eliminar conductores.
---

## 📸 Capturas de pantalla

<img width="921" height="188" alt="image" src="https://github.com/user-attachments/assets/9c14cd6d-1cc4-414b-8217-67649c115859" />

<img width="921" height="219" alt="image" src="https://github.com/user-attachments/assets/b0763a2c-3f40-4a61-8c1d-e2a3d71ee3ac" />

<img width="921" height="304" alt="image" src="https://github.com/user-attachments/assets/c3fe54c7-ee3c-467e-a236-6573c4ad8ead" />

<img width="921" height="231" alt="image" src="https://github.com/user-attachments/assets/12a2f9f8-ae00-4638-95b3-9963687e06af" />

<img width="921" height="310" alt="image" src="https://github.com/user-attachments/assets/7ccfe5af-035e-412a-b58c-bb8abb91c6ff" />

<img width="921" height="188" alt="image" src="https://github.com/user-attachments/assets/95d219f8-d1d2-41c6-bb77-81a99ed2039f" />

<img width="921" height="369" alt="image" src="https://github.com/user-attachments/assets/3df76b5b-e0a1-43c4-a04b-a12d97898c3b" />

<img width="921" height="376" alt="image" src="https://github.com/user-attachments/assets/2e922c97-9a3c-4ad4-a60b-24ee2303b8c5" />

<img width="1919" height="315" alt="image" src="https://github.com/user-attachments/assets/8e95b23d-4455-443e-8143-73109cc889c1" />


## Instalación y ejecución local

### Descargar el proyecto

Clonar el repositorio:

```bash
git clone https://github.com/dflyate/spring-thymeleaf.git
```

### BASE DE DATOS MYSQL

- Ingresar A MySQL utilizando sus credenciales y preparar la generación de un nuevo script
- Dentro del proyecto buscar la carpeta BD y ejecutar los scripts adjuntos.

### BACKEND CON SPRING BOOT

- Editar el archivo application.properties localizado en la carpeta src -> main -> resources
- editar la línea spring.datasource.url reemplazando el nombre de su servidor y base de datos
- editar la línea spring.datasource.username con su usuario de MySQL
- editar la línea spring.datasource.password con su password de MySQL
- Abrir una consola de comandos y ejecutar la instrucción mvn spring-boot:run
- Abrir la aplicación desde un navegador web con el puerto 8090







