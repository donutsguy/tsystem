function retorna_primeiro<T>(valor: T[]): T {
    return valor[0];
}

const strings: string[] = ['Olá', 'Mundo', 'TypeScript', 'Array', 'Exemplo'];
console.log(retorna_primeiro(strings));

const numeros: number[] = [10, 20, 30, 40, 50];
console.log(retorna_primeiro(numeros));

class Cone {
    private tamanho: string
    private cor: string

    constructor(tamanho: string, cor: string) {
        this.tamanho = tamanho
        this.cor = cor
    }
}

const cones: Cone[] = [
    new Cone('Toyota', 'Corolla'),
    new Cone('Honda', 'Civic'),
    new Cone('Ford', 'Mustang')
];
console.log(retorna_primeiro(cones))