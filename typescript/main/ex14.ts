enum Dias {
    Domingo,
    Segunda,
    Terça,
    Quarta,
    Quinta,
    Sexta,
    Sabado
}

const dia_util = (dia: string): string => {
    if (dia === Dias[-1] || dia === Dias[-2]) {
        return "é final de semana"
    }

    return "é dia útil"
}

console.log(dia_util(Dias[1]))