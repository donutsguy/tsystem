class Produtos {
    nome: string
    preco: number

    constructor(nome: string, preco: number) {
        this.nome = nome
        this.preco = preco
    }
}

const produto1 = new Produtos('Camiseta', 29.99);
const produto2 = new Produtos('Calça Jeans', 89.90);
const produto3 = new Produtos('Tênis', 159.99);
const produto4 = new Produtos('Jaqueta', 129.50);

let produtos_lista = [produto1, produto2, produto3, produto4]

const filtra = (produtos: Produtos[], preco: number): Produtos[] => {
    return produtos.filter(prod => prod.preco >= preco);
}

console.log(filtra(produtos_lista, 30))