	'use strict';

	/* 
	lista e explicação dos Datatypes:
	https://codewithhugo.com/sequelize-data-types-a-practical-guide/
	*/

	module.exports = (sequelize, DataTypes) => {
		let Equipe_Funcionario = sequelize.define('Equipe_Funcionario', {
			fk_equipe: {
				field: 'fk_equipe',
				type: DataTypes.INTEGER,
				primaryKey: true,
				allowNull: false
			},
			fk_funcionario: {
				field: 'fk_funcionario',
				type: DataTypes.INTEGER,
				primaryKey: true,
				allowNull: false
			}
		}, {
			tableName: 'Equipe_Funcionario',
			freezeTableName: true,
			underscored: true,
			timestamps: false,
		});

		return Equipe_Funcionario;
	};