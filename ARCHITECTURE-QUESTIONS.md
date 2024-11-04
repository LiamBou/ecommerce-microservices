# Projet Architecture orientée microservices
Liam BOUDADI et Chloé VARIN

## Architecture générale proposée
## Réponse aux questions 

### Découvrabilité (Eureka)
Avec Eureka, les services peuvent s'enregistrer et se découvrir mutuellement. Cela permet de simplifier la configuration 
des services et de faciliter la mise en place de l'architecture. Eureka permet de gérer les instances des services et de 
les mettre à jour en temps réel.
Par exemple avec la Gateway, on peut rediriger les requêtes vers les services enregistrés et disponibles sur Eureka. 
Cela permet de ne pas avoir à configurer manuellement les routes de la Gateway.

### L'équilibrage de la charge (Load Balancing Ribbon)
Pour permettre à chaque microservice de communiquer avec d’autres services sans être dépendant d'un équilibrage de charge 
centralisé, on peut utiliser une approche appelée équilibrage de charge côté client. L’objectif est d'intégrer l'intelligence 
de l'équilibrage de charge directement au sein de chaque microservice, afin qu'ils puissent décider eux-mêmes comment atteindre 
les autres services de manière efficace, sans dépendre d'un Load Balancer externe.
C'est possible avec Ribbon, intégré dans Spring Cloud Netflix qui va pouvoir interrair directement avec le registre de service 
pour algorithmes comme le round-robin ou le least connections pour distribuer les requêtes entre les instances.
Comme ça chaque microservice possède sa propre logique d'équilibrage et peut décider de la meilleure instance à utiliser en temps réel.

### API Gateway
Grâce à la mise en place d'une API Gateway, on peut centraliser l'accès aux différents services, depuis le client, il n'y aura 
qu'une seule adresse à contacter pour accéder à l'ensemble des services. La Gateway va recevoir la requête lié à un certain endpoint
et le transférer au service correspondant qu'il aura pu découvir grâce au registre Eureka.
L'API Gateway prend également en charge la gestion de l’authentification et de l’autorisation. Plutôt que d’obliger le client à 
s’authentifier séparément auprès de chaque microservice, le Gateway peut gérer une authentification unique (par exemple, 
avec OAuth2 ou JWT) et transmettre les informations d’identification aux services sous-jacents. 

### Le traçage des requêtes (sleuth & Zipkin)
Spring Cloud Sleuth est une bibliothèque de traçage distribuée pour les applications Spring Boot. Elle assigne automatiquement
un identifiant de trace (trace ID) et un identifiant de span (span ID) à chaque requête, permettant de suivre chaque requête de 
bout en bout. Zipkin est un système de collecte et de visualisation des données de traçage donc si on combine les deux services
ensemble, le traçage des requêtes devient un processus automatisé et visuel qui facilite le diagnostic des problèmes dans l'environnement.

## Informations supplémentaires sur la réalisation du projet

Dans notre implémentation, il manque certains services mentionnés dans l'architecture, comme le service d'authentification
Nous avons commencé à implémenter un serveur avec Keycloak mais cela n'a pas abouti à temps.
De ce fait plusieurs étapes du fonctionnement normal de l'application sont simulées (comme la connexion d'un utilisateur)

Nous avons également choisi de simuler le service de paiement via le front car autrement le service aurait été très vide,
simplement histoire de montrer que le service de paiement est bien appelé donc avec juste une requête pour delay la réponse.