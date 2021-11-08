'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Software = sequelize.define('Software',{
		idSoftware: {
			field: 'idSoftware',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},		
		nomeSoftware: {
			field: 'nomeSoftware',
			type: DataTypes.STRING,
			allowNull: false
		},
		linkImagemSoftware: {
			field: 'linkImagemSoftware',
			type: DataTypes.STRING,
			allowNull: false
		}
	}, 
	{
		tableName: 'Software', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Software;
};
