function recuperar() {
   
    console.log("idFuncionário:", sessionStorage.idFuncionario)
    let corpo = {
        "idFuncionario": sessionStorage.idFuncionario
        
    };
    fetch("/Funcionario_Conquista/recuperar", {
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(corpo)
    }).then(resposta => {

        if (resposta.ok) {

            resposta.json().then(json => {
                definirNivel();
                qntdPontos.innerHTML = `${sessionStorage.pontosFuncionario}`
                qntdDevCoins.innerHTML =  `${sessionStorage.devCoinFuncionario}`
                nomeUsuario.innerHTML = `${sessionStorage.nome}`
                var idDivs = 0;
                

                for(i = 0; i < json.length; i++){

                    var TextoFinalizada = "Finalizada!"
                    if(!json[i].checkCompleta){
                        TextoFinalizada = "Conquista não finalziada!"
                    }

                    divListaConquista.innerHTML += 
                    `<div idDiv = ${idDivs} class="div-conquista-usuario">
                    <img class="img-conquista" src= "https://cdn-icons-png.flaticon.com/512/1651/1651611.png">
                    ${json[i].nomeConquista} <br>
                    Descrição: ${json[i].descConquista} <br>
                    Status: ${TextoFinalizada}
                    <buttom onclick="finalizarConquista(0)" class ="btn-finalizar">Finalizar</buttom>
                    </div>`

                    idDivs++;
                    
                }
                console.log(json);

            });

        } else {

            console.log('Deu ruim oh nono!');
            alert('Deu ruim oh nono!')

            resposta.text().then(texto => {
                console.error(texto);

            });
        }
    });

    return false;
}



function definirNivel(){
    if(sessionStorage.pontosFuncionario > 20 && sessionStorage.pontosFuncionario <= 50){
        nivel_user.innerHTML = '2';
    }
    else if(sessionStorage.pontosFuncionario > 50 && sessionStorage.pontosFuncionario <= 100){
        nivel_user.innerHTML = '3';
    }
    else if(sessionStorage.pontosFuncionario > 80 && sessionStorage.pontosFuncionario <= 100){
        nivel_user.innerHTML = '4';
    }
    else if(sessionStorage.pontosFuncionario > 100 && sessionStorage.pontosFuncionario <= 120){
        nivel_user.innerHTML = '5';
    }
    else if(sessionStorage.pontosFuncionario > 120 && sessionStorage.pontosFuncionario <= 100){
        nivel_user.innerHTML = '6';
    }
    else if(sessionStorage.pontosFuncionario > 140 && sessionStorage.pontosFuncionario <= 160){
        nivel_user.innerHTML = '7';
    }
    else if(sessionStorage.pontosFuncionario > 160 && sessionStorage.pontosFuncionario <= 180){
        nivel_user.innerHTML = '8';
    }
    else if(sessionStorage.pontosFuncionario > 180 && sessionStorage.pontosFuncionario <= 200){
        nivel_user.innerHTML = '9';
    }
    else if(sessionStorage.pontosFuncionario > 200){
        nivel_user.innerHTML = '10';
    }
    else{
        nivel_user.innerHTML = '1'; 
    }

}



function finalizarConquista(fk_Conquista){
    let corpo = {
        "fk_Conquista": fk_Conquista
    };
        fetch("/atualizar", {
            method: "POST",
            body: JSON.stringify(corpo)
        }).then(function (response) {

            if (response.ok) {
                alert("Atualização feita com sucesso!")

            } else {

                alert('Erro de atualização!');

            }
        });

        return false;

}


function trocarFoto(){

}


function desfazerFinalizacaoConquista(){
    
}