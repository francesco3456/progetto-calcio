
function toBack() {
    window.location.href = "file:///C:/Users/franc/Documents/progetto-Calcio-versione-microservizi/frontend/home.html";
}

// Richiesta AJAX per ottenere i dati della lista dei campionati
var xhr = new XMLHttpRequest();
xhr.open('GET', 'http://localhost:8765/lega-inglese/giornata', true);

xhr.onload = function () {
    if (xhr.status === 200) {
        console.log("Risposta del server:", xhr.responseText); // Log della risposta del server

        // Converti la risposta JSON in un array di nomi di campionato
        var data = xhr.responseText.replace(/[\[\]"']/g, '').split(',');

        console.log("Array di dati:", data); // Log dell'array dei dati

        // Aggiungi dinamicamente gli elementi della lista dei campionati
        var menuList = document.getElementById('menu-list');
        console.log("Elemento menuList:", menuList); // Log dell'elemento menu-list

        if (menuList) {
            data.forEach(function (giornata) {
                var listItem = document.createElement('li');  // Crea un elemento <li>
                var button = document.createElement('button');  // Crea un elemento <button>
                button.textContent = giornata.trim(); // Rimuove eventuali spazi vuoti
                button.addEventListener('click', function() {
                    aggiornaPartitePerGiornata(idCampionato, giornata.trim());
                });
                listItem.appendChild(button);  // Aggiunge il bottone al <li>
                menuList.appendChild(listItem);  // Aggiunge il <li> alla lista
            });
        } else {
            console.error("Elemento con ID 'menu-list' non trovato.");
        }
    } else {
        console.error('Errore nella richiesta:', xhr.status);
    }
};
xhr.send();

// Richiesta AJAX per ottenere i dati della tabella "classifica"
var xhrClassifica = new XMLHttpRequest();
xhrClassifica.open('GET', 'http://localhost:8765/lega-inglese/punteggi', true);
xhrClassifica.onload = function () {
    if (xhrClassifica.status === 200) {
        // Converti la risposta JSON in un array di righe della tabella
        var data = JSON.parse(xhrClassifica.responseText);
        console.log("Dati della classifica:", data);

        // Aggiorna la tabella "classifica" con i dati ottenuti dalla risposta
        if (Array.isArray(data) && data.length > 0) {
            aggiornaTabellaClassifica('classifica', data);
        }
    } else {
        console.error('Errore nella richiesta per la classifica');
    }
};
xhrClassifica.send();

// Richiesta AJAX per ottenere i dati della tabella "partite"
var xhrPartite = new XMLHttpRequest();
xhrPartite.open('GET', 'http://localhost:8765/lega-inglese/ultime-partite', true);
xhrPartite.onload = function () {
    if (xhrPartite.status === 200) {
        // Converti la risposta JSON in un array di righe della tabella
        var data = JSON.parse(xhrPartite.responseText);
        console.log("Dati delle partite:", data);

        // Aggiorna la tabella "partite" con i dati ottenuti dalla risposta
        if (Array.isArray(data) && data.length > 0) {
            aggiornaTabellaPartite('partite', data);
        }
    } else {
        console.error('Errore nella richiesta per le partite');
    }
};
xhrPartite.send();

// Funzione per aggiornare la tabella della classifica
function aggiornaTabellaClassifica(idTabella, data) {
    let table = document.getElementById(idTabella);
    let tbody = table.querySelector("tbody");

    // Cancella le righe esistenti
    tbody.innerHTML = '';

    // Aggiungi nuove righe
    data.forEach(match => {
        let row = document.createElement("tr");

        let cellSquadra = document.createElement("td");
        // Accedi al nome della squadra utilizzando il campo codiceSquadra
        let nomeSquadra = match.squadra ? match.squadra.nomeSquadra : 'N/A';
        cellSquadra.textContent = nomeSquadra;
        row.appendChild(cellSquadra);

        let cellPunti = document.createElement("td");
        cellPunti.textContent = match.puntiSquadra || '0';
        row.appendChild(cellPunti);

        let cellVittorie = document.createElement("td");
        cellVittorie.textContent = match.vittorieSquadra || '0';
        row.appendChild(cellVittorie);

        let cellPareggi = document.createElement("td");
        cellPareggi.textContent = match.pareggiSquadra || '0';
        row.appendChild(cellPareggi);

        let cellSconfitte = document.createElement("td");
        cellSconfitte.textContent = match.sconfitteSquadra || '0';
        row.appendChild(cellSconfitte);

        let cellGolFatti = document.createElement("td");
        cellGolFatti.textContent = match.golFattiSquadra || '0';
        row.appendChild(cellGolFatti);

        let cellGolSubiti = document.createElement("td");
        cellGolSubiti.textContent = match.golSubitiSquadra || '0';
        row.appendChild(cellGolSubiti);

        let cellDifferenzaReti = document.createElement("td");
        cellDifferenzaReti.textContent = match.differenzaRetiSquadra || '0';
        row.appendChild(cellDifferenzaReti);

        tbody.appendChild(row);
    });
}

// Funzione per aggiornare la tabella delle partite
function aggiornaTabellaPartite(idTabella, data) {
    let table = document.getElementById(idTabella);
    let tbody = table.querySelector("tbody");

    // Cancella le righe esistenti
    tbody.innerHTML = '';

    // Aggiungi nuove righe
    data.forEach(match => {
        let row = document.createElement("tr");

        let cellCasa = document.createElement("td");
        cellCasa.textContent = match.squadraCasa || 'N/A';
        row.appendChild(cellCasa);

        let cellRisultato = document.createElement("td");
        cellRisultato.textContent = match.risultatoPartita !== null ? match.risultatoPartita : '-';
        row.appendChild(cellRisultato);

        let cellOspite = document.createElement("td");
        cellOspite.textContent = match.squadraOspite || 'N/A';
        row.appendChild(cellOspite);

        let cellData = document.createElement("td");
        cellData.textContent = match.dataPartita || 'N/A';
        row.appendChild(cellData);

        tbody.appendChild(row);
    });
}

// Funzione per aggiornare la tabella delle partite per una specifica giornata

var idCampionato = 6;
function aggiornaPartitePerGiornata(idCampionato, giornata) {
    var xhrGiornata = new XMLHttpRequest();
    xhrGiornata.open('GET', 'http://localhost:8765/lega-inglese/partite-giornata/' + encodeURIComponent(giornata) + '/' + encodeURIComponent(idCampionato), true);
    xhrGiornata.onload = function () {
        if (xhrGiornata.status === 200) {
            var data = JSON.parse(xhrGiornata.responseText);
            console.log("Dati delle partite per la giornata " + giornata + ":", data);

            // Aggiorna la tabella "partite" con i dati ottenuti dalla risposta
            if (Array.isArray(data) && data.length > 0) {
                aggiornaTabellaPartite('partite', data);
            }
        } else {
            console.error('Errore nella richiesta per la giornata ' + giornata);
        }
    };
    xhrGiornata.send();
}
