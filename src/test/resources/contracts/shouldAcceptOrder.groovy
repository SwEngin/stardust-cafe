package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request{
        method "POST"
        url "/orders"
        body('''{
                "items": [
                    {
                        "product":
                        {
                            "name" : "Espresso",
                            "price" : 2.75
                        },
                        "quantity": 1
                    },
                    {
                        "product":
                        {
                            "name" : "Croissant",
                            "price" : 2.45
                        },
                        "quantity": 1
                    }]
        }''')
        headers {
            contentType(applicationJson())
        }

    }

    response{
        status OK()
        body('''{
                "items": [
                        {
                            "product":
                            {
                                "name" : "Espresso",
                                "price" : 2.75
                            },
                            "quantity": 1
                        },
                        {
                            "product":
                            {
                                "name" : "Croissant",
                                "price" : 2.45
                            },
                            "quantity": 1
                        }
                ],
                "message": "Thanks for your order, see you soon!",
                "total": 5.20
        }''')
        headers {
            contentType(applicationJson())
        }
    }
}