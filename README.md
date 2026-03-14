## Rama con cambios requeridos para el parcial

# Proyecto RabbitMQ - Parcial 1

Este proyecto es un sistema de mensajería de transacciones bancarias que conecta una API externa con una base de datos en AWS mediante **RabbitMQ**.

---

## ¿Cómo funciona?

El sistema está dividido en dos partes principales para separar la descarga de datos del envío final:

### 1. El Productor (`main.java`)
Es el encargado de "traer" la info. 
* Hace un **GET** a la API para bajar el lote de transacciones.
* Separa las transacciones por banco y las mete en su respectiva cola en RabbitMQ (`BI`, `BANRURAL`, `BAC`, `GYT`).
Aquí ya se les inyecta mi nombre y carnet al JSON para que viajen completos.

### 2. El Consumidor (`mainConsumer.java`)
Es el que "despacha" los datos.
* Se queda escuchando todas las colas de RabbitMQ.
* Cuando llega una transacción, hace el **POST** hacia la API de Amazon.
* **Manejo de errores:** Si el POST falla, el mensaje no se borra de la cola y así no perdemos ninguna transacción si el servidor se cae.

---

## Requisitos
* **Java 11** o superior.
* **RabbitMQ**.
* Librerías: `Jackson` para manejar los JSON y `amqp-client` para RabbitMQ.

---

## Ejecución rápida

1. **Clonar el repo** y abrirlo en Eclipse.
2. **RabbitMQ:** Asegúrate de que el server de Rabbit esté encendido.
3. **Paso A:** Correr `main.java`. Esto llenará las colas en RabbitMQ.
4. **Paso B:** Correr `mainConsumer.java`. Verás en consola cómo se van enviando a Amazon y las colas se van vaciando.

---

*Hecho para el Parcial 1 de Programación III.*
