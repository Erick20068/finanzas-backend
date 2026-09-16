# finanzas-backend

# ☕ Arca - Finanzas Personales (Backend)

Backend oficial de la aplicación Arca, desarrollado bajo una arquitectura robusta orientada a servicios para gestionar la persistencia de datos financieros y la integración con modelos de Inteligencia Artificial.

## ⚙️ Arquitectura y Componentes
* **Módulos:** Estructura modular basada en Spring Boot que incluye gestión de Usuarios, Cuentas, Categorías, Transacciones, Presupuestos y Deudas.
* **Módulo Asesor de IA:** Servicio encargado de procesar el contexto financiero del usuario (ingresos, gastos, presupuestos y deudas pendientes) e integrarlo de forma segura con la API de **Groq (Llama 3)** mediante peticiones HTTP seguras.
* **Seguridad y CORS:** Configuración avanzada de seguridad y control de accesos cruzados (CORS) optimizada para permitir la comunicación segura con el frontend en Netlify.

## 🛠️ Tecnologías y Dependencias
* **Java** con **Spring Boot**.
* **Spring Data JPA / Hibernate** para el mapeo y conexión a bases de datos relacionales.
* **PostgreSQL (Supabase)** como motor de base de datos en la nube.
* **RestTemplate** para la comunicación con servicios externos de IA.
* **Maven** para la gestión de dependencias y empaquetado.

## 🔐 Variables de Entorno (Producción / Render)
El servidor requiere las siguientes variables de configuración para operar correctamente:
* `DB_PASSWORD`: Contraseña de acceso a la base de datos de Supabase.
* `JWT_SECRET`: Llave secreta para la validación de tokens.
* `GROQ_API_KEY`: Clave de acceso privada para el servicio de IA de Groq.
