# Microservicios
La arquitectura basada en microservicios puede tener tantas capas, servicios o componentes, como se requieran. Generalmente, las capas básicas de esta arquitectura son: API Gateway, Service Discovery, Servicios y sus correspondientes bases de datos

# Docker 
Comandos Importantes:
docker images → Muestra todas las imágenes conocidas
docker ps → Muestra todos los contenedores en ejecución
docker run -p PORT:PORT image_name → Ejecuta una imagen Docker dentro de un contenedor creado según las especificaciones de la imagen en sí misma.
docker stop <CONTAINER_ID> → Para la ejecución del contenedor con la ID introducida

# Pasos
Creación de Imágenes mediante <Dockerfile>
El siguiente paso, es algo más avanzado, y requiere del uso de una herramienta más compleja llamada <Docker-compose>. es la mejor opción, y el archivo <Docker-compose> contiene la estructura.