function toBack() {
    window.location.href = "file:///C:/Users/franc/Documents/progetto-Calcio-versione-microservizi/frontend/serie-a/serieA.html";
}


function openModal(id, nomeCalciatore, cognomeCalciatore, eta, nazionalita, golCalciatore, assistCalciatore) {
    var modal = document.getElementById(id);
    modal.querySelector('.nome-popup').textContent = 'Nome: ' + nomeCalciatore;
    modal.querySelector('.cognome-popup').textContent = 'Cognome: ' + cognomeCalciatore;
    modal.querySelector('.eta-calciatore').textContent = 'Età: ' + eta;
    modal.querySelector('.nazionalita-calciatore').textContent = 'Nazionalità: ' + nazionalita;
    modal.querySelector('.gol-calciatore').textContent = 'Gol: ' + golCalciatore;
    modal.querySelector('.assist-calciatore').textContent = 'Assist: ' + assistCalciatore;
    modal.style.display = 'block';
}

function closeModal(id) {
    document.getElementById(id).style.display = 'none';
}

//richiesta AJAX per recuperare i dati dei calciatori dell'inter

var xhrRoma = new XMLHttpRequest();
var idSquadra = 9;
var codiceSquadra = "ROM";

xhrRoma.open('GET', 'http://localhost:8765/recupero-stats/calciatori/' + encodeURIComponent(idSquadra) + '/' + encodeURIComponent(codiceSquadra), true);
xhrRoma.onload = function () {
    if (xhrRoma.status === 200) {
        console.log("Risposta del server:", xhrRoma.responseText);

        // Converti la risposta JSON in un array di oggetti calciatori
        var data = JSON.parse(xhrRoma.responseText);
        console.log("Array di dati:", data);

        // Seleziona il container dei calciatori
        var portieriContainer = document.getElementById('portieri-container');
        var difensoriContainer = document.getElementById('difensori-container');
        var centrocampoContainer = document.getElementById('centrocampo-container');
        var attaccoContainer = document.getElementById('attacco-container');

        // Svuota il container
        portieriContainer.innerHTML = '';
        difensoriContainer.innerHTML = '';
        centrocampoContainer.innerHTML = '';
        attaccoContainer.innerHTML = '';

        // Itera attraverso i dati e crea gli elementi HTML dinamicamente
        data.forEach(function (item, index) {
            // Accedi ai dati del calciatore
            var calciatore = item.calciatori;
            var stats = item.stats;

            var golCalciatore = stats.golCalciatore;
            var assistCalciatore = stats.assistCalciatore;

            var codiceCalciatore = calciatore.codiceCalciatore;
            var nomeCalciatore = calciatore.nome;
            var cognomeCalciatore = calciatore.cognome;
            var ruoloCalciatore = calciatore.ruoloCalciatore;
            var etaCalciatore = calciatore.eta;
            var nazionalitaCalciatore = calciatore.nazionalita;

            // Verifica se il codice calciatore è definito
            if (codiceCalciatore) {
                var calciatoreDiv = document.createElement('div');
                calciatoreDiv.className = 'calciatore';
                // Genera il percorso dell'immagine usando il codice del calciatore
                calciatoreDiv.style.backgroundImage = 'url("images_roma/' + codiceCalciatore.toLowerCase() + '.jpg")';

                var nomeCalciatoreDiv = document.createElement('div');
                nomeCalciatoreDiv.className = 'nome-calciatore';

                var a = document.createElement('a');
                a.href = '#';
                a.textContent = nomeCalciatore + ' '+ cognomeCalciatore;
                a.id = 'link-' + index;
                a.onclick = function (event) {
                    event.preventDefault();
                    openModal('modal-' + index, nomeCalciatore, cognomeCalciatore, etaCalciatore, nazionalitaCalciatore, golCalciatore, assistCalciatore);
                };

                var modalDiv = document.createElement('div');
                modalDiv.id = 'modal-' + index;
                modalDiv.className = 'modal-calciatore';

                var button = document.createElement('button');
                button.textContent = 'Close';
                button.onclick = function () {
                    closeModal('modal-' + index);
                };

                var nomeDiv = document.createElement('div');
                nomeDiv.className = 'nome-popup';
                var cognomeDiv = document.createElement('div');
                cognomeDiv.className = 'cognome-popup';
                var golDiv = document.createElement('div');
                golDiv.className = 'gol-calciatore';
                var assistDiv = document.createElement('div');
                assistDiv.className = 'assist-calciatore';
                var nazionalitaDiv = document.createElement('div');
                nazionalitaDiv.className = 'nazionalita-calciatore';
                var etaDiv = document.createElement('div');
                etaDiv.className = 'eta-calciatore';

                modalDiv.appendChild(nomeDiv);
                modalDiv.appendChild(cognomeDiv);
                modalDiv.appendChild(etaDiv);
                modalDiv.appendChild(nazionalitaDiv);
                modalDiv.appendChild(golDiv);
                modalDiv.appendChild(assistDiv);
                modalDiv.appendChild(button);
                nomeCalciatoreDiv.appendChild(a);
                nomeCalciatoreDiv.appendChild(modalDiv);
                calciatoreDiv.appendChild(nomeCalciatoreDiv);

                if (ruoloCalciatore === 'POR') {
                portieriContainer.appendChild(calciatoreDiv);
                } else if (ruoloCalciatore === 'DIF') {
                    difensoriContainer.appendChild(calciatoreDiv);
                } else if (ruoloCalciatore === 'CEN') {
                    centrocampoContainer.appendChild(calciatoreDiv);
                } else {
                    attaccoContainer.appendChild(calciatoreDiv);
                }
            }
        });
    }
};

xhrRoma.send();

