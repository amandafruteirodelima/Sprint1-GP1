var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var componente = require('../models').componente;
var Historico_Uso = require('../models').Historico_Uso;
var env = process.env.NODE_ENV || 'development';

// Processador

router.get('/processadorultimas/:usuarioEmail', function(req, res, next) {
	
    const limite_linhas = 7;

    var usuarioEmail = req.params.usuarioEmail;

    console.log(`Recuperando dados do Processador da Maquina: ${usuarioEmail}`);

    let sql = "";

    if (env == 'dev') {
		instrucaoSql = `select
        nomeComponente, 
		consumo, 
		dataHora, 
		DATE_FORMAT(dataHora,'%H:%i:%s') as dataFormatada
		FROM Funcionario
		JOIN Maquina
		ON (Funcionario.idFuncionario = Maquina.fk_Funcionario)
		JOIN Componente
		ON (Maquina.idMaquina = Componente.fk_Maquina)
		INNER JOIN Historico_Uso
        ON (Componente.idComponente = Historico_Uso.fk_componente)
        where nomeComponente = 'CPU' and Funcionario.email = '${usuarioEmail}'
		order by datahora desc limit ${limite_linhas}`;
    }
    else if (env == 'production') {
        instrucaoSql = `select top ${limite_linhas}
		funcionario.email,
        Componente.nomeComponente,
        Componente.capacidade, 
		Historico_Uso.consumo, 
		Historico_Uso.dataHora,
		FORMAT(dataHora,'%H:%m:%s') as dataFormatada
		FROM [dbo].[Funcionario]
		JOIN [dbo].[Maquina]
		ON (Funcionario.idFuncionario = Maquina.fk_Funcionario)
		JOIN [dbo].[Componente]
		ON (Maquina.idMaquina = Componente.fk_Maquina)
		INNER JOIN Historico_Uso
        ON (Componente.idComponente = Historico_Uso.fk_componente)
        where nomeComponente = 'CPU' and Funcionario.email = '${usuarioEmail}'
		order by datahora desc`;
    }
    else {
        console.log("Erro ao buscar dados da CPU !!")
    }

	sequelize.query(instrucaoSql, {
		model: Historico_Uso,
		mapToModel: true 
	})
	.then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		res.json(resultado);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});


router.get('/processador/:usuarioEmail', function(req, res, next) {
	console.log('Recuperando CPU');
	
	var usuarioEmail = req.params.usuarioEmail;
	
	let instrucaoSql = "";
	
	if (env == 'dev') {
		instrucaoSql = `
		select 
		consumo, 
		dataHora,
		DATE_FORMAT(data_leitura,'%H:%i:%s') as momento_grafico, 
		email
		FROM Funcionario
		JOIN Maquina
		ON (Funcionario.idFuncionario = Maquina.fk_Funcionario)
		JOIN Componente
		ON (Maquina.idMaquina = Componente.fk_Maquina)
		INNER JOIN Historico_Uso
        ON (Componente.idComponente = Historico_Uso.fk_componente)
        where nomeComponente = 'CPU' and Funcionario.email = '${usuarioEmail}'
		order by id desc limit 1`;
	} else if (env == 'production') {
		instrucaoSql = `
		select top 1 
		consumo
		FROM [dbo].[Funcionario]
		JOIN [dbo].[Maquina]
		ON (Funcionario.idFuncionario = Maquina.fk_Funcionario)
		JOIN [dbo].[Componente]
		ON (Maquina.idMaquina = Componente.fk_Maquina)
		INNER JOIN Historico_Uso
        ON (Componente.idComponente = Historico_Uso.fk_componente)
        where nomeComponente = 'CPU' and Funcionario.email = '${usuarioEmail}'
		order by datahora desc`;
	} else {
		console.log("\n\n\n\nVERIFIQUE O VALOR DE LINHA 1 EM APP.JS!\n\n\n\n")
	}
	
	console.log(instrucaoSql);
	
	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
	.then(resultado => {
		res.json(resultado[0]);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

// RAM

router.get('/ramultimas/:usuarioEmail', function(req, res, next) {
	
    const limite_linhas = 7;

    var usuarioEmail = req.params.usuarioEmail;

    console.log(`Recuperando dados do Processador da Maquina: ${usuarioEmail}`);

    let sql = "";

    if (env == 'dev') {
		instrucaoSql = `select
        nomeComponente, 
		consumo, 
		dataHora, 
		DATE_FORMAT(dataHora,'%H:%i:%s')
		FROM Funcionario
		JOIN Maquina
		ON (Funcionario.idFuncionario = Maquina.fk_Funcionario)
		JOIN Componente
		ON (Maquina.idMaquina = Componente.fk_Maquina)
		INNER JOIN Historico_Uso
        ON (Componente.idComponente = Historico_Uso.fk_componente)
        where nomeComponente = 'RAM' and Funcionario.email = '${usuarioEmail}'
		order by datahora desc limit ${limite_linhas}`;
    }
    else if (env == 'production') {
        instrucaoSql = `select top ${limite_linhas}
		email, 
		nomeComponente, 
		capacidade, 
		consumo, 
		dataHora,
		FORMAT(dataHora,'%H:%m:%s') as dataFormatada
		FROM [dbo].[Funcionario]
		JOIN [dbo].[Maquina]
		ON (Funcionario.idFuncionario = Maquina.fk_Funcionario)
		JOIN [dbo].[Componente]
		ON (Maquina.idMaquina = Componente.fk_Maquina)
		INNER JOIN Historico_Uso
        ON (Componente.idComponente = Historico_Uso.fk_componente)
        where nomeComponente = 'RAM' and Funcionario.email = '${usuarioEmail}'
		order by datahora desc`;
    }
    else {
        console.log("Erro ao buscar dados da RAM !!")
    }

	sequelize.query(instrucaoSql, {
		model: Historico_Uso,
		mapToModel: true 
	})
	.then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		res.json(resultado);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

router.get('/ram/:usuarioEmail', function(req, res, next) {
	console.log('Recuperando RAM');
	
	var usuarioEmail = req.params.usuarioEmail;
	
	let instrucaoSql = "";
	
	if (env == 'dev') {
		instrucaoSql = `
		select 
		consumo,
		capacidade, 
		dataHora,
		DATE_FORMAT(data_leitura,'%H:%i:%s') as momento_grafico, 
		email
		FROM Funcionario
		JOIN Maquina
		ON (Funcionario.idFuncionario = Maquina.fk_Funcionario)
		JOIN Componente
		ON (Maquina.idMaquina = Componente.fk_Maquina)
		INNER JOIN Historico_Uso
        ON (Componente.idComponente = Historico_Uso.fk_componente)
        where nomeComponente = 'RAM' and Funcionario.email = '${usuarioEmail}'
		order by id desc limit 1`;
	} else if (env == 'production') {
		instrucaoSql = `
		select top 1 
		consumo, 
		capacidade
		FROM [dbo].[Funcionario]
		JOIN [dbo].[Maquina]
		ON (Funcionario.idFuncionario = Maquina.fk_Funcionario)
		JOIN [dbo].[Componente]
		ON (Maquina.idMaquina = Componente.fk_Maquina)
		INNER JOIN Historico_Uso
        ON (Componente.idComponente = Historico_Uso.fk_componente)
        where nomeComponente = 'RAM' and Funcionario.email = '${usuarioEmail}'
		order by datahora desc`;
	} else {
		console.log("\n\n\n\nVERIFIQUE O VALOR DE LINHA 1 EM APP.JS!\n\n\n\n")
	}
	
	console.log(instrucaoSql);
	
	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
	.then(resultado => {
		res.json(resultado[0]);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});


// DISCO

router.get('/discoultimas/:usuarioEmail', function(req, res, next) {
	
    const limite_linhas = 7;

    var usuarioEmail = req.params.usuarioEmail;

    console.log(`Recuperando dados do Processador da Maquina: ${usuarioEmail}`);

    let sql = "";

    if (env == 'dev') {
		instrucaoSql = `select
        nomeComponente, 
		consumo, 
		dataHora, 
		DATE_FORMAT(dataHora,'%H:%i:%s')
		FROM Funcionario
		JOIN Maquina
		ON (Funcionario.idFuncionario = Maquina.fk_Funcionario)
		JOIN Componente
		ON (Maquina.idMaquina = Componente.fk_Maquina)
		INNER JOIN Historico_Uso
        ON (Componente.idComponente = Historico_Uso.fk_componente)
        where nomeComponente = 'RAM' and Funcionario.email = '${usuarioEmail}'
		order by datahora desc limit ${limite_linhas}`;
    }
    else if (env == 'production') {
        instrucaoSql = ` select top ${limite_linhas}
		idComponente,
        nomeComponente, 
		consumo,
		capacidade,
		dataHora,
		FORMAT(dataHora,'%H:%m:%s') as dataFormatada
		FROM Funcionario
		JOIN Maquina
		ON (Funcionario.idFuncionario = Maquina.fk_Funcionario)
		JOIN Componente
		ON (Maquina.idMaquina = Componente.fk_Maquina)
		INNER JOIN Historico_Uso
        ON (Componente.idComponente = Historico_Uso.fk_componente)
        where nomeComponente = 'DISCO' and Funcionario.email =  '${usuarioEmail}'
		order by datahora desc`;
    }
    else {
        console.log("Erro ao buscar dados da RAM !!")
    }

	sequelize.query(instrucaoSql, {
		model: Historico_Uso,
		mapToModel: true 
	})
	.then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		res.json(resultado);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});


router.get('/disco/:usuarioEmail', function(req, res, next) {
	console.log('Recuperando RAM');
	 
	var usuarioEmail = req.params.usuarioEmail;
	
	let instrucaoSql = "";
	
	if (env == 'dev') {
		instrucaoSql = `
		select 
		consumo,
		capacidade, 
		dataHora,
		DATE_FORMAT(data_leitura,'%H:%i:%s') as momento_grafico, 
		email
		FROM Funcionario
		JOIN Maquina
		ON (Funcionario.idFuncionario = Maquina.fk_Funcionario)
		JOIN Componente
		ON (Maquina.idMaquina = Componente.fk_Maquina)
		INNER JOIN Historico_Uso
        ON (Componente.idComponente = Historico_Uso.fk_componente)
        where nomeComponente = 'DISCO' and Funcionario.email = '${usuarioEmail}'
		order by id desc limit 1`;
	} else if (env == 'production') {
		instrucaoSql = `
		select top 1 
		consumo, 
		capacidade
		FROM [dbo].[Funcionario]
		JOIN [dbo].[Maquina]
		ON (Funcionario.idFuncionario = Maquina.fk_Funcionario)
		JOIN [dbo].[Componente]
		ON (Maquina.idMaquina = Componente.fk_Maquina)
		INNER JOIN Historico_Uso
        ON (Componente.idComponente = Historico_Uso.fk_componente)
        where nomeComponente = 'DISCO' and Funcionario.email = '${usuarioEmail}'
		order by datahora desc`;
	} else {
		console.log("\n\n\n\nVERIFIQUE O VALOR DE LINHA 1 EM APP.JS!\n\n\n\n")
	}
	
	console.log(instrucaoSql);
	
	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
	.then(resultado => {
		res.json(resultado[0]);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

module.exports = router;