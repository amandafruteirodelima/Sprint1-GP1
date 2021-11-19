'use strict';

/* 
	lista e explicação dos Datatypes:
	https://codewithhugo.com/sequelize-data-types-a-practical-guide/
	*/



    module.exports = (sequelize, DataTypes) => {
		let Funcionario_Conquista = sequelize.define('Funcionario_Conquista', {
			idFuncionarioConquista: {
				field: 'idFuncionario_Conquista',
				type: DataTypes.INTEGER,
				primaryKey: true,
				autoIncrement: true
			},
			fk_Funcionario: {
				field: 'fk_Funcionario',
				type: DataTypes.INTEGER,
				allowNull: true
			},
			fk_Conquista: {
				field: 'fk_Conquista',
				type: DataTypes.INTEGER,
				allowNull: false
			},
			checkCompleta: {
				field: 'checkCompleta',
				type: DataTypes.BOOLEAN,
				allowNull: false
			},

		}, {
			tableName: 'Funcionario_Conquista',
			freezeTableName: true,
			underscored: true,
			timestamps: false,
		});

		return Funcionario_Conquista;
	};