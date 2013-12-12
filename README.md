TP CSA / OSGi
=======

Notre application est composée de 3 modules : 
  - DressingEngine (module principal)
  - Weather (module météo)
  - Location (module de localisation géographique)
  

Utilisation
-

Lancer le module principal (DressingEngine). Ce dernier affiche les données actuelles de chaque module.


Liens entre les modules
-

Les modules communiquent entre eux via des listeners. Un changement de position géographique lance ainsi une mise à jour de la météo, qui elle même lance une mise à jour des suggestions de vêtements.


Changement de postion
-

Pour tester ce mécanisme : 10 secondes après le lancement, nous simulons un changement de position (on passe de Toulouse à New York City).


