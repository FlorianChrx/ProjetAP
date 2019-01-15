# RunQuests

Chiraux Florian, Madou Arnaud

## Présentation de RunQuests

Série de question données dans un ordre aléatoire

Différents modes de jeu:

Mode normal: On démarre avec 10 points de vie, le joueur saisit son nom, on perd 1 point de vie à chaque mauvaise réponse. Le score est calculé en fonction du temps de réponse, du nombre de tentatives pour cette question, la série de bonnes réponses consécutives, et le mode de jeu (voir mode difficile).

Mode difficile: On démarre avec 1 point de vie, le joueur saisit son nom, on perd 1 point de vie à chaque mauvaise réponse (soit une mort instantanée ici). Le score est calculé en fonction du temps de réponse, du nombre de tentatives pour cette question, la série de bonnes réponses consécutives, et le score est ici augmenté de façon beaucoup plus importante que le mode normal.

Mode Multijoueur: On choisit un nombre de joueurs, chaque joueur saisit son nom, tout le monde démarre avec 10 points de vie. A chaque tour un joueur répond, s’il a bon il désigne un autre joueur auquel il fait perdre un point de vie, et continue de répondre jusqu’à obtenir une série de 3 bonnes réponses auquel cas il gagne un point de vie et finit son tour. Dès la saisie d’une mauvaise réponse il cède son tour au joueur suivant.

A la fin d’une partie (de n’importe quel mode) on retourne au menu.
Sur le menu apparait le classement des meilleurs scores avec les noms des joueurs.

## Utilisation de RunQuests

Afin d'utiliser le projet, il doit être suffisant de taper les 
commandes suivantes:
./compile.sh            // lancer la compilation des fichiers
                        // présents dans 'src' et création des 
                        // fichiers '.class' dans 'classes'

Comme certains binômes ont un projet en mode texte et un autre 
en mode graphique, merci de préciser le nom des programmes à 
passer en paramètre au script 'run.sh'

./run.sh RunQuests     (mode texte)

Pour tous les projets: pensez à mettre l'ap.jar dans le répertoire 'lib' !

Pour les projets en mode graphiques, placez les images dans le répertoire
'ressources' sachant que son contenu est copié dans 'classes' lorsque 
vous faites un 'run'.

