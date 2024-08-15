const funcao = (palavra: string, numero?: number): string => { return palavra.repeat(numero || 2); }

console.log(funcao("ola", 3))