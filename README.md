# Aula 3 - Introdução a MVC e injeção de dependências - TM

## Calculadora de calorias

Repositório que contém a solução do exercício prático 1 TM

- GET ```` /aula3/tm/foods ````
    - retorna a lista com todas as comidas
    - body response
    ````
    [
        {
            "name": "Aceitunas negras",
            "calories": 349
        },
    ]
    ````
  
- GET ```` /aula3/tm/foods/name/{name} ````
    - retorna uma comida que tenha o nome passado como parâmetro
    - body response:
    ````
    {
        "name": "Aceitunas negras",
        "calories": 349
    },
    ````

- GET ```` /aula3/tm/foods/calories/{calories} ````
    - retorna uma lista de comidas que tenham a mesma quantidade de calorias passadas por parâmetro
    - body response:
    ````
    [
        {
            "name": "Aceitunas negras",
            "calories": 349
        },
    ]
    ````
  
- POST ```` /aula3/tm/foods ````
    - adiciona uma comida no JSON
    - body request:
    ````
    {
        "name": "Aceitunas negras",
        "calories": 349
    }
    ````