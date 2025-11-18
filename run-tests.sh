#!/bin/bash

# Script para ejecutar las pruebas de Serenity BDD

echo "🚀 Ejecutando pruebas de Serenity BDD..."

# Limpiar builds anteriores
./gradlew clean

# Ejecutar las pruebas
./gradlew test

# Verificar si las pruebas se ejecutaron exitosamente
if [ $? -eq 0 ]; then
    echo "✅ Pruebas completadas exitosamente"
    echo "📊 Reportes JSON generados en: target/site/serenity/"
else
    echo "❌ Las pruebas fallaron"
    exit 1
fi
