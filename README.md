#Prueba Técnica

Customers es una aplicación sencilla que sirve para crear y consultar clientes (customers). Se desarrolló con Java y Spring Boot.
Se usó Hibernate para el tema de la base de datos ya que esta tiene una función para poder crear las tablas con respecto a las entidades.
Cuando la aplicación arranca, Hibernate revisa esa clase y crea la tabla automáticamente, con una columna por cada dato. Esto se activa con una sola línea en el archivo de configuración:
spring.jpa.hibernate.ddl-auto=update

Se usa una base de datos llamada H2, que vive dentro de la propia aplicación y no requiere instalar nada. Por eso los datos se borran cada vez que se apaga.

La aplicación se entrega de dos maneras:
Con el .jar: el archivo app.jar junto con application-dev.properties y application-prod.properties.
Con Docker: el archivo customers.tar (la imagen ya creada), los archivos dev.env y prod.env, y los archivos docker-compose-dev.yml y docker-compose-prod.yml.
Los archivos properties y env guardan la configuración de cada ambiente (desarrollo o producción).
Ejecución .jar
Primero se genera el archivo app.jar (esto lo hace quien desarrolla):
./gradlew clean bootJar

Luego se ejecuta indicando el ambiente. Para desarrollo:
java -jar app.jar --spring.profiles.active=dev

Para producción:
java -jar app.jar --spring.profiles.active=prod

La parte --spring.profiles.active le dice a la aplicación cuál archivo de configuración usar.

Ejecución con Docker
Primero, quien desarrolla crea la imagen y la guarda en un archivo .tar:
./gradlew clean bootJar
docker build -t customers:1.0.0 .
docker save -o customers.tar customers:1.0.0

Quien recibe la entrega carga la imagen una sola vez:
docker load -i customers.tar

Y después levanta el ambiente que necesite. Para desarrollo:
docker compose -f docker-compose-dev.yml up -d

Para producción:
docker compose -f docker-compose-prod.yml up -d
