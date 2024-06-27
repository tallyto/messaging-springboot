# Projeto de Aprendizado Kafka com Spring

Este é um projeto de exemplo para demonstrar como usar o Apache Kafka com o Spring Framework. O projeto inclui configurações básicas para um produtor e consumidor de mensagens Kafka usando o Spring Kafka.

## Pré-requisitos

Antes de começar, certifique-se de ter instalado em sua máquina:

- Docker (para executar Kafka e Zookeeper via Docker Compose)
- Java Development Kit (JDK) 17 ou superior
- Maven (ou outra ferramenta de construção de sua escolha)

## Configuração do Ambiente

### Docker Compose

Para simplificar o ambiente de desenvolvimento, este projeto usa Docker Compose para executar o Kafka e o Zookeeper. Certifique-se de ter o Docker instalado e siga os passos:

1. Clone este repositório:

   ```
   git clone https://github.com/tallyto/messaging-springboot.git
   ```

2. Navegue até o diretório do projeto:

   ```
   cd seu-projeto-kafka-spring
   ```

3. Inicie os serviços do Kafka e Zookeeper usando Docker Compose:

   ```
   docker-compose up -d
   ```

Isso iniciará containers Docker para o Kafka, Zookeeper e possivelmente para o Kafdrop, dependendo da configuração do seu projeto.

### Configuração do Spring

Certifique-se de configurar corretamente as propriedades do Kafka no arquivo `application.properties` (ou `application.yml`) do seu projeto Spring:

```properties
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=my-group
spring.kafka.consumer.auto-offset-reset=earliest
```

## Executando a Aplicação

Para iniciar a aplicação Spring, execute:

```
mvn spring-boot:run
```

Isso iniciará a aplicação e você poderá observar os logs para verificar se a conexão com o Kafka está sendo estabelecida corretamente.

## Exemplo de Uso

### Produtor Kafka

Um exemplo de como enviar mensagens para o Kafka:

```java
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/publish/{message}")
    public String postMessageToKafka(@PathVariable("message") String message) {
        kafkaProducerService.sendMessage(message);
        return "Mensagem enviada para o Kafka: " + message;
    }
}
```

### Consumidor Kafka

Um exemplo de como consumir mensagens do Kafka:

```java
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void listen(String message) {
        System.out.println("Mensagem recebida do Kafka: " + message);
        // Lógica para processar a mensagem recebida
    }
}
```

## Contribuições

Contribuições são bem-vindas! Se você encontrou algum problema ou deseja melhorar este projeto, sinta-se à vontade para enviar um pull request.

## Licença

Este projeto é licenciado sob a MIT License - veja o arquivo LICENSE.md para mais detalhes.