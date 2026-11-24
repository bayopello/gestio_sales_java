# Resum

**Persona A · `src/personaA/`**
- `model/`: `Pacient` + 4 subclasses → `calcularGrau()`, `toString()`
- `consultes/ConsultesSala`: les 5 consultes
- `fitxers/GestorFitxers`: fitxer de text + serialitzat
- `dades/pacients_prova.txt`

**Persona B · `src/personaB/`**
- `llista/LlistaPacients`: afegir, buscar, assignarGrau, incrementarGrau, treureMesUrgent
- `llista/SalaPlenaException`
- `app/Main`: menú, teclat, try/catch

**Norma:** cadascú només toca la seva carpeta. Marqueu totes dues com a *source folder* a l'IDE.

**Dependències:** `app → consultes/fitxers → llista → model`. Només `Main` fa `Scanner` i `println`.

**Dates:** disseny fins al 27/11 · codi fins al 10/12 · proves fins al 14/12 · lliurament el 18/12 a les 17:00 · qüestionari el 21/12.
