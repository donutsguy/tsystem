let basico_1: string = "palavra"
let basico_2: number = 2
let basico_3: boolean = true
let basico_4: string[] = ["oi"]

const recebe_tipos = (dado: string | number | boolean | string[]): string => {
    let res: string = "";

    if (Array.isArray(dado)) {
        res = dado.join(", ")
    }
    else {
        res = dado.toString();
    }

    return res;
}

console.log(recebe_tipos(11))