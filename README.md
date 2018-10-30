# graphql-java
graphQL implementation using Java spring boot

## GraphQL vs REST?
There are tons of article out there but I recommend reading this: https://blog.apollographql.com/graphql-vs-rest-5d425123e34b

### This repo serves as demo how to implement graphQL for one our fav programming language Java.

1) Clone repo & run
2) open: http://localhost:8080/graphiql

### Usage

#### Query for owner details with sub Object "pet"
         {
            owner{
             name,
             address,
             id,
             pets {
               name
             }
           }
         }

#### Query Owner details using fragment
        {
           owner{
            ...ownerDetails
          }
        }
        fragment ownerDetails on Owner {
            id
            name
            address
        }
  
#### Create Pet using mutation request
      mutation createPet {
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
      }

#### Create pet using variable, make sure to define variable in GraphiQL for playground
    mutation createPet($petName: String) {
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

#### Modularize your graphqls file by using SchemaParser class
    graphql-java-tool automatically scan "**/*.graphqls" files in your resource folder
    most of the time you don't need to explicitly define them, incase the current implementation from their doc
    in your spring boot add we can add :
    
    @Bean
    public GraphQLSchema schema() {
        return SchemaParser.newParser()
                .files("petshop.graphqls", "Types.graphqls", "InputTypes.graphqls")
                .resolvers(new Query(), new Mutation(), new Subscription(new NewsPublisher()))
                .scalars(new ScalarDate())
                .dictionary("WeirdPet", WeirdPet.class)
                .build().makeExecutableSchema();
    }
    
             
#### Creating scalar data type
    1) define scalar in your schema 
    
    scalar Date
    
    2) Create class for that type
        - see the ScalarDate class in this sample
        
    3) Create coercing instance or class to implement serialization & deserialization
        - see the ScalarDateCoercing class in this repo.    
        
#### Union type
    Make sure define atleast 1 query or mutation request for every type in union
    I created ticket for this one: https://github.com/graphql-java-kickstart/graphql-java-tools/issues/200
    you can query using:
    
    {
      pets{
      ... on NormalPet {
        id
      }
      ... on WeirdPet {
         sssname
      }
      }
    }
    

#### Coercing notes: 
    source: https://github.com/graphql/graphql-js/issues/500
serialize: gets invoked when serializing the result to send it back to a client.

parseValue: gets invoked to parse client input that was passed through variables.

parseLiteral: gets invoked to parse client input that was passed inline in the query.


