# BB Java Developer Test

> This is a simple test to show us how awesome you are!

Your task is to build a super fast Java powered web service to:

- Store products from a web request
- Retrieve products from a web request
## API document
`http://localhost:8080/swagger-ui.html#/`

## API Details

API Requests examples: 

`https://github.com/BookingBoss/java-test/blob/master/GetProducts.json`
`http://localhost:8080/api/v1/products`
```
{
  "id": "(string) unique id of the event",
  "timestamp": "(timestamp) utc timestamp of the event",
  "products": [
    {
      "id": "(long) id of the product"
    }
  ]
}

```

`https://github.com/BookingBoss/java-test/blob/master/PutProducts.json`
`https://localhost:8080/api/v1/products`

```
{
  "id": "(string) unique id of the event",
  "timestamp": "(timestamp) utc timestamp of the event",
  "products": [
    {
      "id": "(long) id of the product",
      "name": "(string) name of the product",
      "quantity": "(integer) quantity of the product",
      "sale_amount": "(double) total sale amount"
    }
  ]
}

```
## Requirements

- Good code quality
- Good component structure
- Use Hibernate for storage
- 100% Test coverage
- Use Maven or Gradle

## Optional

- Add authentication

## Notes

Feel free to use any kind of libraries or frameworks to help you achive your task

## Deliverable

Send us your repository URL. Your code will be reviewed and we may ask questions through an email.

When we pull your code let us know how to execute your code



