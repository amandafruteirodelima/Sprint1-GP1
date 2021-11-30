var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Funcionario_Conquista = require('../models').Funcionario_Conquista;
var Usuario = require('../models').Usuario;
var Conquista = require('../models').Conquista;

/* Recuperar Pontos Equipe por idFuncionario pertencente a equipe*/
router.post('/recuperar', function(req, res, next) {
	console.log('Recuperando Conquista por idFuncionario == fk_funcionario');
	console.log('------------------------------------------------------------------------');

	console.log(req.body);

	var idFuncionario = req.body.idFuncionario

    
    //Neste select irei trazer todos os dados que desejo relacionando func e conquista
    //Trará todas as conquistas

	let instrucaoSql = `select idConquista, nomeConquista, descConquista, devCoinConquista, 
	pontosConquista, xpConquista, idFuncionario,nomeFuncionario
		from Funcionario_Conquista  
		join Conquista on fk_Conquista = idConquista 
		join Funcionario on fk_Funcionario = idFuncionario
		where fk_Funcionario = ${idFuncionario}`


	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Funcionario_Conquista
	}).then(resultados => {
		console.log(`Encontrados: ${resultados.length}`);

		if (resultados.length != null && resultados.length != 0) {
                res.json(resultados);

		} else if (resultados.length == 0) {
			res.status(403).send('Não há conquistas no momento,aguarde para conquistar e atingir cada vez mais seus objetivos!');
		} else {
			res.status(403).send('Errooooooooo!');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});




