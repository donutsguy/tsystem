const query_fun = async (): Promise<string> => {
    return new Promise<string>((resolve, reject) => {
        setTimeout(() => {
            console.log("Fazendo uma busca no banco de dados..")
        }, 2000)
    })
}

async function test_query() {
    try {
        const res = await query_fun()
    } catch (e) {
        console.error('Erro')
    }
}

test_query()