"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
const funcao_1 = () => __awaiter(void 0, void 0, void 0, function* () {
    return new Promise((resolve) => {
        resolve({ numero: 10 });
    });
});
const funcao_2 = () => __awaiter(void 0, void 0, void 0, function* () {
    return new Promise((resolve) => {
        resolve({ palavra: "alguma coisa" });
    });
});
const buscar_informacoes = () => __awaiter(void 0, void 0, void 0, function* () {
    try {
        const [numero_o, palavra_o] = yield Promise.all([
            funcao_1(),
            funcao_2()
        ]);
        return { numero_o, palavra_o };
    }
    catch (erro) {
        console.error("erro");
        throw erro;
    }
});
function testar() {
    return __awaiter(this, void 0, void 0, function* () {
        try {
            const resultado = yield buscar_informacoes();
            console.log('Resultado combinado:', resultado);
        }
        catch (erro) {
            console.error('Erro:');
        }
    });
}
testar();
