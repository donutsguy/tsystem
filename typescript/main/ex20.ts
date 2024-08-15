const funcao_1 = async (): Promise<{ numero: number }> => {
    return new Promise<{ numero: number }>((resolve) => {
        resolve({ numero: 10 })
    })
}

const funcao_2 = async (): Promise<{ palavra: string }> => {
    return new Promise<{ palavra: string }>((resolve) => {
        resolve({ palavra: "alguma coisa" })
    })
}

const buscar_informacoes = async () => {

    try {
        const [numero_o, palavra_o] = await Promise.all([
            funcao_1(),
            funcao_2()
        ])

        return { numero_o, palavra_o }
    } catch (erro) {
        console.error("erro")
        throw erro
    }
}

async function testar() {
    try {
        const resultado = await buscar_informacoes()
        console.log('Resultado combinado:', resultado)
    } catch (erro) {
        console.error('Erro:')
    }
}

testar();