#!/bin/bash

# Script para ejecutar las pruebas de Serenity BDD

echo "🚀 Ejecutando pruebas de Serenity BDD..."

# Limpiar builds anteriores
./gradlew clean

# Ejecutar las pruebas (aggregate se ejecuta automáticamente después de test)
./gradlew test

# Verificar si las pruebas se ejecutaron exitosamente
if [ $? -eq 0 ]; then
    echo "✅ Pruebas completadas exitosamente"
    echo "📊 Reporte interactivo generado en: target/site/serenity/index.html"
    echo "🌐 Abre el reporte con: \$BROWSER file://\$PWD/target/site/serenity/index.html"
else
    echo "❌ Las pruebas fallaron"
    exit 1
fi
