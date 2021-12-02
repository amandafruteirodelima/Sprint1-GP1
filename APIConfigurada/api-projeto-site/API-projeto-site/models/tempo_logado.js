'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let TempoLogado = sequelize.define('TempoLogado', {
        fk_Funcionario: {
            field: 'fk_Funcionario',
            type: DataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        dia: {
            field: 'dia',
            type: DataTypes.DATE,
            allowNull: false
        },
        idLogado: {
            field: 'idLogado',
            type: DataTypes.INTEGER,
            allowNull: false
        }
    }, {
        tableName: 'Tempo_Logado',
        freezeTableName: true,
        underscored: true,
        timestamps: false,
    });

    return TempoLogado;
};