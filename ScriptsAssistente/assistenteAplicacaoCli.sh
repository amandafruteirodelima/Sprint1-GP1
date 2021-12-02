#!/bin/bash

PURPLE='0;35'
NC='\033[0m' 
VERSAO=11


#Instalação do Java
	
echo  "$(tput setaf 10)[devBot (^O^)/]:$(tput setaf 7) Olá Usuário, serei seu assistente para instalação geral do ambiente e da aplicação da DevTime!;"

echo  "$(tput setaf 10)[devBot (^O^)/]:$(tput setaf 7) Eu e meus amigos iremos auxiliá-lo na hora da instalação! Agora fique com o Devinho para continuar as instalações!"

echo  "$(tput setaf 10)[Devinho <°-°>]:$(tput setaf 7) Olá Usuário,vou verificar aqui se você possui o Java instalado."

java -version
if [ $? -eq 0 ]
	then
		echo "$(tput setaf 10)[Devinho <°-°>]:$(tput setaf 7) : Ha!!! Identifiquei que você já tem o java instalado ;D!!!"

         echo "$(tput setaf 10)[Devinho <°-°>]:$(tput setaf 7) : Fique com devTob para continuar!"

	else
		echo "$(tput setaf 10)[Devinho <°-°>]:$(tput setaf 7)   Epa! Não identifiquei nenhuma versão do Java instalado, mas não se preocupe, irei resolver para você agora mesmo!"

		echo "$(tput setaf 10)[Devinho <°-°>]:$(tput setaf 7)   Confirme para mim se realmente deseja instalar o Java (s/n)?"

	read inst
	if [ \"$inst\" == \"s\" ]
		then
			echo "$(tput setaf 10)[Devinho <°-°>]:$(tput setaf 7)   Okay! Você optou por instalar o Java :D"
			echo "$(tput setaf 10)[Devinho <°-°>]:$(tput setaf 7)  Estou adicionando o repositório!"
			sleep 2
			sudo add-apt-repository ppa:webupd8team/java -y
			clear
			echo "$(tput setaf 10)[Devinho <°-°>]:$(tput setaf 7)  Atualizando! Estamos quase lá."
			sleep 2
			sudo apt update -y
			clear
			
			if [ $VERSAO -eq 11 ]
				then
					echo "$(tput setaf 10)[Devinho <°-°>]:$(tput setaf 7) Preparando para instalar a versão 11 do Java. Confirme a instalação quando solicitado :)"

					sudo apt install default-jre ; apt install openjdk-11-jre-headless; -y
					clear

					echo "$(tput setaf 10)[Devinho <°-°>]:$(tput setaf 7) Java instalado com sucesso \(^0^)/!!!IRRRA!"
				fi
		else 	

		echo "$(tput setaf 10)[Devinho <°-°>]:$(tput setaf 7)  Você optou por não instalar o Java por enquanto ;-; ,não se esqueça de que precisará do Java para rodar a aplicação, até a próxima então dev!"

        echo "$(tput setaf 10)[Devinho <°-°>]:$(tput setaf 7) : Fique com devTob para continuar."
	fi
fi

#Instalação do Git

echo  "$(tput setaf 10)[devTob *-*/]:$(tput setaf 7) Olá Usuário, serei seu assistente para instalação do Git!;"
echo  "$(tput setaf 10)[devTob *-*/]:$(tput setaf 7) Verificando aqui se você possui o Git instalado...;"

git --version

if [ $? -eq 0 ]

then
		echo "$(tput setaf 10)[devTob *-*/]:$(tput setaf 7) : Ha!!! Identifiquei que você já tem o git instalado ;D!!!"

		echo "$(tput setaf 10)[devTob *-*/]:$(tput setaf 7) : devBot irá continuar te ajudando , até mais!!!"

else
		echo "$(tput setaf 10)[devTob *-*/]:$(tput setaf 7)   Epa! Não identifiquei nenhuma versão do Git instalado, mas não se preocupe, irei resolver para você agora mesmo!"

		echo "$(tput setaf 10)[devTob *-*/]:$(tput setaf 7)   Confirme para mim se realmente deseja instalar o Git (s/n)?"
        read inst

if [ \"$inst\" == \"s\" ]
then
			echo "$(tput setaf 10)[devTob *-*/]:$(tput setaf 7)  Okay! Você optou por instalar o Git :D"

			echo "$(tput setaf 10)[devTob *-*/]:$(tput setaf 7)  Primeiros vamos atualizar seus pacotes!"
			sleep 2
			sudo apt-get update
			clear

        echo "$(tput setaf 10)[devTob *-*/]:$(tput setaf 7) Preparando para instalar a última versão do Git. Confirme a instalação quando solicitado :)"
					sudo apt-get install git
					clear 
					echo "$(tput setaf 10)[devTob *-*/]:$(tput setaf 7) Git instalado com sucesso \(^0^)/!!!IRRRA!"

        else 	

		echo "$(tput setaf 10)[devTob *-*/]:$(tput setaf 7)  Você optou por não instalar o Git por enquanto ;-; , até a próxima então dev! Lembre-se que você irá precisar do git para fazer a aplicação funcionar."

        echo "$(tput setaf 10)[devTob *-*/]:$(tput setaf 7) : devBot irá continuar te ajudando , até mais."
		
    fi

fi

#Instalação da Aplicação

echo  "$(tput setaf 10)[devBot (^O^)/]:$(tput setaf 7) Olá novamente Usuário! Serei seu assistente para instalação da aplicação da DevTime!"
sleep 1
echo  "$(tput setaf 10)[devBot (^O^)/]:$(tput setaf 7) Você já possui nossa aplicação?(s/n)"

read inst10

if [ \"$inst10\" == \"n\"  ]
    then
    echo  "$(tput setaf 10)[devBot (^O^)/]:$(tput setaf 7) Okay, vi que você não possui nossa aplicação."

    echo  "$(tput setaf 10)[devBot (^O^)/]:$(tput setaf 7) Deseja instalar nossa aplicação?(s/n)" 

    read inst6

    if [ \"$inst6\" == \"s\" ]

    then
    echo  "$(tput setaf 10)[devBot (^O^)/]:$(tput setaf 7) Estarei instalando o repositório em sua máquina!" 

    sleep 2

    echo  "$(tput setaf 10)[devBot (^O^)/]:$(tput setaf 7) Aguarde um momento porfavor!"

    sleep 2 

    git clone https://github.com/amandafruteirodelima/Sprint1-GP1.git

    sleep 2

    echo  "$(tput setaf 10)[devBot (^O^)/]:$(tput setaf 7) Pronto! Repositório instalado com sucesso!!!"
    
    sleep 2
    
    echo  "$(tput setaf 10)[devBot (^O^)/]:$(tput setaf 7) Agora estarei instalando a aplicação em seu 
    ubuntu!"
    
    cd Sprint1-GP1
cd MonitoramentoJava
    
    mv devtime-cli-8.5-jar-with-dependencies.jar /home/ubuntu
    sleep 2
    cd ..
cd ..
    rm -r Sprint1-GP1 -f

     else

     echo  "$(tput setaf 10)[devBot (^O^)/]:$(tput setaf 7) Okay, não irei instalar a nossa aplicação. Até mais Dev!"
    exit
     fi

else
echo  "$(tput setaf 10)[devBot (^O^)/]:$(tput setaf 7) Okay!Você já tem nossa aplicação!!!"

fi
#instalação APlicação




# ===================================================================
# Todos direitos reservados para o autor: Dra. Profa. Marise Miranda.
# Sob licença Creative Commons @2020
# Podera modificar e reproduzir para uso pessoal.
# Proibida a comercialização e a exclusão da autoria.
# ===================================================================