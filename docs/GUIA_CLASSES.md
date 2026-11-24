# Guia de classes, packages i dependències

Pràctica 3 de Programació: gestió de la sala d'espera d'urgències.

Aquest document explica què fa cada package i cada classe, de quines altres
classes depèn i què ha de fer cada persona.

---

## 1. Visió general

Cada persona té la seva carpeta de codi i **només toca fitxers de la seva
carpeta**. Els packages es diuen igual (`urgencies.model`, etc.); només canvia
la carpeta on són.

```
src/
├── personaA/urgencies/
│   ├── model       Dades dels pacients
│   ├── consultes   Les 5 consultes
│   └── fitxers     Lectura/escriptura de fitxers
└── personaB/urgencies/
    ├── llista      La llista pròpia + excepció
    └── app         Programa principal amb el menú
```

### Configurar l'IDE (dues carpetes de codi)

`src/personaA` i `src/personaB` són **dues carpetes arrel de codi**
(*source folders*). Cal marcar-les totes dues:

- **Eclipse:** clic dret a cada carpeta → *Build Path → Use as Source Folder*.
- **IntelliJ:** clic dret → *Mark Directory as → Sources Root*.
- **VS Code:** a `.vscode/settings.json`:
  `"java.project.sourcePaths": ["src/personaA", "src/personaB"]`.
- **Terminal:** `javac -encoding UTF-8 -d bin $(find src -name "*.java")` i
  `java -cp bin urgencies.app.Main`.

### Dependències entre packages

Una fletxa `X → Y` vol dir "X fa servir (importa) Y".

```
app ──► consultes ──► llista ──► model
app ──► fitxers ────► llista
app ──► llista
```

| Package     | Carpeta  | Depèn de                     | No ha de dependre mai de |
|-------------|----------|------------------------------|--------------------------|
| `model`     | personaA | res (només Java)             | cap altre package        |
| `llista`    | personaB | `model`                      | `consultes`, `fitxers`, `app` |
| `consultes` | personaA | `model`, `llista`            | `fitxers`, `app`         |
| `fitxers`   | personaA | `model`, `llista`            | `consultes`, `app`       |
| `app`       | personaB | tots                         | —                        |

Regla clau: **només `app` llegeix del teclat i escriu per pantalla**
(`Scanner`, `System.out`). Les altres classes retornen dades
(`int`, `double`, `Pacient`...) i llancen excepcions; mai fan `println`.

---

## 2. Package `urgencies.model` · Persona A

Conté la jerarquia de pacients. És la base de tot: **s'ha de fer primer**,
perquè la resta de classes la necessiten.

```
              Pacient (abstracta, Serializable)
     ┌──────────┬────────┴──────┬──────────────┐
Ginecologia  Traumatologia  Cardiologia      Altres
```

### `Especialitat` (enum)

Valors: `CARDIOLOGIA`, `TRAUMATOLOGIA`, `GINECOLOGIA`, `ALTRES`.

- **Per a què serveix:** identificar el tipus de pacient a les consultes i al
  fitxer de text, sense comparar Strings.
- **Dependències:** cap.

### `Pacient` (classe abstracta)

| Atribut | Tipus | Significat |
|---|---|---|
| `codi` | `String` | Codi que li donen al mostrador |
| `nom` | `String` | Nom |
| `edat` | `int` | Edat en anys |
| `alergia` | `boolean` | Té al·lèrgia a algun medicament |
| `grauUrgencia` | `double` | 0 fins al cribratge |
| `cribrat` | `boolean` | Ja té el grau assignat |

Són `protected` perquè les subclasses hi puguin accedir.

| Mètode | Què fa | Estat |
|---|---|---|
| constructor, getters | — | Fet |
| `calcularGrauBase()` | `edat / 20.0` (compte: `20.0`, no `20`, o farà divisió entera) | TODO |
| `abstract calcularGrau()` | Cada subclasse hi suma els seus punts | TODO a cada subclasse |
| `abstract getEspecialitat()` | Retorna el valor de l'enum | Fet |
| `assignarGrau()` | `grauUrgencia = calcularGrau(); cribrat = true;` | TODO |
| `incrementarGrau(double)` | Suma punts al grau | TODO |
| `toString()` | Dades comunes en text | TODO (ajustar) |

- **Dependències Java:** `java.io.Serializable` (necessari per al fitxer
  serialitzat). Totes les subclasses l'hereten.

### Les subclasses

| Classe | Atributs propis | `calcularGrau()` |
|---|---|---|
| `Ginecologia` | `boolean primerFill`, `boolean diabetisGestacional` | base + 0.3 si primer fill + 0.5 si diabetis |
| `Traumatologia` | `String zonaLesio` | només base |
| `Cardiologia` | `int minutsSimptomes` | base + 0.1 × (`minutsSimptomes / 5`) amb divisió entera |
| `Altres` | `String descripcio` | només base |

Cada subclasse:
- crida `super(codi, nom, edat, alergia)` al constructor;
- redefineix `toString()` cridant `super.toString()` i afegint les seves dades.

**Exemples per comprovar el càlcul (de l'enunciat):**
- Ginecologia, 30 anys, segon fill, amb diabetis → 1.5 + 0.5 = **2.0**
- Traumatologia, 66 anys → **3.3**
- Cardiologia, 50 anys, 22 minuts → 2.5 + 0.4 = **2.9**

---

## 3. Package `urgencies.llista` · Persona B

### `SalaPlenaException` · Persona B

- Hereta de `Exception` (excepció *checked*: qui crida `afegir` està obligat a
  tractar-la).
- Té un constructor `SalaPlenaException(String missatge)`.
- **Dependències:** cap.

### `LlistaPacients`

| Atribut | Tipus | Significat |
|---|---|---|
| `CAPACITAT` | `public static final int` = 30 | Capacitat de la sala |
| `llista` | `Pacient[]` | Array de mida 30 |
| `nElem` | `int` | Quants pacients hi ha (ocupen les posicions 0..nElem-1) |

**Mètodes:**

| Mètode | Què fa | Pista |
|---|---|---|
| `getNElem()` | Nombre de pacients | Fet |
| `getPacient(int i)` | Pacient de la posició i | Per mostrar-los des del `Main` |
| `esPlena()` | `nElem == CAPACITAT` | |
| `afegir(Pacient p)` | Afegeix al final | Si és plena: `throw new SalaPlenaException(...)` |
| `buscar(String codi)` | Cerca per codi | Cerca amb `while`, compara amb `equals`; retorna `null` si no hi és |
| `assignarGrau(String codi)` | Cribratge d'un pacient | Fa servir `buscar` i després `p.assignarGrau()` |
| `incrementarGrau(double)` | Suma punts a tots els cribrats | Recorregut amb `for` |
| `treureMesUrgent()` | Treu el cribrat amb més grau | 1) buscar la posició del màxim, 2) desplaçar els següents una posició enrere, 3) `nElem--` |

- **Dependències:** `urgencies.model.Pacient`, `java.io.Serializable`.
- **Prohibit:** `ArrayList`, `List` o qualsevol col·lecció de Java.

---

## 4. Package `urgencies.consultes` · Persona A

### `ConsultesSala`

Mètodes `static` que reben la sala per paràmetre i la recorren amb
`sala.getNElem()` i `sala.getPacient(i)`. Retornen números, mai text.

| Mètode | Què fa | Pista |
|---|---|---|
| `comptarEspecialitat(sala, Especialitat e)` | Quants n'hi ha d'una especialitat | `p.getEspecialitat() == e` |
| `grauMaximEspecialitat(sala, Especialitat e)` | Grau més alt d'una especialitat | Retorna -1 si no n'hi ha cap |
| `comptarAlergics(sala)` | Quants tenen al·lèrgies | `p.teAlergia()` |
| `comptarDiabetisGestacional(sala)` | Dones amb diabetis | `instanceof Ginecologia` + càsting |
| `comptarCardiologiaMesDe(sala, int minuts)` | Cardiologia amb > x minuts | `instanceof Cardiologia` + càsting |

- **Dependències:** `urgencies.model.*`, `urgencies.llista.LlistaPacients`.

---

## 5. Package `urgencies.fitxers` · Persona A

### `GestorFitxers`

Tots els mètodes són `static` (no cal crear cap objecte `GestorFitxers`).
**No han de capturar les excepcions**: les llancen (`throws`) i el `Main`
mostra el missatge.

| Mètode | Què fa | Classes de Java |
|---|---|---|
| `carregarText(LlistaPacients, String)` | Llegeix línies, fa `split(";")`, crea el pacient segons el primer camp i l'afegeix | `BufferedReader`, `FileReader`, `Integer.parseInt`, `Boolean.parseBoolean`, `Especialitat.valueOf` |
| `guardarPacientText(Pacient, String)` | Afegeix el pacient al final del fitxer | `PrintWriter`, `FileWriter(nom, true)` (el `true` és per afegir) |
| `guardarSerialitzat(LlistaPacients, String)` | Escriu la llista sencera | `ObjectOutputStream`, `FileOutputStream` |
| `carregarSerialitzat(String)` | Llegeix la llista sencera | `ObjectInputStream`, `FileInputStream`, càsting a `LlistaPacients` |

**Format del fitxer de text** (`dades/pacients_prova.txt`):

```
CARDIOLOGIA;codi;nom;edat;alergia;minuts
TRAUMATOLOGIA;codi;nom;edat;alergia;zona
GINECOLOGIA;codi;nom;edat;alergia;primerFill;diabetis
ALTRES;codi;nom;edat;alergia;descripcio
```

- **Dependències:** `urgencies.model.*`, `urgencies.llista.*`, `java.io.*`.
- **Excepcions que poden sortir:** `FileNotFoundException`, `IOException`,
  `NumberFormatException` (edat o minuts mal escrits),
  `IllegalArgumentException` (especialitat que no existeix),
  `ArrayIndexOutOfBoundsException` (línia amb camps que falten),
  `ClassNotFoundException`, `SalaPlenaException`.
  Decidiu junts si una línia incorrecta atura la càrrega o si se salta.

---

## 6. Package `urgencies.app` · Persona B

### `Main`

Només entrada/sortida amb l'usuari. **Cap càlcul aquí.**

| Opció | Crida a | Excepcions a capturar |
|---|---|---|
| 1. Afegir pacient | Llegir dades → `new Cardiologia(...)` etc. → `sala.afegir(p)` | `SalaPlenaException` |
| 2. Cribratge | `sala.assignarGrau(codi)` | — (mirar si retorna `false`) |
| 3. Incrementar grau | `sala.incrementarGrau(x)` | — |
| 4. Treure el més urgent | `sala.treureMesUrgent()` → mostrar → `GestorFitxers.guardarPacientText(...)` | `IOException` |
| 5. Guardar serialitzat | `GestorFitxers.guardarSerialitzat(...)` | `IOException` |
| 6. Carregar serialitzat | `sala = GestorFitxers.carregarSerialitzat(...)` | `IOException`, `ClassNotFoundException` |
| 7. Carregar de text | `GestorFitxers.carregarText(...)` | `IOException`, `SalaPlenaException`, `NumberFormatException` |
| 8. Mostrar tots | `for` amb `sala.getPacient(i)` i `println` | — |
| 9. Consultes | Submenú → `ConsultesSala.comptarAlergics(sala)` etc. | — |
| 0. Sortir | — | — |

Mètodes auxiliars recomanats: `llegirEnter`, `llegirDouble`, `llegirBoolean`
(s/n) i `llegirEspecialitat`. Han de tornar a preguntar si l'usuari escriu
malament (`NumberFormatException`).

- **Dependències:** tots els altres packages, `java.util.Scanner`, `java.io.IOException`.

---

## 7. Resum per persona

### Persona A · model i dades · carpeta `src/personaA/`

| Fitxer | Què hi ha de fer |
|---|---|
| `model/Pacient.java` | `calcularGrauBase`, `assignarGrau`, `incrementarGrau`, `toString` |
| `model/Ginecologia.java`, `Traumatologia.java`, `Cardiologia.java`, `Altres.java` | `calcularGrau`, `toString` |
| `consultes/ConsultesSala.java` | Les 5 consultes |
| `fitxers/GestorFitxers.java` | Els 4 mètodes |
| `dades/pacients_prova.txt` | Ampliar fins a uns 30–35 pacients (per provar la sala plena) |

**Necessita de la Persona B:** que `getNElem` i `getPacient` funcionin (per
a les consultes) i `afegir` (per a `carregarText`).

**Ordre recomanat:** model → consultes → fitxer de text → serialitzat.

### Persona B · llista i menú · carpeta `src/personaB/`

| Fitxer | Què hi ha de fer |
|---|---|
| `llista/SalaPlenaException.java` | Ja està feta; revisar-la |
| `llista/LlistaPacients.java` | Tots els mètodes |
| `app/Main.java` | Les 10 opcions del menú i la lectura per teclat |

**Necessita de la Persona A:** les subclasses amb `calcularGrau()` fet (per
provar el cribratge i `treureMesUrgent`) i `GestorFitxers` (opcions 4–7).
Mentrestant pot provar amb pacients creats a mà al `main`.

**Ordre recomanat:** `afegir` / `getPacient` → menú opcions 1 i 8 →
`buscar` / `assignarGrau` → `treureMesUrgent` → resta del menú.

---

## 8. Què ha de saber tothom per al qüestionari

El qüestionari és individual, així que cadascú ha d'entendre també la part de l'altre:

- Herència, classes abstractes i redefinició de mètodes (`calcularGrau`).
- `instanceof` i càsting (consultes de ginecologia i cardiologia).
- Recórrer, buscar, inserir i eliminar en una llista feta amb un array.
- Diferència entre llançar (`throw` / `throws`) i capturar (`try` / `catch`).
- Fitxers de text i fitxers serialitzats (`Serializable`).
