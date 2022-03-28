# Credit Card code challenge

## Description

Two REST Endpoints must be implemented
•	"Add" will create a new credit card for a given name, card number, and limit
o	Card numbers should be validated using Luhn 10
o	New cards start with a £0 balance
o	for cards not compatible with Luhn 10, return an error

•	"Get all" returns all cards in the system


## Solution

Two endpoints 

Post: http://localhost:8080/api/v1/card 
Add card to DB

Get http://localhost:8080/api/v1/cards
Get all cards saved in DB



*Input*
`HTTP POST /card 
{
    "holderName":"abhilash",
    "ccardNumber":"12345678913",
    "cardlimit":"10000",
    "balance":"0"
    
}

*Output*
`201 
{
    "timestamp": "2022-03-22 06:18:18",
    "status": 201,
    "message": "Success",
    "listofCards": null
}

`HTTP GET /cards
*Output*
{
    "timestamp": "2022-03-22 06:19:45",
    "status": 200,
    "message": "Success",
    "listofCards": [
        {
            "id": 1,
            "cardNumber": "12345678911",
            "name": "abhilash",
            "balance": 0.00,
            "limit": 10000.00
        }
    ]
}


## Considerations
- Test cases are created based on new considerations
- limit is taken as 10000
- Spring boot is used to create the application

## Git Repo
https://github.com/digilabcloudhub/credit-card-assignment/tree/master




