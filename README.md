# LAB01-AREP

## Integrantes:
- Jaime Nicolás Castro Acuña

### Servivicio desplegado en Heroku:
Para acceder ingrese a [Link](https://cryptic-garden-77476.herokuapp.com/)

### Proyecto almacenado en github:
Para acceder ingrese a [Link](https://github.com/Nicolascastro25/LAB01-AREP.git)

## Diseño

Tenemos dos paquetes, y cinco clases:

![image](https://user-images.githubusercontent.com/25957863/187829255-a9301497-75f1-4606-88f8-d52465e7f701.png)

- edu.escuelaing.arep
- edu.escuelaing.arep.entidades

En el primer paquete tenemos la clase HttpConnection en donde tenemos unos métodos "getApiAlpha" y "getApiPolygon" allí creamos el query de consulta del API, en especifico esto se realiza con un generador de querys diseñado en el paquete edu.escuelaing.arep.entidades. 

![image](https://user-images.githubusercontent.com/25957863/187831835-21d66a57-4e2c-4135-ad4a-000ac9b41b45.png)

En esta clase además tenemos un método denominado getStock() que nos permite realizar (abrir) la conexión Http, realizando paralelamente la validación de la conexión exitosa. En getStock() leemos cada una de las lineas del API y las almacenamos en un StringBuffer a imprimir, y en un HashMap para hacer un control por caché. 
El query se convierte en la llave de nuestro HashMap, y los valores Json obtenidos por el query se convierten en los calores correspondientes de nuestras claves.

![image](https://user-images.githubusercontent.com/25957863/187831784-ac045c53-2313-43ba-a4dd-e40b166193c3.png)

En el primer paquete también tenemos la clase SparkWebJava en donde tenemos las funciones Lambda que serán usadas para la consulta del API. Esta clase en específico se encarga de tomar los datos ingresados en el FrontEnd y procesarlos con las clases creadas en el Backend de nuestro aplicativo. Algunas de ellas son:

![image](https://user-images.githubusercontent.com/25957863/187785733-a031039c-2fa9-41c8-8782-290d31881dd7.png)

En el segundo paquete tenemos la clase QueryAlpha y QueryPoly que son las encargadas de generar los query de consulta.

### QueryAlpha:

![image](https://user-images.githubusercontent.com/25957863/187832064-8332ce8b-5d0d-4fc0-b032-982a43d376df.png)

### QueryPoly:

![image](https://user-images.githubusercontent.com/25957863/187832171-3b13ee57-6265-485c-b7d2-2ffe510af928.png)

También tenemos en este paquete la clase Cache que es la encargada de almacenar las consultas realizadas durante el uso del aplciativo.

![image](https://user-images.githubusercontent.com/25957863/187832235-e632ea22-d5c3-4b1d-96b6-7f3deb04c992.png)

## Extensión

Para realizar la extensión de nuestra aplicación bastaría con crear en el paquete "edu.escuelaing.arep.entidades" una nueva clase Query+"nombre" para la URL de los nuevos API's a consultar, con esto para la creación del Query solo bastaría con determinar el API a consultar para traer la informacón requerida.

## Manual de usuario

Debemos rellenar cada uno de los input (es obligatorio), dando submit verémos una pequeña confirmación de la información enviada.

![image](https://user-images.githubusercontent.com/25957863/187833399-2d128795-f0e7-4933-8667-95e6e53a18dc.png)

Para ver la información damos en la opción: "Presione para mirar el query".

![image](https://user-images.githubusercontent.com/25957863/187833451-708a70f6-791b-41b9-9b75-17f94272dec9.png)

Funcionando de la misma manera para la consulta en APIPolygon

![image](https://user-images.githubusercontent.com/25957863/187833549-ccc167c2-6f55-4def-8f93-11ff30d7fce1.png)
