# graphql-java
graphQL implementation using Java spring boot

## GrapQL vs REST?
There are tons of article out there but I recommend reading this: https://blog.apollographql.com/graphql-vs-rest-5d425123e34b

### This repo serves as demo how to implement grapQL for one our fav programming language Java.

1) Clone repo
2) open: http://localhost:8080/graphiql

### Usage

#### Query for owner details with sub Object "pet"
   `{
      owner{
       name,
       address,
       id,
       pets {
         name
       }
     }
   } `  

#### Query Owner details using fragment
  `{
     owner{
      ...ownerDetails
    }
  }
  fragment ownerDetails on Owner {
      id
      name
      address
  }`
  
#### Create Pet using mutation request
`mutation createPet {
  createPet(name: "Pot pot", age: 1, type: CAT,
   owner: {
      name:"John Doe"
    }) {
    id,
    name,
    type,
    owner {
      name
    }
  }
}`

#### Create pet using variable, make sure to define variable in GraphiQl for playground
    `mutation createPet($petName: String) {
       createPet(name:$petName, age: 1, type: CAT,
        owner: {
           name:"John Doe"
         }) {
         id,
         name,
         type,
         owner {
           name
         }
       }
     }

`

