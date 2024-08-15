class Pessoa {
    nome: string
    idade: number

    constructor(nome: string, idade: number) {
        this.nome = nome
        this.idade = idade
    }
}

class Empresa {
    nome: string
    preco: number

    constructor(nome: string, preco: number) {
        this.nome = nome
        this.preco = preco
    }
}

const funcao_dif = (objeto: Pessoa | Empresa): string => {
    if (objeto instanceof Pessoa) {
        return "é pessoa"
    }
    else if (objeto instanceof Empresa) {
        return "é empresa"
    }
    return "nao é pessoa nem empresa"
}
