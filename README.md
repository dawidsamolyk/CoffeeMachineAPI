# CoffeeMachineAPI
<h1>Opis zadania</h1>

<p>"Firma opracowuje nowy model przelewowego ekspresu do kawy sterowanego komputerowo. API sterujące
poszczególnymi podzespołami dostarczone będzie przez zewnętrznych dostawców — nie należy uwzględniać API
w rozwiązaniu. Ekspres do kawy składa się z:
<ul><li>grzałki,</li>
<li>pojemnika na kubek,</li>
<li>zbiornika na wodę i kawę,</li>
<li>pompy do wody,</li>
<li>włącznika z diodą informującą o stanie systemu.</li></ul></p>
<p>Obecny model ekspresu obsługiwany jest przy pomocy interfejsu dotykowego. Użytkownik wybiera rodzaj
kawy, jaki chce przygotować, a następnie podaje ilość cukru i mleka, jaka ma być dodana. Po dokonaniu wyboru
ekspres:<br />
1. mieli kawę<br />
2. przesypuje kawę do głowicy<br />
3. jednocześnie włącza grzałkę i uruchamia pompę wody, która przewodem tłoczy wodę z pojemnika na wodę
do głowicy<br />
4. ekspres reguluje ciśnienie wody przepływającej przez głowicę tak, aby zachować optymalne ciśnienie wody
(zależne od rodzaju kawy) i jej właściwą temperaturę (która także jest inna dla każdego gatunku kawy)<br />
5. (opcjonalnie) do głowicy doprowadzane jest mleko w odpowiedniej temperaturze<br />
6. do podstawionego na podstawce kubka nalewana jest gotowa kawa. Pod kubkiem znajduje się ociekacz
zapobiegający zaplamiwniu stołu, jeśli kubek zostanie zabrany zbyt wcześnie.</p>

<p>Po zakończeniu procesu modelowania rezultatem powinno być czytelne, łatwo rozszerzalne API dla całej
rodziny ekspresów, od bardzo prostych modeli, aż po złożone. Zaproponowane rozwiązanie musi:
<ul><li>być niezależne od API producenta sprzętu (producentem sprzętu mogą być różni dostawcy),</li>
<li>umożliwić łatwe dodanie kolejnych modeli ekspresu, zarówno zawierajacych nowe funkcje, jak i pozbawionych niektórych funkcjonalności</li>
<li>preferować jakość kodu nad jego szybkość (obecne mikrokontrolery są wystarczająco szybkie do realizacji
dowolnego rozsądnego API)</li>"</p>
