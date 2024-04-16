# Laravel con un cliente Android
Este repositorio contiene un ejemplo sencillo de cómo usar Laravel y conectarlo con un cliente Android. 

## ¿Qué necesitamos para realizar el ejericicio?
Para realizar el ejercicio necesitamos:

- **XAMPP:** [Descargar XAMPP](https://www.apachefriends.org/es/download.html)
- **Composer:** [Descargar Composer](https://getcomposer.org/download/​)
- **Visual Studio Code:** [Descargar VSCode](https://code.visualstudio.com)
- **Android Studio:** [Descargar Android Studio](https://developer.android.com/). De este en específico, para realizar el ejercicio usamos la versión Flamingo, así que, para evitar conflictos a causa de los cambios en las versiones, les recomendamos descargar esa versión.
- **Recursos de imagen:** [Descargar los recursos de imagen](https://shorturl.at/pRVY5)

## Intrucciones de uso del código
Si desean usar directamente el código que está proporcionado aquí, entonces hay que hacer un cambio muy importante en uno de los archivos. Hay que ir al archivo llamado Config.java de la parte de Android, y modificar la línea 10, que es la que sigue:

```java
public static final String BASEURL = "http://192.168.1.66/arequipa/public/api/";
```

Es necesario cambiar el valor de BASEURL para que contenga la dirección en la que su servidor está corriendo, pues ahí aparece la que teníamos nosotros en una red específica, y, como ya bien sabrán, la dirección será diferente para ustedes cuando corran el código en sus propias computadoras. Por ejemplo, si su servidor está corriendo en http://192.168.1.32, hay que modificar BASEURL para que, en lugar de que sea "192.168.1.66", sea "192.168.1.32". 

Suponiendo que hicieran todo lo demás igual (incluso nombrar a la base de datos de la misma manera), ese debería ser el único cambio necesario para usar directamente el código que hemos proporcionado.

*Para ir al archivo del que hablamos en este repositorio, da clic aquí: [**Config.java**](https://github.com/LuzR25/Ejercicio_Laravel/blob/ace221c03644afdc7a2a0aef04dd4a00474b0bce/Parte%20de%20Android/Multichat/app/src/main/java/com/example/multichat/Config/Config.java)

## Link de la exposición
[Laravel con cliente Android](https://alumnosuady-my.sharepoint.com/:p:/g/personal/a20216883_alumnos_uady_mx/EbCLaK84xu1MoYY4FrBKHAABI9qQ-Z1_nmNBb6XTWz3nMQ?e=n6FNYV)

## Video del ejercicio
Si desean revisar cómo hacer el ejercicio directo de la persona a la que seguimos, pueden checar este [video](https://youtu.be/O6oTOMbhKvQ?si=UjbdT8ZkOIwkECsO), pero sí es importante mencionar que algunas cosas que hace ya son obsoletas, así que estaría mejor que se basaran del código que ya les proporcionamos para evitar errores.

## Integrantes del equipo
- Luz Rocío García Peña
- Angel David Ricalde Ché
