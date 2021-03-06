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
                            "name" : "Brownies",
                            "price" : 2.75
                        },
                        "quantity": 1
                    }
                ]
        }''')
        headers {
            contentType(applicationJson())
        }

    }

    response{
        status NOT_ACCEPTABLE()

        body([
            status: 406,
            message: "Order can't be accepted, please choose an item!"
        ])

        headers {
            contentType(applicationJson())
        }
    }
}