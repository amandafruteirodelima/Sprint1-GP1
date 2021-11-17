var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Equipe = require('../models').Equipe;
var Usuario = require('../models').Usuario;
var Equipe_Funcionario = require('../models').Equipe_Funcionario;

let equipes = [];
let funcionarios = [];

/* Buscando equipes e subordinados */
router.post('/adicionar', function (req, res, next) {
	console.log('Recuperando funcionarios e equipes');

	var equipe = req.body.nome_equipe; // depois de .body, use o nome (name) do campo em seu formulário de login
	var funcionario = req.body.nome_funcionario; // depois de .body, use o nome (name) do campo em seu formulário de login	

	let instrucaoSql = `select * from equipe where nomeEquipe = '${equipe}'`;
	let instrucaoSql2 = `select * from Funcionario where nomeFuncionario = '${funcionario}'`;
	// let instrucaoSql2 = `select * from Funcionario join equipe_funcionario on idFuncionario=fk_funcionario join equipe on idEquipe=fk_Equipe where nomeFuncionario = '${funcionario}' 
	// and nomeEquipe = '${equipe}'`;

	console.log(instrucaoSql2);

	sequelize.query(instrucaoSql2, {
		model: Usuario
	}).then(sequelize.query(instrucaoSql,{
		model: Equipe
		}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);

		if (resultado.length != 0) {
			funcionarios.push(resultado[0].dataValues.idFuncionario);	// ainda vou arrumar aqui 
			equipes.push(resultado[0].dataValues.idEquipe);
			res.json(resultado[0]);
			console.log(`Encontrados: ${funcionarios[0]}`);
			console.log(`Encontrados: ${equipes[0]}`);
		} else {
			res.status(403).send('Usuario inválido');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	}));

// 	console.log(instrucaoSql);

// 	sequelize.query(instrucaoSql, {
// 		model: Equipe
// 	}).then(resultado => {
// 		console.log(`Encontrados: ${resultado.length}`);

// 		if (resultado.length != 0) {
// 			equipes.push(resultado[0].dataValues.idEquipe);
// 			res.json(resultado[0]);
// 		} else {
// 			res.status(403).send('Equipe inválida');
// 		}

// 	}).catch(erro => {
// 		console.error(erro);
// 		res.status(500).send(erro.message);
// 	});


	// Equipe_Funcionario.create({
	// 	fk_equipe: equipes[0],
	// 	fk_funcionario: funcionarios[0]
	// }).then(resultado => {
	// 	console.log(`Registro criado: ${resultado}`)
	// 	res.send(resultado);
	// }).catch(erro => {
	// 	console.error(erro);
	// 	res.status(500).send(erro.message);
	// });
});

/* Criar equipe */
router.post('/criar', function (req, res, next) {
	console.log('Criando uma equipe');

	Equipe.create({
		nome: req.body.nome
	}).then(resultado => {
		console.log(`Registro criado: ${resultado}`)
		res.send(resultado);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

module.exports = router;
