const reverte = (palavra: string): string => {
    return palavra.split("").reverse().join("")
}

console.log(reverte("pindamonhangaba"))