        // Funzione per aggiornare la tabella
        function aggiornaTabella(idTabella, data) {
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

                tbody.appendChild(row);
            });
        }

// Effettua una richiesta AJAX per ottenere i dati dei campionati dall'API Gateway
var xhr = new XMLHttpRequest();
xhr.open('GET', 'http://localhost:8765/home/menu', true);
xhr.onload = function () {
    if (xhr.status === 200) {
        // Converti la risposta JSON in un array di nomi di campionato
        var data = xhr.responseText.replace(/[\[\]"']/g, '').split(',');

        console.log(data);

        // Aggiungi dinamicamente gli elementi della lista dei campionati
        var menuList = document.getElementById('menu-list');
        data.forEach(function (campionato) {
            var button = document.createElement('button');
            button.textContent = campionato.trim(); // Rimuove eventuali spazi vuoti
            button.addEventListener('click', function() {
                // Converti la stringa in minuscolo, rimuovi spazi e caratteri non validi
                var safeCampionatoName = campionato.trim().toLowerCase().replace(/\s+/g, '');
                window.location.href = safeCampionatoName + '.html';
            });
            menuList.appendChild(button);

            // Aggiungi un elemento <br> dopo ogni bottone per creare una nuova riga
            var lineBreak = document.createElement('br');
            menuList.appendChild(lineBreak);
        });
    } else {
        console.error('Errore nella richiesta');
    }
};
xhr.send();



        // Effettua una richiesta AJAX per ottenere i dati della tabella "ieri"
        var xhrIeri = new XMLHttpRequest();
        xhrIeri.open('GET', 'http://localhost:8765/home/matchYesterday', true);
        xhrIeri.onload = function () {
            if (xhrIeri.status === 200) {
                // Converti la risposta JSON in un array di righe della tabella
                var data = JSON.parse(xhrIeri.responseText);
                console.log(data);

                // Aggiorna la tabella "ieri" con i dati ottenuti dalla risposta
                if (Array.isArray(data) && data.length > 0) {
                    aggiornaTabella('ieri', data);
                }
            } else {
                console.error('Errore nella richiesta per ieri');
            }
        };
        xhrIeri.send();

        // Effettua una richiesta AJAX per ottenere i dati della tabella "oggi"
        var xhrOggi = new XMLHttpRequest();
        xhrOggi.open('GET', 'http://localhost:8765/home/matchday', true);
        xhrOggi.onload = function () {
            if (xhrOggi.status === 200) {
                // Converti la risposta JSON in un array di righe della tabella
                var data = JSON.parse(xhrOggi.responseText);
                console.log(data);

                // Aggiorna la tabella "oggi" con i dati ottenuti dalla risposta
                if (Array.isArray(data) && data.length > 0) {
                    aggiornaTabella('oggi', data);
                }
            } else {
                console.error('Errore nella richiesta per oggi');
            }
        };
        xhrOggi.send();

        // Effettua una richiesta AJAX per ottenere i dati della tabella "domani"
        var xhrDomani = new XMLHttpRequest();
        xhrDomani.open('GET', 'http://localhost:8765/home/matchTomorrow', true);
        xhrDomani.onload = function () {
            if (xhrDomani.status === 200) {
                // Converti la risposta JSON in un array di righe della tabella
                var data = JSON.parse(xhrDomani.responseText);
                console.log(data);

                // Aggiorna la tabella "domani" con i dati ottenuti dalla risposta
                if (Array.isArray(data) && data.length > 0) {
                    aggiornaTabella('domani', data);
                }
            } else {
                console.error('Errore nella richiesta per domani');
            }
        };
        xhrDomani.send();