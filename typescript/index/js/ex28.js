"use strict";
class Pessoa {
    constructor(nome, idade) {
        this.nome = nome;
        this.idade = idade;
    }
}
class Empresa {
    constructor(nome, preco) {
        this.nome = nome;
        this.preco = preco;
    }
}
const funcao_dif = (objeto) => {
    if (objeto instanceof Pessoa) {
        return "é pessoa";
    }
    else if (objeto instanceof Empresa) {
        return "é empresa";
    }
    return "nao é pessoa nem empresa";
};
