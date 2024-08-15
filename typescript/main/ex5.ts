interface Pessoa {
    nome: string
    idade: number
    profissao: string
}

const detalha = (pessoa: Pessoa): string => {
    return `
    Essa pessoa tem ${pessoa.idade} idade, 
    ${pessoa.nome} nome 
    e trabalha com ${pessoa.profissao}
`}

const pessoa_1: Pessoa = {
    nome: "muliro",
    idade: 20,
    profissao: "garoto de programa"
};

console.log(detalha(pessoa_1))