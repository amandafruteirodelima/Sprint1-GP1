'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Componente = sequelize.define('Componente',{
		idComponente: {
			field: 'idComponente',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},		
		nomeComponente: {
			field: 'nomeComponente',
			type: DataTypes.STRING,
			allowNull: false
		},
		capacidade: {
			field: 'capacidade',
			type: DataTypes.DOUBLE,
			allowNull: false
		},
		descricao: {
			field: 'descricao',
			type: DataTypes.STRING,
			allowNull: false
		},
		infoAdicional: {
			field: 'infoAdicional',
			type: DataTypes.STRING,
			allowNull: false
		},
		unidadeDeMedida: {
			field: 'unidadeDeMedida',
			type: DataTypes.STRING,
			allowNull: true
		},
		fk_Maquina: {
			field: 'fk_Maquina',
			type: DataTypes.INTEGER,
			allowNull: true
		}
	}, 
	{
		tableName: 'Componente', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Componente;
};
