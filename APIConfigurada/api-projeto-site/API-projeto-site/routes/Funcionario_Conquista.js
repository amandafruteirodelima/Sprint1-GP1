var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Funcionario_Conquista = require('../models').Funcionario_Conquista;
var Conquista = require('../models').Conquista;
var Usuario = require('../models').Usuario;


let sessoes = [];

/* Recuperar Conquista por idFuncionario */
router.post('/recuperar', function (req, res, next) {
	console.log('Recuperando Conquista por idFuncionario == fk_funcionario');
	console.log('------------------------------------------------------------------------');

	console.log(req.body);

	var idFuncionario = req.body.idFuncionario


	//Neste select irei trazer todos os dados que desejo relacionando func e conquista
	//Trará todas as conquistas

	let instrucaoSql = `select idConquista, devCoinFuncionario, pontosFuncionario, nomeConquista, checkCompleta, descConquista, devCoinConquista, 
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



/* Finalizar Conquista*/
router.post('/atualizar', function (req, res, next) {

	nomeConquista = req.body.nomeConquista;
	idFuncionario = req.body.idFuncionario;
	pontosAtual = req.body.pontosAtual;
	devCoinsAtual = req.body.devCoinsAtual;



	let instrucaoSql5 = `update Funcionario_Conquista set checkCompleta = 1 where fk_Conquista = (select idConquista from Conquista where nomeConquista = '${nomeConquista}');`




	sequelize.query(instrucaoSql5, {
		model: Funcionario_Conquista
	}).then(resultados => {
		console.log(`${resultados}`);
		console.log(`Encontrados: ${resultados.length}`);
		console.log(`Tentando atualizar: ${resultados.length}`);

		if (resultados.length != null) {
			atualizarPontos(idFuncionario, nomeConquista,pontosAtual,res);
			atualizarDevCoins(idFuncionario, nomeConquista,devCoinsAtual);
			//res.status(200).send('Deu bom confia!');
		} else {
			res.status(403).send('Errooooooooo ao tentar atualizar!');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});

});





function atualizarDevCoins(idFuncionario, nomeConquista, valorAtualDevCoins) {


	let instrucaoSql = `select devCoinConquista from Conquista where nomeConquista = '${nomeConquista}';`

	sequelize.query(instrucaoSql, {
		model: Conquista
	}).then(resultados => {
		console.log(`${resultados}`);
		console.log(`Encontrados: ${resultados.length}`);


		if (resultados.length != null) {
			console.log('Deu bom confia 2!');
			valorFinal = Number(resultados[0].devCoinConquista) + Number(valorAtualDevCoins);

			let instrucaoSql7 = `update Funcionario set devCoinFuncionario = ${valorFinal} where idFuncionario = ${idFuncionario};`


			sequelize.query(instrucaoSql7, {
				model: Usuario
			}).then(resultados => {
				console.log(`${resultados}`);
				console.log(`Encontrados: ${resultados.length}`);


			}).catch(erro => {
				console.error(erro);
				console.log(erro.message);
			});

		} else {
			console.log('Errooooooooo ao tentar atualizar!');
		}

	}).catch(erro => {
		console.error(erro);
		
	});


}

function atualizarPontos(idFuncionario, nomeConquista, valorAtualPontos,res) {

	let instrucaoSql = `select pontosConquista from Conquista where nomeConquista = '${nomeConquista}';`


	sequelize.query(instrucaoSql, {
		model: Conquista
	}).then(resultados => {
		console.log(`${resultados}`);
		console.log(`Encontrados: ${resultados.length}`);
		console.log(`Tentando atualizar: ${resultados.length}`);

		if (resultados.length != null) {
			valorFinal = Number(resultados[0].pontosConquista) + Number(valorAtualPontos);
			
			let instrucaoSql7 = `update Funcionario set pontosFuncionario = ${valorFinal} where idFuncionario = ${idFuncionario};`
			
			
			sequelize.query(instrucaoSql7, {
				model: Usuario
			}).then(resultados => {
				console.log(`${resultados}`);
				console.log(`Encontrados: ${resultados.length}`);
				console.log(`Tentando atualizar: ${resultados.length}`);
		
					res.status(200).send('Deu bom confia!');
		
			}).catch(erro => {
				console.error(erro);
				res.status(500).send(erro.message);
			});
			
			
		} else {
			res.status(403).send('Errooooooooo ao tentar atualizar!');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});




}

module.exports = router;