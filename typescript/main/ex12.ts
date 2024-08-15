class Caixa {
    private valor: any

    public set_valor(valor_adicionar: any) {
        this.valor = valor_adicionar
    }

    public get_valor(): any {
        return this.valor
    }
}

const caixaDeString = new Caixa();

caixaDeString.set_valor('Olá, Mundo!');

const valorString = caixaDeString.get_valor();
console.log(`Valor armazenado: ${valorString}`);

const caixaDeNumero = new Caixa();

caixaDeNumero.set_valor(12345);

const valorNumero = caixaDeNumero.get_valor();
console.log(`Valor armazenado: ${valorNumero}`);

interface Pessoa2 {
    nome: string;
    idade: number;
}

const caixaDeObjeto = new Caixa();

const pessoa: Pessoa2 = { nome: 'Maria', idade: 30 };
caixaDeObjeto.set_valor(pessoa);

const valorObjeto = caixaDeObjeto.get_valor();
console.log(`Valor armazenado:`, valorObjeto); 
