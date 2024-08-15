const funcao_str = (palavra: string | number): string | number => {
    if (typeof palavra === "string") {
        return "é string"
    }
    else if (typeof palavra === "number") {
        return 10
    }
    return "nao é string nem number"
}

console.log(funcao_str(10))