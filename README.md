#  PokeApi

This project is designed to interact with the Pokemon API ([PokeAPI](https://pokeapi.co/)) to fetch and show information about Blaziken pokemon, it's description, basic points and, weaknesses. 

The project was created using Spring Boot.
 
## Architecture

### Folder structure
```
project-root/ 
├── mvn / # Folder with maven dependencies 
├── src 
│ ├── main
│ │ ├── java/com/mfcc/poke/data/
│ │ │ ├── client/ # Folder with project client 
│ │ │ ├── models/ # Folder with project models 
│ │ │ ├── controller # Folder with project controller
│ │ │ └── PokemonApplication.java # Java entry file
├── .gitignore # Git ignore file 
├── README.md # The main README file 
├── mvnw.cmd
├── mvnw
└── pom.xml
```

## Quick start

 ### Run project

 - Go to the PokeApi project folder: `cd PokeApi`
 - Run with: `mvn spring-boot:run`
