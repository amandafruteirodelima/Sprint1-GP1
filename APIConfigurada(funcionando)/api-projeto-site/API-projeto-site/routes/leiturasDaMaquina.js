var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Leitura = require('../models').Leitura;
var env = process.env.NODE_ENV || 'development';

router.get('/funcDashProcRam/:idMaquina', function(req, res, next) {
	
    var idMaquina = req.params.idMaquina;

    console.log(`Buscando dados do Peocessador e Ram da Maquina: ${idMaquina}`);

    let sql = "";

    if (env == 'dev') {

    }
    else if (env == 'production') {

    }
    else {
        console.log("Erro ao buscar dados do Peocessador e Ram!!")
    }


});
