# Rental Bike
Lenguaje: Java

# Librerías: 
Junit 4.12
AssertJ 3.8.0
cobertura 2.7
 
### Detalles

La aplicacion expone un servicio denominado RentBikeServices inyectando 
un repositorio el cual oculta la implementacion de la logica de acceso a los 
datos.
La implementacion de esta capa de servicios permite la organizacion en un inventario
de servicios que pueden ser catalogados para una funcion particular.
El repositorio PriceRepository utiliza un strategy que encapsula los algoritmos
para el calculo de la renta de las bicicletas para los casos "regulares" y las "promociones".


# Ejecucion de los test
Descargar el proyecto y usando maven executar: **mvn clean test**

Cobertura

Se utiliza plugin cobertura para el reporte : **mvn cobertura:cobertura**
generando el reporte en la sig ubicacion : ${project}/rental-bike/target/site/cobertura/index.html



