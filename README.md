# Desafio-Turn2C
Repositório com o desafio técnico da Turn2C

OBS: Sobre esse desafio:
* Adicionei algumas validações nos campos que me foram pedidos então dependendo do campo você terá que ser específico, dentre eles:
* Campo CPF: Adicionei a validação @CPF então na hora de testar ele só aceita CPFs que existam!
* Campo CEP: Como é um Integer, o campo cep não aceita no postman colocar o 0 a esquerda e só aceita se tiver a mesma quantidade de caracteres que um cep tem que são 8 (exemplo: 7240701).
* Campo Email: Com o @Email como validação ele só aceita se tiver no teste o "@gmail.com" ou outro provedor como hotmail,etc.
* Demais campos são validações básicas como não pode valor nulo e nem valor em branco, e alguns campos como cidade e bairro tem um minimo de caracteres.

* Na pasta resources foi adicionado três configurações para que na hora de testar você consiga ver as queries sendo feita em forma de SQL, então na hora de ver se inseriu fique com o console aberto para ver os selects, etc.

* Lembrando que não está conectado em um banco, então sempre que reiniciar a aplicação terá que inserir dados novamente.
