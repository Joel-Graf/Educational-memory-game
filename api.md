
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
bioma: {
        id,
        nome,
}

## Descrição
Requisição para obter do banco os dados do bioma

# JOGO

## Rota
aninais: {
        id,
        nome,
        id_bioma,
}

## Descrição
Requisição para obter do banco os dados do animais com base no id do bioma da fase.
A quantidade de cartas sera definida com base na dificuldade(quantidade é fixa no front) e irá retornar os animais de forma aleatória nessa quantidade.

# PARTIDA

## Descrição

VITÓRIA, ANDAMENTO, DERROTA

# GRAVAÇÃO INICIAL

aninais: {
        id_aluno,
        id_bioma,
        id_dificuldade,
        status, (ANDAMENTO)
}

# GRAVAÇÃO FINAL

aninais: {
        id_aluno,
        id_bioma,
        id_dificuldade,
        status, (VITÓRIA, DERROTA)
        tempoDaPartida
}