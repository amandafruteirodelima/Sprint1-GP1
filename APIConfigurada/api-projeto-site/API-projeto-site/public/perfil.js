//Nesta função estamos recuperando as conquistas e os valores de devCoins

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
                sessionStorage.pontosFuncionario = json[0].pontosFuncionario;
                sessionStorage.devCoinFuncionario = json[0].devCoinFuncionario;
                definirNivel();

                qntdPontos.innerHTML = `${sessionStorage.pontosFuncionario}`
                qntdDevCoins.innerHTML =  `${sessionStorage.devCoinFuncionario}`
                b_usuario.innerHTML = `${sessionStorage.nome}`
                var idDivs = 0;
                
                

                for(i = 0; i < json.length; i++){

                    var TextoFinalizada = "Finalizada!"

                    if(json[i].checkCompleta == 0){
                        TextoFinalizada = "Conquista não finalizada!"
                    }

                    if(json[i].checkCompleta == 1){
                        divListaConquista.innerHTML += 
                        `<div idDiv = ${idDivs} class="div-conquista-usuario finalizada">
                        <img class="img-conquista" src= "https://cdn-icons-png.flaticon.com/512/1651/1651611.png">
                        Nome: ${json[i].nomeConquista} <br>
                        Descrição: ${json[i].descConquista} <br>
                        Status: ${TextoFinalizada}
                        </div>`
                        idDivs++;
                    }
                    else{
                        divListaConquista.innerHTML += 
                        `<div idDiv = ${idDivs} class="div-conquista-usuario">
                        <img class="img-conquista" src= "https://cdn-icons-png.flaticon.com/512/1651/1651611.png">
                        Nome: ${json[i].nomeConquista} <br>
                        Descrição: ${json[i].descConquista} <br>
                        Status: ${TextoFinalizada}
                        </div>`
                        idDivs++;
                    }
                    
              
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
    if(sessionStorage.pontosFuncionario > 2000 && sessionStorage.pontosFuncionario <= 5000){
        nivel_user.innerHTML = '2';
    }
    else if(sessionStorage.pontosFuncionario > 5000 && sessionStorage.pontosFuncionario <= 8000){
        nivel_user.innerHTML = '3';
    }
    else if(sessionStorage.pontosFuncionario > 8000 && sessionStorage.pontosFuncionario <= 10000){
        nivel_user.innerHTML = '4';
    }
    else if(sessionStorage.pontosFuncionario > 10000 && sessionStorage.pontosFuncionario <= 12000){
        nivel_user.innerHTML = '5';
    }
    else if(sessionStorage.pontosFuncionario > 12000 && sessionStorage.pontosFuncionario <= 10000){
        nivel_user.innerHTML = '6';
    }
    else if(sessionStorage.pontosFuncionario > 14000 && sessionStorage.pontosFuncionario <= 16000){
        nivel_user.innerHTML = '7';
    }
    else if(sessionStorage.pontosFuncionario > 16000 && sessionStorage.pontosFuncionario <= 18000){
        nivel_user.innerHTML = '8';
    }
    else if(sessionStorage.pontosFuncionario > 18000 && sessionStorage.pontosFuncionario <= 20000){
        nivel_user.innerHTML = '9';
    }
    else if(sessionStorage.pontosFuncionario > 20000){
        nivel_user.innerHTML = '10';
    }
    else{
        nivel_user.innerHTML = '1'; 
    }

}



function finalizarConquista(){
    //var formulario = new URLSearchParams(new FormData(form_finalizar));
    let corpo = {
        nomeConquista: input_nome_conquista.value,
        devCoinsAtual: sessionStorage.devCoinFuncionario,
        pontosAtual: sessionStorage.pontosFuncionario,
        idFuncionario: sessionStorage.idFuncionario
    };

    console.log(corpo);

        fetch("/Funcionario_Conquista/atualizar", {
            method: "POST",
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(corpo)
        }).then(function (response) {
            if (response.ok) {
                alert("Tarefa finaliza!!!Parabéns dev!");
                console.log("Atualização feita com sucesso!");
                //PAGINA ANTERIOR ESTAVA RANKING.HTML
                window.location.href = 'dashboard_funcs.html';
            } else {
                alert('Erro de atualização!');
            }
        });

        return false;
}




z