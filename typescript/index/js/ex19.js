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
const query_fun = () => __awaiter(void 0, void 0, void 0, function* () {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log("Fazendo uma busca no banco de dados..");
        }, 2000);
    });
});
function test_query() {
    return __awaiter(this, void 0, void 0, function* () {
        try {
            const res = yield query_fun();
        }
        catch (e) {
            console.error('Erro');
        }
    });
}
test_query();
