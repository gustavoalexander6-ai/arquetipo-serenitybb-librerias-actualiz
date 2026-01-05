# language: es

Característica: Login en Produnet

  Escenario: Login exitoso con token
    Dado que el cliente abre la Produnet web
    Cuando cliente ingresa su usuario y contrasenia correctas
    Y cliente obtiene el codigo de verificacion
    Entonces cliente valida que ingreso correctamente

  Escenario: Validar pantalla de token
    Dado que el cliente abre la Produnet web
    Cuando cliente ingresa su usuario y contrasenia correctas
    Entonces cliente valida que se vea la pantalla de token

  Escenario: Login con usuario incorrecto
    Dado que el cliente abre la Produnet web
    Cuando cliente ingresa su usuario incorrecto
    Entonces cliente valida se muestre un mensaje de error de usuario

  Escenario: Login con contraseña incorrecta
    Dado que el cliente abre la Produnet web
    Cuando cliente ingresa su contrasenia incorrecta
    Entonces cliente valida que se muestre un mensaje de error de contrasenia

  Escenario: Validar servicio Pokemon (REST Assured)
    Dado que el cliente abre la Produnet web
    Cuando cliente consulta las habilidades de pokemon con limite y offset
    Entonces cliente el servicio responde exitosamente