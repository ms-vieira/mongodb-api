# mongodb-api
Implementações de CRUD, associações entre objetos, referências e consultas com Spring Data e MongoRepository.

Repositório do projeto: ->https://github.com/msvieiraweb/mongodb-api

### Instruções para execução do projeto
- Clonar repositório.

- Importar o projeto em uma IDE

- Configurar o application.properties com a URI do Mongodb:

    ```Ex.: spring.data.mongodb.uri=mongodb://localhost:27017/app_mongodb ```
    - Caso não tenha o mongo instalado e estiver usando linux: 
    
        - Abrir o terminal e digitar:
        ``` docker pull mongo```
        ``` docker run -d -p 27017:27017 -p 28017:28017 -e AUTH=no mongo```
        ``` docker start id_container```
        ``` mongo```
        
        - Em seguida utilizar o MongoDB Compass para acessar e criar o banco:
        ``` app_mongodb```

- Run As -> WebStarter

