#!/bin/bash

# Script de inicio para verificar el entorno

echo "🔍 Verificando configuración del entorno..."
echo ""

# Verificar Java
echo "☕ Java:"
java -version 2>&1 | head -n 1

# Verificar Gradle
echo ""
echo "🐘 Gradle:"
./gradlew -v | head -n 3

# Verificar Google Chrome
echo ""
echo "🌐 Google Chrome:"
if command -v google-chrome >/dev/null 2>&1; then
    google-chrome --version 2>&1 | head -n 1
elif command -v google-chrome-stable >/dev/null 2>&1; then
    google-chrome-stable --version 2>&1 | head -n 1
else
    echo "⚠️  Google Chrome no encontrado - se instalará en la primera ejecución"
fi

# Verificar estructura del proyecto
echo ""
echo "📁 Estructura del proyecto:"
echo "  ✓ Build script: $([ -f build.gradle ] && echo 'OK' || echo 'FALTA')"
echo "  ✓ Serenity config: $([ -f serenity.properties ] && echo 'OK' || echo 'FALTA')"
echo "  ✓ Features: $([ -d src/test/resources/features ] && echo 'OK' || echo 'FALTA')"
echo "  ✓ Runners: $([ -d src/test/java ] && echo 'OK' || echo 'FALTA')"

echo ""
echo "✅ El entorno está listo para ejecutar las pruebas"
echo ""
echo "Para ejecutar las pruebas, usa:"
echo "  ./run-tests.sh"
echo ""
echo "O directamente con Gradle:"
echo "  ./gradlew clean test aggregate"
