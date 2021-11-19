'use strict';

/* 
	lista e explicação dos Datatypes:
	https://codewithhugo.com/sequelize-data-types-a-practical-guide/
	*/



    module.exports = (sequelize, DataTypes) => {
		let Conquista = sequelize.define('Conquista', {
			idConquista: {
				field: 'idConquista',
				type: DataTypes.INTEGER,
				primaryKey: true,
				autoIncrement: true
			},
			nomeConquista: {
				field: 'nomeConquista',
				type: DataTypes.STRING,
				allowNull: false
			},
			descConquista: {
				field: 'descConquista',
				type: DataTypes.STRING,
				allowNull: false
			},
			devCoinConquista: {
				field: 'devCoinConquista',
				type: DataTypes.INTEGER,
				allowNull: false
			},
			pontosConquista: {
				field: 'pontosConquista',
				type: DataTypes.INTEGER,
				allowNull: false
			},
			xpConquista: {
				field: 'xpConquista',
				type: DataTypes.INTEGER,
				allowNull: true
			},

		}, {
			tableName: 'Conquista',
			freezeTableName: true,
			underscored: true,
			timestamps: false,
		});

		return Conquista;
	};