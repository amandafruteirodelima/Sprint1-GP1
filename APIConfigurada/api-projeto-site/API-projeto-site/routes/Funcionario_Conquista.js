var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Funcionario_Conquista = require('../models').Funcionario_Conquista;


let sessoes = [];

/* Recuperar Conquista por idFuncionario */
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



/* Finalizar Conquista*/
router.post('/atualizar', function(req, res,next) {

	nomeConquista = req.body.nomeConquista;
	

	let instrucaoSql5 = `update Funcionario_Conquista set checkCompleta = 1 where fk_Conquista = (select idConquista from Conquista where nomeConquista = '${nomeConquista}');`

	sequelize.query(instrucaoSql5, {
		model: Funcionario_Conquista
	}).then(resultados => {
		console.log(`${resultados}`);
		console.log(`Encontrados: ${resultados.length}`);
		console.log(`Tentando atualizar: ${resultados.length}`);

		if (resultados.length != null) {
			res.status(200).send('Deu bom confia!');

		}
		else {
			res.status(403).send('Errooooooooo ao tentar atualizar!');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});

});

/* Verificação de usuário */
// router.get('/sessao/:login', function(req, res, next) {
// 	let login = req.params.login;
// 	console.log(`Verificando se o usuário ${login} tem sessão`);
	
// 	let tem_sessao = false;
// 	for (let u=0; u<sessoes.length; u++) {
// 		if (sessoes[u] == login) {
// 			tem_sessao = true;
// 			break;
// 		}
// 	}

// 	if (tem_sessao) {
// 		let mensagem = `Usuário ${login} possui sessão ativa!`;
// 		console.log(mensagem);
// 		res.send(mensagem);
// 	} else {
// 		res.sendStatus(403);
// 	}
	
// });



/* Recuperar todos os usuários */
// router.get('/', function(req, res, next) {
// 	console.log('Recuperando todos os usuários');
// 	Usuario.findAndCountAll().then(resultado => {
// 		console.log(`${resultado.count} registros`);

// 		res.json(resultado.rows);
// 	}).catch(erro => {
// 		console.error(erro);
// 		res.status(500).send(erro.message);
//   	});
// });

module.exports = router;
