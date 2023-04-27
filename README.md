# Tools Java Challenge

API de pagamento que realiza processamento de solicitaçoes de compra e estorno da mesma.
A API permite consultar os dados do pagamento enviados e estorno

## Tecnologias Utilizadas

- Spring Boot
- Java 17
- Spring Data
- JUnit 5
- Mockito

## Arquitetura
O projeto segue os principios de clean architecture

*main:*
1. Domain
    - exceptions
    - types
2. Gateway
    - controller
        - dto
    - repository
3. Interface Adapters
    - converter
4. UseCase
    - dto
    - impl

## Como executar
1. Clonar o projeto
2. Executar o projeto em uma IDE

## Como testar
Atraves do endereço http://localhost:8080 você pode acessar os seguintes recursos:

### Pagamento

1. **``POST /pagamento``**: Cria o pagamento:
```javascript
{
    "transacao": {
        "cartao": "12345678910",
            "id": "100101001001001030",
            "descricao": {
            "valor": "500.50",
                "dataHora": "01/05/2021 18:30:00",
                "estabelecimento": "TESTE"
        },
        "formaPagamento": {
            "tipo": "AVISTA",
                "parcelas": "1"
        }
    }
}
```

2. **``GET /pagamento/{id}``**: Busca o pagamento com a partir do Id do pagamento:

*Exemplo do response do pagamento:*
```javascript
  {
    "transacao": {
        "id": "100101001001001030",
            "cartao": "12345678910",
            "descricao": {
            "valor": "500.50",
                "dataHora": "01/05/2021 06:30:00",
                "estabelecimento": "TESTE",
                "nsu": "1234567890",
                "codigoAutorizacao": "147258369",
                "status": "AUTORIZADO"
        },
        "formaPagamento": {
            "tipo": "AVISTA",
                "parcelas": 1
        }
    }
}
```

3. **``GET /pagamento``**: Busca todos os pagamentos:

*Exemplo do response do pagamento:*
```javascript
 [
      {
        "transacao": {
            "id": "100101001001001030",
                "cartao": "12345678910",
                "descricao": {
                "valor": "500.50",
                    "dataHora": "01/05/2021 06:30:00",
                    "estabelecimento": "TESTE",
                    "nsu": "1234567890",
                    "codigoAutorizacao": "147258369",
                    "status": "AUTORIZADO"
            },
            "formaPagamento": {
                "tipo": "AVISTA",
                    "parcelas": 1
            }
        }
    }
]
```
### Estorno

1. **``PATCH /estorno/{id}``**: *Realizar o estorno do Pagamento:*


2. **``GET /estorno/{id}``**: *Busca o estorno do Pagamento a partir do Id do pagamento:*

*Exemplo do response do estorno:*
```javascript
 {
    "transacao": {
        "id": 100101001001001030,
            "cartao": "12345678910",
            "descricao": {
            "valor": "500.50",
                "dataHora": "01/05/2021 06:30:00",
                "estabelecimento": "TESTE",
                "nsu": "1234567890",
                "codigoAutorizacao": "147258369",
                "status": "CANCELADO"
        },
        "formaPagamento": {
            "tipo": "AVISTA",
                "parcelas": 1
        }
    }
}
```
3. **``GET /estorno``**: *Busca todos os estornos:*

*Exemplo do response do estorno:*
```javascript
[
    {
        "transacao": {
            "id": 100101001001001030,
            "cartao": "12345678910",
            "descricao": {
                "valor": "500.50",
                "dataHora": "01/05/2021 06:30:00",
                "estabelecimento": "TESTE",
                "nsu": "1234567890",
                "codigoAutorizacao": "147258369",
                "status": "CANCELADO"
            },
            "formaPagamento": {
                "tipo": "AVISTA",
                "parcelas": 1
            }
        }
    }
]
```
### Estorno V2

1. **``PATCH /estorno/{id}``**: *Realizar o estorno do Pagamento:*

O estorno V2 foi criado a partir da minha interpretação do fluxo de pagamento e estorno em produção

-------------------------------------------------------------------------------------------------
### Meus contatos

- LinkedIn: https://www.linkedin.com/in/alessandro-patr%C3%ADcio-82b718168/
- Email:  alejunior.jp@gmail.com
- Email:  alejunior.jp@outlook.com
