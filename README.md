# taxCalculation


# api to add product 

curl --location 'http://localhost:8080/api/items/add' \
--header 'Content-Type: application/json' \
--data '{
    "name": "chair",
    "price": 12.49,
    "isImported": true,
    "category": "OTHER"
}'



#api to add bulk products

curl --location 'http://localhost:8080/api/items/bulk-add' \
--header 'Content-Type: application/json' \
--data '[
    {
        "name": "book",
        "price": 12.49,
        "isImported": false,
        "category": "BOOK"
    },
    {
        "name": "music CD",
        "price": 14.99,
        "isImported": false,
        "category": "OTHER"
    },
    {
        "name": "chocolate bar",
        "price": 0.85,
        "isImported": false,
        "category": "FOOD"
    }
]
'





# generate bill api 

curl --location 'http://localhost:8080/api/items/receipt' \
--header 'Content-Type: application/json' \
--data '[
    {
        "name": "book",
        "price": 12.49,
        "isImported": false,
        "category": "BOOK"
    },
    {
        "name": "music CD",
        "price": 14.99,
        "isImported": false,
        "category": "OTHER"
    },
    {
        "name": "chocolate bar",
        "price": 0.85,
        "isImported": false,
        "category": "FOOD"
    }
]
'


