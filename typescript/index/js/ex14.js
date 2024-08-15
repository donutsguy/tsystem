"use strict";
var Dias;
(function (Dias) {
    Dias[Dias["Domingo"] = 0] = "Domingo";
    Dias[Dias["Segunda"] = 1] = "Segunda";
    Dias[Dias["Ter\u00E7a"] = 2] = "Ter\u00E7a";
    Dias[Dias["Quarta"] = 3] = "Quarta";
    Dias[Dias["Quinta"] = 4] = "Quinta";
    Dias[Dias["Sexta"] = 5] = "Sexta";
    Dias[Dias["Sabado"] = 6] = "Sabado";
})(Dias || (Dias = {}));
const dia_util = (dia) => {
    if (dia === Dias[-1] || dia === Dias[-2]) {
        return "é final de semana";
    }
    return "é dia útil";
};
console.log(dia_util(Dias[1]));
