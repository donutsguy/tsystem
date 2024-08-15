class Produto_2 {
    preco: number
    quantidade: number
    categoria: string

    constructor(preco: number, quantidade: number, categoria: string) {
        this.preco = preco
        this.quantidade = quantidade
        this.categoria = categoria
    }
}

const produto_01 = new Produto_2(29.99, 100, 'Eletrônicos');
const produto_02 = new Produto_2(15.49, 200, 'Eletrônicos');
const produto_03 = new Produto_2(89.90, 50, 'Casa e Jardim');

const produtos_2: Produto_2[] = [produto_01, produto_02, produto_03];

const funcao_filtra = (produtos: Produto_2[], categoria: string): Produto_2[] => {
    return produtos.reduce((resultado: Produto_2[], produto: Produto_2) => {
        if (produto.categoria === categoria) {
            resultado.push(produto);
        }
        return resultado;
    }, []);
}

console.log(funcao_filtra(produtos_2, 'Eletrônicos'));