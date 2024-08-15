class Carro {
    private marca: string
    private modelo: string
    private ano: number
    private static carros_instanciados: number = 0;

    constructor(marca: string, modelo: string, ano: number) {
        this.marca = marca
        this.modelo = modelo
        this.ano = ano
        Carro.carros_instanciados++
    }

    public retorna_descricao(carro: Carro): string {
        return `
            marca: ${carro.marca} 
            modelo: ${carro.modelo}
            ano: ${carro.ano}
        `
    }

    public static retorna_carros_instanciados(): number {
        return Carro.carros_instanciados;
    }
}

const carro1 = new Carro('Toyota', 'Corolla', 2020);
const carro2 = new Carro('Honda', 'Civic', 2021);
const carro3 = new Carro('Ford', 'Mustang', 2019);

console.log(carro1.retorna_descricao(carro1))
console.log(carro2.retorna_descricao(carro2))
console.log(carro3.retorna_descricao(carro3))
console.log(Carro.retorna_carros_instanciados())