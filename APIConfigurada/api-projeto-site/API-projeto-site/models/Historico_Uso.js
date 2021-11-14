'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Historico_Uso = sequelize.define('Historico_Uso',{
		idHistoricoUso: {
			field: 'idHistoricoUso',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},		
		fk_Componente: {
			field: 'fk_Componente',
			type: DataTypes.STRING,
			allowNull: false
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
		}
	}, 
	{
		tableName: 'Historico_Uso', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Historico_Uso;
};
