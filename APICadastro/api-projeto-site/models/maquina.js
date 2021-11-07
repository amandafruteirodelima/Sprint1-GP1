'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Maquina = sequelize.define('Maquina',{
		idMaquina: {
			field: 'idMaquina',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},		
		sistemaOperacional: {
			field: 'sistemaOperacional',
			type: DataTypes.STRING,
			allowNull: false
		},
		arquiteturaSo: {
			field: 'arquiteturaSo',
			type: DataTypes.STRING,
			allowNull: false
		},
		fabricanteSo: {
			field: 'fabricanteSo',
			type: DataTypes.STRING,
			allowNull: false
		},
		fk_Funcionario: {
			field: 'fk_Funcionario',
			type: DataTypes.INTEGER,
			allowNull: true
		}
	}, 
	{
		tableName: 'Maquina', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Maquina;
};
