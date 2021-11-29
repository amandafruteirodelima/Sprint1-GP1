var express = require("express");
var router = express.Router();
var sequelize = require("../models").sequelize;
const { QueryTypes } = require("sequelize");
var Usuario = require("../models").Usuario;
var Maquina = require("../models").Maquina;
var Componente = require("../models").Componente;
var Equipe_Funcionario = require("../models").Equipe_Funcionario;
var Funcionario_Conquista = require("../models").Funcionario_Conquista;
var Historico_Uso = require("../models").Historico_Uso;
var Historico_Uso_Software = require("../models").Historico_Uso_Software;

let sessoes = [];

/* Recuperar usuário por login e senha */
router.post("/autenticar", function (req, res, next) {
  console.log("Recuperando usuário por login e senha");

  var email = req.body.email; // depois de .body, use o nome (name) do campo em seu formulário de login
  var senha = req.body.senha; // depois de .body, use o nome (name) do campo em seu formulário de login

  let instrucaoSql = `select * from Funcionario where email='${email}' and senha='${senha}'`;
  console.log(instrucaoSql);

  sequelize
    .query(instrucaoSql, {
      model: Usuario,
    })
    .then((resultado) => {
      console.log(`Encontrados: ${resultado.length}`);

      if (resultado.length == 1) {
        sessoes.push(resultado[0].dataValues.email);
        console.log("sessoes: ", sessoes);
        res.json(resultado[0]);
      } else if (resultado.length == 0) {
        res.status(403).send("Login e/ou senha inválido(s)");
      } else {
        res.status(403).send("Mais de um usuário com o mesmo login e senha!");
      }
    })
    .catch((erro) => {
      console.error(erro);
      res.status(500).send(erro.message);
    });
});

/* Cadastrar usuário */
router.post("/cadastrar", function (req, res, next) {
  console.log("Criando um usuário");

  Usuario.create({
    nome: req.body.nome,
    cargaHoraria: req.body.cargaHoraria,
    fk_Chefe: req.body.fk_Chefe,
    fk_Empresa: req.body.fk_Empresa,
    email: req.body.email,
    senha: req.body.senha,
  })
    .then((resultado) => {
      console.log(`Registro criado: ${resultado}`);
      res.send(resultado);
    })
    .catch((erro) => {
      console.error(erro);
      res.status(500).send(erro.message);
    });
});

/* Excluir usuário */
router.post("/excluir", function (req, res, next) {
  console.log("Excluindo um usuário");

  var nomeFuncionario = req.body.nomeFuncionario;

  retonarIdFuncionario(nomeFuncionario)
    .then((idFuncionario) => {
      idFuncionario = idFuncionario[0].idFuncionario;
      //TABELA EQUIPE_FUNCIONARIO

      Equipe_Funcionario.destroy({
        where: { fk_Funcionario: idFuncionario }
      })
        .then((retorno) => {
          console.log(
            `Funcionário excluido da tabela Equipe_Funcionario. Qtd de registros excluidos: ${retorno}`
          );
        })
        .catch((erro) => {
          console.log(`Erro ao excluir da tabela Equipe_Funcionario ${erro}`);
        });

      // ----------------------------------------------------------------------------------------
      //TABELA Funcionario_Conquista

      Funcionario_Conquista.destroy({
        where: { fk_Funcionario: idFuncionario }
      })
        .then((retorno) => {
          console.log(
            `Funcionário excluido da tabela Funcionario_Conquista. Quantidade de registros excluidos: ${retorno}`
          );
        })
        .catch((erro) => {
          console.error(
            `Erro ao excluir da tabela Funcionario_Conquista ${erro}`
          );
        });

      // ----------------------------------------------------------------------------------------
      //TABELA SELECT Componente
      let instrucaoSql2 = `select idComponente from Componente where fk_Maquina = (select idMaquina from Maquina where fk_Funcionario = ${idFuncionario});`;

      console.log(instrucaoSql2);

      sequelize
        .query(instrucaoSql2, { type: QueryTypes.SELECT })

        .then((componentes) => {
          identificadoresComponentes = [];
          for (i = 0; i < componentes.length; i++) {
			identificadoresComponentes.push(componentes[i].idComponente)
		  }
          //TABELA Historico_Uso
          Historico_Uso.destroy({
            where: { fk_Componente: identificadoresComponentes }
          })
            .then((retorno) => {
              console.log(
                `Funcionário excluido da tabela Historico_Uso.Quantidade de registros excluídos: ${retorno}`
              );
            })
            .catch((erro) => {
              console.error(`Erro ao excluir da tabela Historico_Uso. ${erro}`);
            });

          //TABELA Componente
          Componente.destroy({ where: { idComponente: identificadoresComponentes } })
            .then((retorno) => {
              console.log(
                `Funcionário excluido da tabela Componente. Quantidade de registros excluídos: ${retorno}`
              );
            })
            .catch((erro) => {
              console.error(`Erro ao excluir da tabela Componente`);
            });
        })
        .catch((erro) => {
          console.error(erro);
          res.status(500).send(erro.message);
        });

      //TABELA Historico_Uso_Software
      let instrucaoSql3 = `select idMaquina from Maquina where fk_Funcionario = (select idFuncionario from Funcionario where nomeFuncionario = '${nomeFuncionario}');`;
      console.log(instrucaoSql3);

      sequelize
        .query(instrucaoSql3, { type: QueryTypes.SELECT })
        .then((maquina) => {
			maquina = maquina[0].idMaquina;
          //TABELA Historico_Uso_Software
          Historico_Uso_Software.destroy({
            where: { fk_Maquina: maquina },
          })
            .then((retorno) => {
              console.log(
                `Funcionário excluido da tabela Historico_Uso_Software.Quantidade de registros apagados: ${retorno}`
              );

              //TABELA Maquina
              Maquina.destroy({
                where: { fk_Funcionario: idFuncionario },
              })
                .then((retorno) => {
                  console.log(
                    `Funcionário excluido da tabela Maquina. Quantidade de registros apagados: ${retorno}`
                  );
                })
                .catch((erro) => {
                  console.error(`Erro ao excluir da tabela Máquina. ${erro}`);
                });
            })
            .catch((erro) => {
              console.error(
                `Erro ao excluir da tabela Historico_Uso_Software. ${erro}`
              );
            });

          setTimeout(() => {
            Usuario.destroy({
              where: { nomeFuncionario: nomeFuncionario },
            })
              .then((resultado) => {
                console.log(`Funcionário excluido com sucesso: ${resultado}`);
                res.status(200).send(resultado.message);
              })
              .catch((erro) => {
                console.error(erro);
                res.status(500).send(erro.message);
              });
          }, 10_000);
        })
        .catch((erro) => {
          console.error(erro);
          res.status(500).send(erro.message);
        });
      // ----------------------------------------------------------------------------------------
    })
    .catch((erro) => {
      console.log(`Erro total ;-;`);
    });
});

/* Verificação de usuário */
router.get("/sessao/:login", function (req, res, next) {
  let login = req.params.login;
  console.log(`Verificando se o usuário ${login} tem sessão`);

  let tem_sessao = false;
  for (let u = 0; u < sessoes.length; u++) {
    if (sessoes[u] == login) {
      tem_sessao = true;
      break;
    }
  }

  if (tem_sessao) {
    let mensagem = `Usuário ${login} possui sessão ativa!`;
    console.log(mensagem);
    res.send(mensagem);
  } else {
    res.sendStatus(403);
  }
});

/* Logoff de usuário */
router.get("/sair/:login", function (req, res, next) {
  let login = req.params.login;
  console.log(`Finalizando a sessão do usuário ${login}`);
  let nova_sessoes = [];
  for (let u = 0; u < sessoes.length; u++) {
    if (sessoes[u] != login) {
      nova_sessoes.push(sessoes[u]);
    }
  }
  sessoes = nova_sessoes;
  res.send(`Sessão do usuário ${login} finalizada com sucesso!`);
});

/* Recuperar todos os usuários */
router.get("/", function (req, res, next) {
  console.log("Recuperando todos os usuários");
  Usuario.findAndCountAll()
    .then((resultado) => {
      console.log(`${resultado.count} registros`);

      res.json(resultado.rows);
    })
    .catch((erro) => {
      console.error(erro);
      res.status(500).send(erro.message);
    });
});

/* Listar funcionários */
router.post("/verOnline/:idFuncionario", function (req, res, next) {
  let idFuncionario = req.params.idFuncionario;

  let instrucaoSql = `select * from Funcionario where fk_Chefe='${idFuncionario}'`;
  console.log(instrucaoSql);

  sequelize
    .query(instrucaoSql, {
      type: sequelize.QueryTypes.SELECT, // se não for usar models
    })
    .then((resultado) => {
      if (resultado.length > 0) {
        res.json(resultado); // transforma resposta em json
      } else {
        res.status(403).send("sem funcionários registrados");
      }
    })
    .catch((erro) => {
      console.error(erro);
      res.status(500).send(erro.message);
    });
});

/* Mostrar Funcionários Online (verifica num intervalo de 10 minutos) */
router.post('/mostrarOnlineOffline/:idFuncionario', function (req, res, next) {

	let idFuncionario = req.params.idFuncionario;

	let instrucaoSql = `select * from [dbo].[Historico_Uso] HU 
	join Componente cpt on HU.fk_Componente = cpt.idComponente 
	join Maquina mka on cpt.fk_Maquina = mka.idMaquina
	join Funcionario fc on mka.fk_Funcionario = fc.idFuncionario
	where dataHora between DateADD(minute, -10, Current_TimeStamp) and getDate() and fc.idFuncionario =${idFuncionario}`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		type: sequelize.QueryTypes.SELECT // se não for usar models
	}).then(resultado => {

		if (resultado.length > 0) {
			res.json(resultado); // transforma resposta em json
		} else {
			console.log("offline");
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

/* Mostrar Horas Usadas Hoje*/
router.post('/mostrarHorasUsadasHoje/:idFuncionario', function (req, res, next) {

	let idFuncionario = req.params.idFuncionario;

	let instrucaoSql = `from [dbo].[Historico_Uso] HU 
	join Componente cpt on HU.fk_Componente = cpt.idComponente 
	join Maquina mka on cpt.fk_Maquina = mka.idMaquina
	join Funcionario fc on mka.fk_Funcionario = fc.idFuncionario
	where dataHora between DateADDDateADD(minute, -10, Current_TimeStamp) and getDate() and fc.idFuncionario ='${idFuncionario}'`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		type: sequelize.QueryTypes.SELECT // se não for usar models
	}).then(resultado => {

		if (resultado.length > 0) {
			res.json(resultado); // transforma resposta em json
		}	

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

/* Trazer componentes */
router.post("/trazerComponentes/:idFuncionario", function (req, res, next) {
  let idFuncionario = req.params.idFuncionario;

  let instrucaoSql = `select * from Componente cpt 
	join Maquina mka on cpt.fk_Maquina = mka.idMaquina 
	join Funcionario fc on fk_Funcionario= idFuncionario where fk_Funcionario = ${idFuncionario}`;

  console.log(instrucaoSql);

  sequelize
    .query(instrucaoSql, {
      type: sequelize.QueryTypes.SELECT, // se não for usar models
    })
    .then((resultado) => {
      if (resultado.length > 0) {
        res.json(resultado); // transforma resposta em json
      } else {
        res.status(403).send("sem funcionários registrados");
      }
    })
    .catch((erro) => {
      console.error(erro);
      res.status(500).send(erro.message);
    });
});

/* Desativa o monitoramento de um componente */
router.post("/desativarComponenteBD/:idComponente", function (req, res, next) {
  let idComponente = req.params.idComponente;

  let instrucaoSql = `update [dbo].[Componente] set isAtivo= 0 where idComponente =${idComponente}`;

  console.log(instrucaoSql);

  sequelize
    .query(instrucaoSql, {
      type: sequelize.QueryTypes.SELECT, // se não for usar models
    })
    .then((resultado) => {
      if (resultado.length > 0) {
        res.json(resultado); // transforma resposta em json
      } else {
        res.status(403).send("sem componentes registrados");
      }
    })
    .catch((erro) => {
      console.error(erro);
      res.status(500).send(erro.message);
    });
});

/* Ativa o monitoramento de um componente */
router.post("/ativarComponenteBD/:idComponente", function (req, res, next) {
  let idComponente = req.params.idComponente;

  let instrucaoSql = `update [dbo].[Componente] set isAtivo= 1 where idComponente =${idComponente}`;

  console.log(instrucaoSql);

  sequelize
    .query(instrucaoSql, {
      type: sequelize.QueryTypes.SELECT, // se não for usar models
    })
    .then((resultado) => {
      if (resultado.length > 0) {
        res.json(resultado); // transforma resposta em json
      } else {
        res.status(403).send("sem componentes registrados");
      }
    })
    .catch((erro) => {
      console.error(erro);
      res.status(500).send(erro.message);
    });
});

function retonarIdFuncionario(nomeFuncionario) {
  return sequelize.query(
    `SELECT idFuncionario from Funcionario where nomeFuncionario = '${nomeFuncionario}'`,
    { type: QueryTypes.SELECT }
  );
}

module.exports = router;
