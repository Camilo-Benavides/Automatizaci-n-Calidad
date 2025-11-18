# Configuración del DevContainer

Este devcontainer está configurado para ejecutar pruebas de Serenity BDD con Selenium y Chrome headless.

## 🔧 Componentes Instalados

- **Java 21**
- **Gradle 8.5**
- **Google Chrome** 
- **Git, curl, wget** y utilidades básicas
- **Docker-in-Docker** (para ejecutar contenedores dentro del devcontainer)

## 🚀 Uso

### Primera vez
Cuando abras el proyecto en un Codespace o con VS Code + Dev Containers:
1. El contenedor se construirá automáticamente
2. Chrome ya estará instalado y configurado
3. Puedes ejecutar las pruebas inmediatamente con `./run-tests.sh`

### Ejecutar pruebas

```bash
# Ejecutar todas las pruebas
./run-tests.sh

# O manualmente
./gradlew clean test
```

### Utilidades

Se agrego una extension que permite ver el index que se genera como reporte.
Para esto haga lo siguiente:

1. Busque y abra el archivo target/site/serenity/index.html
2. Dele click derecho sobre el archivo en el explorador
3. Seleccione "Open with Live server"
4. Cuando se abra el puerto pongalo en publico.


## 🌐 Configuración de Chrome

Las pruebas están configuradas para ejecutarse en **modo headless** con las siguientes opciones:
- `--headless=new` (nuevo modo headless de Chrome)
- `--no-sandbox` (requerido en containers)
- `--disable-dev-shm-usage` (evita problemas de memoria compartida)
- `--disable-gpu` (optimización para headless)

La configuración se encuentra en: `src/test/resources/serenity.conf`

## 📊 Reportes

Después de ejecutar las pruebas:
- **Reportes de prueba**: `build/reports/tests/test/index.html`
- **Reportes JSON de Serenity**: Los archivos JSON se generan automáticamente

## 🔍 Troubleshooting

### Si Chrome no funciona:
1. Verifica que Chrome esté instalado: `google-chrome --version`
2. Revisa la configuración en `serenity.conf`
3. Asegúrate de que el contenedor tenga suficiente memoria compartida (configurado en `docker-compose.yml` con `shm_size: '2gb'`)

### Reconstruir el contenedor:
Si necesitas reconstruir el devcontainer con los cambios del Dockerfile:
1. En VS Code: `Ctrl/Cmd + Shift + P` → "Dev Containers: Rebuild Container"
2. En Codespaces: Elimina y crea un nuevo Codespace

## 📝 Notas Importantes

- **Memoria compartida**: El `docker-compose.yml` configura 2GB de SHM para Chrome
- **Usuario**: El contenedor ejecuta con el usuario `developer` (no root)
- **Permisos Docker**: El `postCreateCommand` configura permisos para Docker socket
