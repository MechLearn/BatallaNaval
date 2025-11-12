# BatallaNaval
Proyecto Final de Informatica

Proyecto modular desarrollado en Java y Spring Boot, que implementa un sistema distribuido del juego Batalla Naval, con gestión de jugadores, partidas y lógica interna de tableros.

Estructura del repositorio
BatallaNaval/
│
├── sistema_jugador/           → API para registro y login de jugadores (Spring Boot)
├── sistema_juegos/            → API para creación y unión a partidas
├── sistema_partida/           → Lógica de turnos y validación de disparos
├── sistema_batalla_naval/     → Motor interno del juego (modelos, lógica de tablero)
└── README.md                  → Documentación general

# Tecnologías utilizadas


Spring Boot (para los módulos con API REST)

Maven (gestión de dependencias y build) # opcional, pero recomendado para la implementacion

Git & GitHub (control de versiones)

IntelliJ IDEA / Eclipse

# Ejecución básica

Clonar el repositorio
git clone https://github.com/TU_USUARIO/BatallaNaval.git
cd BatallaNaval
Compilar con Maven
mvn clean install

Ejecutar el módulo deseado
Ejemplo para el sistema de jugadores:
cd sistema_jugador
mvn spring-boot:run


git checkout -b sistema_jugador


Subir cambios

git add .
git commit -m "Implementa API de login y registro"
git push origin sistema_jugador


Crear un Pull Request hacia la rama main y esperar revisión.

# Notas

Los módulos que requieran comunicación entre cliente y servidor se desarrollan con Spring Boot.

Los módulos de lógica interna se implementan en Java puro.

Todos los proyectos usan Maven para mantener compatibilidad entre módulos.
