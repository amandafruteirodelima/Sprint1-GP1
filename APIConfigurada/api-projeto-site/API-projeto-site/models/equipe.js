	'use strict';

	/* 
	lista e explicação dos Datatypes:
	https://codewithhugo.com/sequelize-data-types-a-practical-guide/
	*/

	module.exports = (sequelize, DataTypes) => {
		let Equipe = sequelize.define('Equipe', {
			id: {
				field: 'idEquipe',
				type: DataTypes.INTEGER,
				primaryKey: true,
				autoIncrement: true
			},
			nome: {
				field: 'nomeEquipe',
				type: DataTypes.STRING,
				allowNull: false
			}
		}, {
			tableName: 'Equipe',
			freezeTableName: true,
			underscored: true,
			timestamps: false,
		});

		return Equipe;
	};