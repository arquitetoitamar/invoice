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
{
 "name" :"teste",
 "price" :"100"
}

</br>
### Criando Nota Fiscal
curl POST http://localhost:9000/invoice </br>
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
      "document": "35449026803",
      "nickname": "",
      "note": "",
      "createDate": "2017-02-23T03:19:58.015Z",
      "invoices": null
    },
    "company": {
      "id": 1,
      "name": "itamar Rocha",
      "email": null,
      "phone": null,
      "cel": null,
      "address": null,
      "cnae": null,
      "document": "35449026803",
      "nickname": null,
      "note": null,
      "createDate": null,
      "invoices": null
    },
    "items": null
  
