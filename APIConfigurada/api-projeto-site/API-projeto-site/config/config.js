module.exports = {
  // Insira aqui seus dados do banco NA NUVEM AZURE
  production: {
    // altere APENAS username, password, database e host.
    username: 'Grupo01',
    password: '@#grupo1',
    database: 'grupo1-Devtime',
    host: 'servidor-grupo1-devtime.database.windows.net',
    dialect: 'mssql',
    xuse_env_variable: 'DATABASE_URL',
    dialectOptions: {
      options: {
        encrypt: true
      }
    },
    pool: { 
      max: 1000,
      min: 1,
      acquire: 5000,
      idle: 3000000,
      connectTimeout: 500000000
    }
  },

  // Insira aqui seus dados do banco LOCAL - MySQL Workbench
  dev: {
    // altere APENAS username, password e database.
    username: 'SEU USUARIO DO WORKBENCH, provavelmente é root',
    password: 'SUA SENHA DO WORKBENCH',
    database: 'SEU DATABASE DO CREATE DATABASE',
    host: '127.0.0.1',
    dialect: 'mysql',
    xuse_env_variable: 'DATABASE_URL',
    dialectOptions: {
      options: {
        encrypt: true
      }
    },
    pool: { 
      max: 1000,
      min: 1,
      acquire: 5000,
      idle: 3000000,
      connectTimeout: 500000000000
    }
  },
};