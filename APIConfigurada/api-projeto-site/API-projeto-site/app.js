process.env.NODE_ENV = 'production'; // altere para 'production' ou 'dev'

var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

var indexRouter = require('./routes/index');
var usuariosRouter = require('./routes/usuarios');
var leiturasRouter = require('./routes/leituras');
var leiturasMaquinaRouter = require('./routes/leiturasDaMaquina');
var Funcionario_Conquista = require('./routes/Funcionario_Conquista');
var equipesRouter = require('./routes/equipes');
var equipeFuncionarioRouter = require('./routes/equipes');

var app = express();

app.use(logger('dev')); 
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);
app.use('/usuarios', usuariosRouter);
app.use('/leituras', leiturasRouter);
app.use('/leiturasDaMaquina', leiturasMaquinaRouter);
app.use('/Funcionario_Conquista',Funcionario_Conquista);
app.use('/equipes', equipesRouter);
app.use('/equipes', equipeFuncionarioRouter);

module.exports = app;
