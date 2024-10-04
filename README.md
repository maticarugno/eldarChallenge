# Eldar Challenge

## Resolucion:

### Ejercio 1: 
Para probarlo local hay que descomentar las dos lineas de codigo en EldarChallengeApplication.
Al levantar la app, se podra navegar por el menu interactivo.

### Ejercio 2:
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

### Ejercicio 3

El patron de diseño que elegiria es el Observer. De esta manera, cuando una camara modifique su imagen podra notificar 
al sistema sobre el cambio, sin que este esté constantemente consultado el estado de la camara, disminuyendo al minimo el ancho de banda utilizado.


### Ejercio 4

Cree el siguiente algoritmo para resolver el ejercicio. Para el gasto total de cada dia
hago la sumatoria de los gastos de los d dias anteriores, lo divido por d para obtener el promedio,
multiplico por dos como pide el ejercicio y aumento la cantidad de avisos si el gasto del dia supera ese limite
```
public int calcular(List<Integer> gastos, int cantDias){
        int cantAvisos = 0;
        for (int i = 0; i < gastos.size(); i++){
            if (i+1 > cantDias){
                int sumaGastoDias = gastos.subList(i-cantDias, i).stream().reduce(0, Integer::sum);
                int limiteAviso = (sumaGastoDias/cantDias) * 2;
                if (gastos.get(i) >= limiteAviso){
                    cantAvisos++;
                }
            }
        }
        return cantAvisos;
    }
```
