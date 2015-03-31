# CoffeeMachineAPI
<h1>Opis zadania</h1>

"Firma opracowuje nowy model przelewowego ekspresu do kawy sterowanego komputerowo. API sterujące
poszczególnymi podzespołami dostarczone będzie przez zewnętrznych dostawców — nie należy uwzględniać API
w rozwiązaniu. Ekspres do kawy składa się z:
 grzałki,
 pojemnika na kubek,
 zbiornika na wodę i kawę,
 pompy do wody
 włącznika z diodą informującą o stanie systemu.
Obecny model ekspresu obsługiwany jest przy pomocy interfejsu dotykowego. Użytkownik wybiera rodzaj
kawy, jaki chce przygotować, a następnie podaje ilość cukru i mleka, jaka ma być dodana. Po dokonaniu wyboru
ekspres:
1. mieli kawę
2. przesypuje kawę do głowicy
3. jednocześnie włącza grzałkę i uruchamia pompę wody, która przewodem tłoczy wodę z pojemnika na wodę
do głowicy
4. ekspres reguluje ciśnienie wody przepływającej przez głowicę tak, aby zachować optymalne ciśnienie wody
(zależne od rodzaju kawy) i jej właściwą temperaturę (która także jest inna dla każdego gatunku kawy)
5. (opcjonalnie) do głowicy doprowadzane jest mleko w odpowiedniej temperaturze
6. do podstawionego na podstawce kubka nalewana jest gotowa kawa. Pod kubkiem znajduje się ociekacz
zapobiegający zaplamiwniu stołu, jeśli kubek zostanie zabrany zbyt wcześnie.
Po zakończeniu procesu modelowania rezultatem powinno być czytelne, łatwo rozszerzalne API dla całej
rodziny ekspresów, od bardzo prostych modeli, aż po złożone. Zaproponowane rozwiązanie musi:
 być niezależne od API producenta sprzętu (producentem sprzętu mogą być różni dostawcy),
 umożliwić łatwe dodanie kolejnych modeli ekspresu, zarówno zawierajacych nowe funkcje, jak i pozbawionych niektórych funkcjonalności
 preferować jakość kodu nad jego szybkość (obecne mikrokontrolery są wystarczająco szybkie do realizacji
dowolnego rozsądnego API)"
