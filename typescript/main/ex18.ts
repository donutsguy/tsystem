const conta_vogal = (palavra: string): number => {
    return palavra.split("").reduce((count: number, letra: string) => {
        switch (letra.toLowerCase()) {
            case "a":
            case "e":
            case "i":
            case "o":
            case "u":
                count++;
                break;
        }
        return count;
    }, 0);
}

console.log(conta_vogal("banana"));