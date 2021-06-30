
BASE - localhost:8090/pac3

# LOGIN

## Rota
/usuario/{usuario}/{senha}

## Descrição
Utiliza do usuário e senha que o cliente digitou nos campos da tela de login e faz uma requisição ao banco de dados para a validação dos dados inseridos.

## Consulta
O banco deve retornar um objeto com o status de logado ou não e a descrição desse status.
true - "Login bem sucedido!"
false - "A senha esta errada"
        "O usuario esta errado"
        "Algo deu errado"


# RANKING

## Rota
/ranking/{idUsuario}

## Descrição
O front envia o id do usuário logado e recebe o objeto com os dados do logado na posição 0 e os restantes nas demais posições.

## Consulta
O banco deve retornar um objeto com todos os alunos.

# FASES

## Rota
/fases
/fases/{idUsuario}

## Descrição
O front envia uma requisição para consulta das fases do banco, sendo o objeto da fase (nome, id).
O front envia o id do usuário e recebe a fase atual do aluno.

## Consulta
O banco deve retornar as fases cadastradas com o objeto delas.

# JOGO

## Rota
/fases/{idUsuario}/{idFase}/{idDificuldade}

## OBS
O id da dificuldade vem do radio da tela de fases.

## Descrição
O front envia uma requisição para consulta de todos os dados da fase.

## Consulta
O banco deve retornar um objeto com todos os dados da dificuldade (numero de cartas e tempo limite).
Baseado no número de cartas e no id dad fase ele deve buscar as cartas de animais








