"use strict";
let nome = "murilo";
let idade = 10;
let teste = "1"; //tipagem dinamica
let alunos = ["a", "b", "c"];
var Direcao;
(function (Direcao) {
    Direcao[Direcao["Cima"] = 0] = "Cima";
    Direcao[Direcao["Baixo"] = 1] = "Baixo";
    Direcao[Direcao["Esquerda"] = 2] = "Esquerda";
    Direcao[Direcao["Direita"] = 3] = "Direita";
})(Direcao || (Direcao = {}));
let direcaoAtual = Direcao.Cima;
//let palavra = prompt("a") as string //o as força o retorno de um certo tipo
let palavra_2;
