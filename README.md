# Eldar Challenge

## Resolucion:

### Ejericio 1: 
Para probarlo local hay que descomentar las dos lineas de codigo en EldarChallengeApplication.
Al levantar la app, se podra navegar por el menu interactivo.

### Ejericio 2:
La app esta desplegada en https://eldar-challenge-599a9eb4b432.herokuapp.com/

Dejo los curls de los cuatro endpoints solicitados:
- Crear una persona:
    
  - curl --location 'https://eldar-challenge-599a9eb4b432.herokuapp.com/personas' \
      --header 'Content-Type: application/json' \
      --data-raw '{
          "nombre": "jose",
          "apellido": "perez",
          "dni": "12345678",
          "fechaNacimiento": "1997-11-20",
          "email": "somemail@mail.com"
      }'

- Crear una tarjeta:
        
  - curl --location 'https://eldar-challenge-599a9eb4b432.herokuapp.com/tarjetas' \
          --header 'Content-Type: application/json' \
          --data '{
              "numeroTarjeta": "1234432112344321",
              "marca": "VISA",
              "fechaVencimiento": "2028-01-01",
              "cvv": "123",
              "persona": {"dni": "12345678"}
          }'

- Realizar una compra:
        
  - curl --location 'https://eldar-challenge-599a9eb4b432.herokuapp.com/compras' \
          --header 'Content-Type: application/json' \
          --data '{
              "tarjeta": {"numeroTarjeta": "1234432112344321"},
              "cvvIngresado": "123",
              "monto": 123,
              "detalle": "compra test"
          }'

- Consultar la tasa de una tarjeta sobre un importe:
        
  - curl --location 'https://eldar-challenge-599a9eb4b432.herokuapp.com/tasa/calcular?marca=amex&importe=1000'
