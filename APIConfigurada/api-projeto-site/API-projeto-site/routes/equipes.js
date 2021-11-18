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

	console.log(instrucaoSql2);
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql2, {
		model: Usuario
	}).then(resultado1 => {
		console.log(`Encontrados: ${resultado1.length}`);
		if (resultado1.length != 0) {
			funcionarios.push(resultado1[0].dataValues.idFuncionario);
		} else {
			res.status(403).send('Usuario inválido');
		}

	}, sequelize.query(instrucaoSql, {
		model: Equipe
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		if (resultado.length != 0) {
			equipes.push(resultado[0].dataValues.idEquipe);
			
		} else {
			res.status(403).send('Equipe inválida');
		}

		Equipe_Funcionario.create({
			fk_equipe: equipes[0],
			fk_funcionario: funcionarios[0]
		}).then(resultado => {
			console.log(`Registro criado: ${resultado}`)
			res.send(resultado);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	}));
	equipes = [];
	funcionarios = [];
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
