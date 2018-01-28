# Rental Bike
# Tecnologías
Lenguaje: Java 8 

Librerías: 
Junit 4.12
AssertJ 3.8.0
cobertura 2.7
 
### Detalles

La aplicacion expone un servicio denominado RentBikeServices inyectando 
el repositorio PriceRepository con un strategy para el calculo 
de la renta de las bicicletas para los casos "regulares" y las "promociones".
La mayoria de las clases inyectan dependencia mediante constructores.
No se utilizan frameworks para el funcionamiento del set de class


Ejecucion de los test
Descargar el proyecto y usando maven executar: **mvn clean test**

Cobertura

Se utiliza la libreria cobertura para el reporte : ** mvn cobertura:cobertura -e -X
el reporte que genera cobertura se encuenta en {project}/rental-bike/target/site/cobertura/index.html



