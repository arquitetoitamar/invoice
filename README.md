# Invoice
<p>Aplicação REST para emissão de notas fiscais</p>

## Instalação
`git clone` </br>
`cd invoice`  </br>
`mvn clean install` </br>
`java -jar target/backoffice.jar`

## Api's - Funcionalidade

### Criando Mercadoria
curl POST http://localhost:9000/item </br>
```
{
 "name" :"teste",
 "price" :"100"
}
```
</br>
### Criando Nota Fiscal
curl POST http://localhost:9000/invoice </br>
```
{
    "id": 1,
    "orderDate": "2017-02-23T03:19:58.015Z",
    "orderStatus": null,
    "datePayment": null,
    "paymentStatus": null,
    "shippingDate": null,
    "shippingStatus": null,
    "total": null,
    "discount": null,
    "sinal": null,
    "cost": null,
    "statusProcess": "PROCESSED",
    "totalTaxes": null,
    "customer": {
      "id": 1,
      "name": "itamar",
      "email": "",
      "phone": "",
      "cel": "",
      "address": "",
      "gender": "",
      "document": "35449026829",
      "nickname": "",
      "note": "",
      "createDate": "2017-02-23T03:19:58.015Z",
      "invoices": null
    },
    "company": {
      "id": 1,
      "name": "Emprese tes",
      "email": null,
      "phone": null,
      "cel": null,
      "address": null,
      "cnae": null,
      "document": "15619120000115",
      "nickname": null,
      "note": null,
      "createDate": null,
      "invoices": null
    },
    "items": null
  }
```
## API URL's
### Nota Fiscal
  curl GET    http://localhost:9000/invoice </br>
  curl GET    http://localhost:9000/invoice?name=<Emissor ou Mercadoria> </br>
  curl POST   http://localhost:9000/invoice </br>
  curl PUT    http://localhost:9000/invoice/{id} </br>
  curl DELETE http://localhost:9000/invoice/{id} </br>
### Mercadoria
  curl GET    http://localhost:9000/item </br>
  curl GET    http://localhost:9000/item?name=<nome do item> </br>
  curl GET    http://localhost:9000/item/invoice/{idInvoice} - Buscar items por Nota fiscal </br>
  curl POST   http://localhost:9000/item </br>
  curl PUT    http://localhost:9000/item/{id} </br>
  curl DELETE http://localhost:9000/item/{id} </br>
### Empresa / Emissor
  curl GET    http://localhost:9000/company </br>
  curl GET    http://localhost:9000/company?name=<nome da empresa> </br>
  curl POST   http://localhost:9000/company </br>
  curl PUT    http://localhost:9000/company/{id} </br>
  curl DELETE http://localhost:9000/company/{id} </br>
### Customer
  curl GET    http://localhost:9000/customer </br>
  curl GET    http://localhost:9000/customer?name=<nome do cliente> </br>
  curl POST   http://localhost:9000/customer </br>
  curl PUT    http://localhost:9000/customer/{id} </br>
  curl DELETE http://localhost:9000/customer/{id} </br>
  
## Configuração
  Arquivo: application.properties </br>
  Porta: </br>
  server.port=9000 </br>
  
  Caso queira utilizar banco externo, descomentar keys com prefixo spring.datasource ex.: </br>
  #spring.datasource.url=jdbc:mysql://localhost:3306/invoice </br>
  #spring.datasource.username=user </br>
  #spring.datasource.password=pass </br>
  #spring.datasource.driver-class-name=com.mysql.jdbc.Driver </br>

# Front-end
  https://github.com/imktec/invoice-webapp/
