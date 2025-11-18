# 🧪 Automatización de Calidad - Serenity BDD

Proyecto de automatización de pruebas usando Serenity BDD, Cucumber y el patrón Screenplay para pruebas end-to-end de aplicaciones web.

## 📋 Tabla de Contenidos

- [Características](#-características)
- [Requisitos Previos](#-requisitos-previos)
- [Inicio Rápido](#-inicio-rápido)
- [Ejecución de Pruebas](#-ejecución-de-pruebas)
- [Reportes](#-reportes)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Configuración](#️-configuración)
- [Solución de Problemas](#-solución-de-problemas)

## ✨ Características

- ✅ Automatización con **Serenity BDD 4.1.0** y **Cucumber**
- 🎭 Implementación del **Screenplay Pattern**
- 🐳 Entorno completo con **Dev Container** (Java 21, Gradle, Chrome)
- 📊 Reportes interactivos y visuales generados automáticamente
- 🔄 Integración continua lista para CI/CD
- 🌐 Pruebas headless configuradas para contenedores

## 📦 Requisitos Previos

### Opción 1: Usando Dev Container (Recomendado)
- Docker Desktop o GitHub Codespaces
- VS Code con extensión "Dev Containers"

### Opción 2: Instalación Local
- Java 21 (compatible con Java 17)
- Gradle 8.5+
- Google Chrome o Chromium
- Git

## 🚀 Inicio Rápido

### Usando Dev Container

1. Abre el proyecto en VS Code
2. Cuando se te pregunte, selecciona **"Reopen in Container"**
3. Espera a que el contenedor se construya (solo la primera vez)
4. ¡Listo! Ya puedes ejecutar las pruebas

### Usando GitHub Codespaces

1. Haz clic en **"Code"** → **"Create codespace on main"**
2. Espera a que el entorno se configure automáticamente
3. ¡Listo! Ya puedes ejecutar las pruebas

## 🧪 Ejecución de Pruebas

### Usando el Script (Recomendado)

```bash
./run-tests.sh
```

Este script ejecuta:
1. Limpieza de builds anteriores
2. Ejecución de todas las pruebas
3. Generación automática de reportes interactivos

### Usando Gradle Directamente

```bash
# Para DevContainer (headless):

gradle clean test -Denvironment=devcontainer

# Para ejecución local (con interfaz):

gradle clean test -Denvironment=local

# Sin especificar (usa configuración base):
# Ejecutar todas las pruebas

./gradlew clean test

# Generar reportes interactivos
./gradlew aggregate

# Ejecutar prueba específica
./gradlew test --tests "RunnerCountShoppingCartSaucedemo"

# Ver resultados detallados
./gradlew test --info

```


## 📊 Reportes

### Ver Reportes Interactivos

Los reportes se generan automáticamente en: **`target/site/serenity/index.html`**

**Opción 1: Usando Live Server (recomendado)**
1. Haz clic derecho en `index.html`
2. Selecciona **"Open with Live Server"**


**Opción 2: Descarga local**
- Descarga la carpeta `target/site/serenity/`
- Abre `index.html` en tu navegador

### Contenido de los Reportes

- 📈 Dashboard con estadísticas y gráficos
- ✅ Resultados de escenarios (passed/failed/pending)
- 📸 Screenshots automáticos de pasos
- 🔍 Navegación interactiva entre pruebas
- 📋 Logs y detalles completos de ejecución

## 📁 Estructura del Proyecto

```
.
├── src/
│   ├── main/java/co/edu/udea/certificacion/taller/
│   │   ├── tasks/           # Tareas del patrón Screenplay
│   │   ├── interactions/    # Interacciones personalizadas
│   │   ├── questions/       # Validaciones y assertions
│   │   ├── userinterfaces/  # Page Objects/Elementos UI
│   │   ├── models/          # Modelos de datos
│   │   └── utils/           # Utilidades y helpers
│   │
│   └── test/
│       ├── java/co/edu/udea/certificacion/taller/
│       │   ├── runners/          # Runners de Cucumber
│       │   └── stepdefinitions/  # Step Definitions
│       │
│       └── resources/
│           ├── features/         # Archivos .feature (Gherkin)
│           ├── serenity.conf    # Configuración de Serenity
│           └── application.conf # Configuración de la app
│
├── .devcontainer/           # Configuración del Dev Container
├── build.gradle            # Configuración de Gradle
├── serenity.properties     # Propiedades de Serenity
└── run-tests.sh           # Script de ejecución
```

## ⚙️ Configuración

### URLs de Prueba

Configuradas en `serenity.conf`:
```hocon
pages {
    swaglabsUrl = "https://www.google.com/"
    saucedemo = "https://www.saucedemo.com/"
}
```

### Propiedades de Serenity

En `serenity.properties`:
```properties
serenity.report.encoding = UTF-8
serenity.outputDirectory = target/site/serenity
serenity.reports.show.step.details = true
```
## 🔧 Solución de Problemas

### Error: Chrome no se encuentra

```bash
# Verificar instalación de Chrome
google-chrome --version

# Si no está instalado (en el Dev Container debería estar)
sudo apt-get update && sudo apt-get install -y google-chrome-stable
```

### Error: Gradle no tiene permisos

```bash
chmod +x gradlew
```

### Error: Dependencias no se descargan

```bash
./gradlew clean --refresh-dependencies
```

### Problemas con el reporte aggregate

```bash
# Verificar que la tarea existe
./gradlew tasks --all | grep aggregate

# Ejecutar con más información
./gradlew aggregate --info --stacktrace
```

### Chrome se cierra inesperadamente en contenedor

Asegúrate de que `docker-compose.yml` tenga configurado:
```yaml
shm_size: '2gb'  # Memoria compartida para Chrome
```

### Ver logs detallados de las pruebas

```bash
./gradlew test --info
./gradlew test --debug  # Más detallado aún
```
