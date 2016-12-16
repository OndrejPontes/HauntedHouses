# HauntedHouses
PA165 project

# Instalation\Run
```bash
mvn clean install
cd rest && mvn tomcat7:run
http://localhost:8080/pa165
```
# Rest examples
example of getAll() methods using GET 
```
curl -u admin:admin -i -X GET localhost:8080/pa165/ghosts/ | json
curl -u admin:admin -i -X GET localhost:8080/pa165/abilities/ | json
curl -u admin:admin -i -X GET localhost:8080/pa165/houses/ | json
curl -u admin:admin -i -X GET localhost:8080/pa165/hauntings/ | json
```
create ability POST
```
curl -u admin:admin  -H "Content-Type: application/json" -X POST -d '{ "name" : "ddasdsadasasdasddaasddas", "description" : "dasdasd"}' localhost:8080/pa165/abilities | json
```
update ability PUT
```
curl -u admin:admin  -H "Content-Type: application/json" -X PUT -d '{"id":"11", "name" : "newNameOFAbility", "description" : "Desc of updated ability"}' localhost:8080/pa165/abilities | json
```
delete ability DELETE
```
curl -u admin:admin  -H "Content-Type: application/json" -X DELETE -d '{"id":"11", "name" : "newNameOFAbility", "description" : "Desc of updated ability"}' localhost:8080/pa165/abilities | json
```

# Description
Existuje nekolik domu v kterych strasi podivna strasidla. Kazde strasidlo ma sve schopnosti a muze je mit i vic 
strasidel. Kazde strasidlo muze strasit pouze v jednom dome. Dum je definovan nazvem, adresou (neni entita), datum 
kdy zaclo v dome strasit a strucnou historii. Strasidlo ma svoje hruzostrasne jmeno, dobu od kdy do kdy strasi (pouze 
jeden interval) po zbytek dne odpociva) a popis jak se projevuje, proc strasi atd. Schopnost ma sve jmeno, popis apod. 
Inspirovat se muzete na http://www.ghostmaster.net/
