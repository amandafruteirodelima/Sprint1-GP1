'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Historico_Uso_Software = sequelize.define('Historico_Uso_Software',{
		idHistorico_Software: {
			field: 'idHistorico_Software',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},		
		dataHora: {
			field: 'dataHora',
			type: DataTypes.DATE,
			allowNull: false
		},
		consumo: {
			field: 'consumo',
			type: DataTypes.DOUBLE,
			allowNull: false
		},
		fk_Maquina: {
			field: 'fk_Maquina',
			type: DataTypes.INTEGER,
			allowNull: false
		},
		fk_Software: {
			field: 'fk_Software',
			type: DataTypes.INTEGER,
			allowNull: false
		}
	}, 
	{
		tableName: 'Historico_Uso_Software', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Historico_Uso_Software;
};
