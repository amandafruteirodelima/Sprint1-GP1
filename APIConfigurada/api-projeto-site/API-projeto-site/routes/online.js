var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Usuario = require('../models').Usuario;

let sessoes = [];

/* Listar funcionários */
router.post('/verOnline:idFuncionario', function (req, res, next) {

	let idFuncionario = req.params.idFuncionario;

	let instrucaoSql = `
	select * from Funcionario where fk_Chefe = ${idFuncionario}`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		type: sequelize.QueryTypes.SELECT // se não for usar models
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);

		if (resultado.length > 0) {
			res.json(resultado); // transforma resposta em json
		} else {
			res.status(403).send('sem funcionários registrados');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

module.exports = router;