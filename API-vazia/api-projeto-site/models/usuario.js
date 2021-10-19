	'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Usuario = sequelize.define('Usuario',{
		id: {
			field: 'idFuncionario',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},		
		nome: {
			field: 'nomeFuncionario',
			type: DataTypes.STRING,
			allowNull: false
		},
		cargaHoraria: {
			field: 'cargaHoraria',
			type: DataTypes.INTEGER,
			allowNull: false
		},
		email: {
			field: 'email',
			type: DataTypes.STRING,
			allowNull: false
		},
		senha: {
			field: 'senha',
			type: DataTypes.STRING,
			allowNull: false
		},
		devCoinFuncionario: {
			field: 'devCoinFuncionario',
			type: DataTypes.INTEGER,
			allowNull: true
		},
		pontosFuncionario: {
			field: 'pontosFuncionario',
			type: DataTypes.INTEGER,
			allowNull: true
		},
		fk_Empresa: {
			field: 'fk_Empresa',
			type: DataTypes.INTEGER,
			allowNull: false
		},
		fk_Equipe: {
			field: 'fk_Equipe',
			type: DataTypes.INTEGER,
			allowNull: false
		},
	}, 
	{
		tableName: 'Funcionario', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Usuario;
};
