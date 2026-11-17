# Changelog - Sistema de Inventario

Todos los cambios importantes de este proyecto se documentan en este archivo.
El formato se basa en [Keep a Changelog](https://keepachangelog.com/es-ES/1.1.0/)
y el proyecto usa [Versionamiento Semántico](https://semver.org/lang/es/).

## [v1.0.2] - 2026-11-17
### Corregido
- `getPrecio()` vuelve a devolver el precio base del producto (se revirtió el cálculo con IVA que rompía las pruebas).
### Agregado
- Archivo `CHANGELOG.md` con el historial de versiones.

## [v1.0.1] - 2026-11-17 (fallida, no publicada)
### Cambiado
- `getPrecio()` devolvía el precio con IVA (16 %) incluido.
### Problema detectado
- La prueba `getPrecio devuelve 450.0` falló en el pipeline de liberación.
- El workflow se detuvo en "Ejecutar pruebas" y **no se creó el Release** ni el paquete.

## [v1.0.0] - 2026-11-17
### Agregado
- Registro de productos (`Producto`: código, nombre, precio, existencia).
- Búsqueda de productos por código y por nombre (`BusquedaProductos`).
- Mensaje de estado "Producto registrado y disponible".
- Workflows de GitHub Actions: Build, Pruebas y Liberación.
- Paquete `sistema-inventario-v1.0.0.zip` (JAR ejecutable + código fuente).
