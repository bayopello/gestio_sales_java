# Repartiment de la feina

## Persona A · model i dades · `src/personaA/`
- `urgencies.model`: `Pacient`, les 4 subclasses i `Especialitat`
- Càlcul del grau d'urgència
- `urgencies.consultes.ConsultesSala`: les 5 consultes
- `urgencies.fitxers.GestorFitxers`
- Fitxer de proves `dades/pacients_prova.txt`

## Persona B · llista i menú · `src/personaB/`
- `urgencies.llista.LlistaPacients` (afegir, buscar, assignar grau, incrementar, treure el més urgent)
- `urgencies.llista.SalaPlenaException`
- `urgencies.app.Main` (menú, teclat, excepcions d'entrada)

## Calendari
| Dates | Fase |
|---|---|
| 24–27/11 | Acordar el disseny (aquestes signatures) |
| 28/11–10/12 | Cadascú implementa la seva part |
| 11–14/12 | Integració i proves |
| 15–17/12 | Javadoc, informe i repàs |
| 18/12 17:00 | Lliurament |

## Punts a decidir
- Es limita el grau d'urgència a 5?
- El codi del pacient s'escriu a mà o es genera automàticament?

## Normes
- Cadascú només modifica fitxers de la seva carpeta (`src/personaA` o `src/personaB`).
- Busqueu `TODO Persona A` / `TODO Persona B` per veure què toca a cadascú.
- No canvieu cap signatura sense avisar l'altre.
- Feu `git pull` abans de començar i `git push` en acabar.
