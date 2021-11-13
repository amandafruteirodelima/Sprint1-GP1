'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Gestor = sequelize.define('Gestor',{
		id: {
			field: 'idGestor',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},		
		nome: {
			field: 'NomeGestor',
			type: DataTypes.STRING,
			allowNull: false
		},
		email: {
			field: 'emailGestor',
			type: DataTypes.STRING,
			allowNull: false
		},
		senha: {
			field: 'senhaGestor',
			type: DataTypes.STRING,
			allowNull: false
		},
		fk_Empresa: {
			field: 'fk_Empresa',
			type: DataTypes.INTEGER,
			allowNull: false
		}
	}, 
	{
		tableName: 'Gestor', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Gestor;
};
