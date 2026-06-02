# Sistema de Búsqueda de Recursos de Biblioteca

Permite consultar la disponibilidad de libros o recursos en una biblioteca.

## Pseudocódigo

```text
Inicio
    Leer datos del usuario
    Buscar recurso

    Si existe Entonces
        Si está disponible Entonces
            Mostrar "Disponible"
        Sino
            Mostrar "No disponible"
        FinSi
    Sino
        Mostrar "No existe"
    FinSi
Fin
