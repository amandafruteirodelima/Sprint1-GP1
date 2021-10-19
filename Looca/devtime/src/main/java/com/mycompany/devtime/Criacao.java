package com.mycompany.devtime;

import org.springframework.jdbc.core.JdbcTemplate;

public class Criacao {

    public static void main(String[] args) {
        ConfiguracaoBanco configuracaoBanco = new ConfiguracaoBanco();

        JdbcTemplate assistente = new JdbcTemplate(
                configuracaoBanco.getBancoDeDados());
        
//        assistente.execute("drop table maquina_software");
//        assistente.execute("drop table softwares");
//        assistente.execute("drop table historico_ram");
//        assistente.execute("drop table ram");
//        assistente.execute("drop table historico_processador");
//        assistente.execute("drop table processador");
//        assistente.execute("drop table historico_disco");
//        assistente.execute("drop table disco");
//        assistente.execute("drop table maquina");
//        assistente.execute("drop table funcionario");
//
//        String createFuncionario = "CREATE TABLE funcionario("
//                + "  idfuncionario INT NOT NULL AUTO_INCREMENT primary key,"
//                + "  nomeFuncionario varchar(50),"
//                + "  cargaHoraria Int,"
//                + "  email VARCHAR(60),"
//                + "  senha Varchar(20),"
//                + "  dataNascimento DATE,"
//                + "  devCoinFuncionario int,"
//                + "  pontosFuncionario int,"
//                + "  fkEmpresa Int,"
//                + "  fkEquipe Int"
//                + ");";
//
//        assistente.execute(createFuncionario);
//
//        assistente.update("INSERT INTO funcionario VALUES(?,?,?,?,?,?,?,?,?,?)", null,
//                "Juninho", "7", "devtime", "devtime", null, "0", "0", "1", "1");
//
//        String createMaquina = "CREATE TABLE MAQUINA ("
//                + "  idMaquina INT NOT NULL AUTO_INCREMENT,"
//                + "  sistemaOperacional VARCHAR(45),"
//                + "  arquiteturaSO varchar(5),"
//                + "  fabricanteSO varchar(45),"
//                + "  fkfuncionario int, "
//                + "  foreign key (fkfuncionario) references "
//                + "funcionario(Idfuncionario),"
//                + "  PRIMARY KEY (idMaquina)"
//                + ");";
//
//        assistente.execute(createMaquina);
//
//        String createDisco = "CREATE TABLE DISCO ("
//                + "  idDisco INT NOT NULL AUTO_INCREMENT,"
//                + "  nomeDisco VARCHAR(45),"
//                + "  modelo varchar(80),"
//                + "  uuid varchar(45),"
//                + "  tamanhoDisco Double,"
//                + "  fkmaquina int, foreign key(fkmaquina) "
//                + "  references Maquina(idMaquina),"
//                + "  PRIMARY KEY (idDisco)"
//                + ");";
//
//        assistente.execute(createDisco);
//
//        String createHistoricoDisco = "CREATE TABLE HISTORICO_DISCO ("
//                + "  idHistoricoDisco INT NOT NULL AUTO_INCREMENT,"
//                + "  ARMAZENAMENTO DOUBLE,"
//                + "  DATA_HORA DATETIME,"
//                + "  fk_disco int, foreign key(fk_disco)"
//                + "  references Disco(idDisco),"
//                + "  PRIMARY KEY(idHistoricoDisco)"
//                + ");";
//
//        assistente.execute(createHistoricoDisco);
//
//        String createProcessador = "CREATE TABLE PROCESSADOR ("
//                + "  idProcessador INT NOT NULL AUTO_INCREMENT,"
//                + "  fabricante VARCHAR(45),"
//                + "  nomeProcessador VARCHAR(80),"
//                + "  frequencia DOUBLE,"
//                + "  numerocpus INTEGER, "
//                + "  fk_maquina int ,FOREIGN KEY(fk_Maquina) "
//                + "  REFERENCES Maquina(idMaquina),"
//                + "  PRIMARY KEY (idProcessador)"
//                + ");";
//
//        assistente.execute(createProcessador);
//
//        String createHistoricoProcessador = "CREATE TABLE historico_processador("
//                + "  idHistoricoProcessador INT NOT NULL AUTO_INCREMENT,"
//                + "  usoProcessador DOUBLE,"
//                + "  DATA_HORA DATETIME, fk_maquina int, foreign key(fk_maquina)"
//                + "  references maquina(idmaquina),"
//                + "  PRIMARY KEY (idHistoricoProcessador)"
//                + ");";
//
//        assistente.execute(createHistoricoProcessador);
//
//        String createRam = "CREATE TABLE RAM ("
//                + "  idRam INT NOT NULL AUTO_INCREMENT,"
//                + "  total DOUBLE, "
//                + "  fkmaquina int, foreign key(fkmaquina)"
//                + "  references maquina(idmaquina),"
//                + "  PRIMARY KEY (idRam)"
//                + ");";
//
//        assistente.execute(createRam);
//
//        String createHistoricoRam = "CREATE TABLE historico_ram("
//                + "  idHistoricoRam INT NOT NULL AUTO_INCREMENT,"
//                + "  usoRam DOUBLE,"
//                + "  disponivel DOUBLE,"
//                + "  DATA_HORA DATETIME, "
//                + "  fkram int, foreign key(fkRam) "
//                + "  references ram (idram),"
//                + "  PRIMARY KEY (idHistoricoRam)"
//                + ");";
//
//        assistente.execute(createHistoricoRam);
//
//        String createSoftware = "CREATE TABLE softwares("
//                + "  idSoftware INT NOT NULL AUTO_INCREMENT,"
//                + "  nomeSoftware varchar(45),"
//                + "  PRIMARY KEY (idSoftware)"
//                + ");";
//
//        assistente.execute(createSoftware);
//        
//        String createmaquinasoftware = "CREATE TABLE maquina_software("
//                + "  idMaquina_software INT NOT NULL AUTO_INCREMENT,"
//                + "  usoCPUSoftware DOUBLE,"
//                + "  usoRAMSoftware DOUBLE,"
//                + "  pid int,"
//                + "  DATA_HORA DATETIME, "
//                + "  fk_maquina int, foreign key(fk_maquina)" 
//                + "  references maquina(idmaquina),"
//                + "  fk_software int,foreign key(fk_software)" 
//                + "  references softwares(idsoftware),"
//                + "  PRIMARY KEY (idMaquina_software)"
//                + ");";
//
//        assistente.execute(createmaquinasoftware);


    }

}
