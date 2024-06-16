# prueba-Daniel-Juliao
** Requisitos **
Se usa java 21
Maven 3
sql server 
 

# 1- Diseño de una solución en bases de datos

 ![Texto alternativo](https://github.com/Farius-red/prueba-daniel-Juliao/blob/master/imgDocumentacion/ER.png)

# Prueba de cobertura

imagen prueba de covertura de text unitarios junit y mockito 

![Texto alternativo](https://github.com/Farius-red/prueba-daniel-Juliao/blob/master/imgDocumentacion/jacoco.png)

# Arquitectura 


![Texto alternativo](https://github.com/Farius-red/prueba-daniel-Juliao/blob/master/imgDocumentacion/arquitectura.png)

En el paquete de infraestructura  esta la logica del negocio separada por dos paquetes

**paquete primary**
Este se encarga de implementar toda la logica de negocio

**paquete secundary**
Este se encarga de interactuar con la base de datos


## Proceso de installacion y ejecucion sin ide

**paso 1**  descargar repositorio

**paso 2** entrar ala carpeta prueba

**paso 3**  instalar en maquina local jdk 21

**paso 5**   instalar sqlserver

**paso 7** crear una  base de datos



**paso 6** instalar maven

**paso 7**  ubicarse en la consola en la carpeta prueba

**paso 8**  ejecutar mvn clean  install 



![Texto alternativo](https://github.com/Farius-red/mcs-financial/blob/master/imgDocumentacion/creaciondeJar.png)

**una salida en la terminal  similar a esta**


**paso  9**  copar la ruta que aparece en lo resaltado en blanco

**paso 10**  ejecutar  la ruta que copiamos sin la parte final del .jar
cd  /home/daniel-juliao-sistem/Documentos/desarrollo/backend/mcs-financial/target/

es un ejemplo para poder correrlo localmente las carpetas tienen q ser en la ubicacion en la que se descarga y cambiando las rutas 




**paso 11**
java
-DDB_HOST=aqui host de su base dedatosvlocal;
-DDB_PORT=aqui el puerto de conexión;
-DDB_DATABASE=nombre de la base de datos ;
-DDB_USERNAME=su usuario ;
-DDB_PASSWORD=su contraseña  -jar "aqui el nombre del jar"

**esto ejecutara la aplicación**





**paso 13** 


ir a google y poner esta url
http://localhost:8080/documentacion

**Debe aparecer la interfase visual  de swagger**


# Correr proyecto con intelliJ Idea

se requiere agregar en variables de ambiente

DB_HOST= url de conexion;
DB_PORT=su puerto;
DB_DATABASE=su nombre de base de datos;
DB_USERNAME=su usuario ;DB_PASSWORD=aqui la clave

**adjunto imagen  referencia**

![Texto alternativo](https://github.com/Farius-red/mcs-financial/blob/master/imgDocumentacion/intelliJ.png)

# Curl enpoint 

**crear credito** 

 curl -X POST \
  http://localhost:8080/creditos/add \
  -H 'Content-Type: application/json' \
  -d '{
        "cliente": {
            "id": 1,
            "tipoDocumento": "CC",
            "numeroDocumento": "1014267700",
            "apellidos": "juliao nova",
            "residencia": "bogota",
            "ciudad": "bogota",
            "telefono": "3186877469",
            "informacionLaboral": {
                "nitEmpresa": "1700200-6",
                "nombreEmpresa": "prueba",
                "direccion": "carrera 141a# 144 58",
                "telefono": "3186877469",
                "cargo": "desarrollador",
                "fechaVinculacion": "2023-06-15 14:30"
            },
            "referenciasFamiliares": [
                {
                    "nombre": "dani",
                    "direccion": "carrera 142",
                    "telefono": "3186874774",
                    "ciudad": "bogota",
                    "email": "daniel.juliao.tecni@gmail.com",
                    "parentesco": "hermano"
                }
            ],
            "referenciasPersonales": [
                {
                    "valor": "prueba",
                    "direccion": "carrera 128 #18-20",
                    "telefono": "3186899901",
                    "ciudad": "Bogota",
                    "email": "prueba.tecni@gmail.com"
                }
            ]
        },
        "credito": {
            "valor": 3000000,
            "plazo": 72,
            "descripcionDestino": "compra de productos",
            "aprobado": false,
            "lineaCredito": {
                "nombre": "libre Inversion",
                "valorMinimo": 100000,
                "valorMaximo": 5000000,
                "plazoMaximo": 72
            }
        }
    }'

**obtener lista de  credito** 
curl -X GET \
  http://localhost:8080/creditos/all \
  -H 'Content-Type: application/json'

**crear Cliente** 

  curl -X POST \
  http://localhost:8080/cliente/add \
  -H 'Content-Type: application/json' \
  -d '{
        "id": 1,
        "tipoDocumento": "CC",
        "numeroDocumento": "1014267700",
        "apellidos": "juliao nova",
        "residencia": "bogota",
        "ciudad": "bogota",
        "telefono": "3186877469",
        "informacionLaboral": {
          "nitEmpresa": "1700200-6",
          "nombreEmpresa": "prueba",
          "direccion": "carrera 141a# 144 58",
          "telefono": "3186877469",
          "cargo": "desarrollador",
          "fechaVinculacion": "2023-06-15 14:30"
        },
        "referenciasFamiliares": [
          {
            "nombre": "dani",
            "direccion": "carrera 142",
            "telefono": "3186874774",
            "ciudad": "bogota",
            "email": "daniel.juliao.tecni@gmail.com",
            "parentesco": "hermano"
          }
        ],
        "referenciasPersonales": [
          {
            "valor": "prueba",
            "direccion": "carrera 128 #18-20",
            "telefono": "3186899901",
            "ciudad": "Bogota",
            "email": "prueba.tecni@gmail.com"
          }
        ]
      }'



## Front

Desarrollado en angular requisitos para correrlo 

node  v20.14.0
npm version  10.7.0 
angular version  17


**paso 1** 
ir ala carpeta front template-test-ng  
ejecutar npm install 


**paso 2** 
ir ala carpeta front/template-test-ng/projects/template-test-ng/
ejecutar npm install 
ejecutar ng build template-test-ng 


**paso 3** 
ir ala carpeta front/template-test-ng/projects/test-app-ng
ejecutar ng serve 

