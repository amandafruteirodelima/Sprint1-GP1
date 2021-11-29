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
                qntdPontos.innerHTML = `${sessionStorage.devCoinFuncionario}`
                qntdDevCoins.innerHTML = `${sessionStorage.pontosFuncionario}` 
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
                    <buttom class ="btn-finalizar">Finalizar</buttom>
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