Para probar la aplicación seguir los seguientes pasos:

 - Correr la aplicación como una aplicación de Spring Boot.
 - Consumir los endpoints que tiene la api rest. Esta aplicación cuenta con dos endpoints que son los siguientes:

    1- http://localhost:9000/entity/user/saved
       - Método: POST
       - En el cuerpo se envía un JSON con el formato indicado en la prueba técnica.
       - El resultado: Un objeto de usuario o un mensaje de error.       

    2- http://localhost:9000/entity/user/login?email=email_value&password=password_value
       - Método: GET
       - En la misma URL se indican los parámetros de email y password para el inicio de sesión.
       - El resultado: Un mensaje que indica si hubo un error o todo salió correcto.