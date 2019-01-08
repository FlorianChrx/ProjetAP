class Projet extends Program {
	final int maxquestion = 9;
	final char caracterevie = '█';
	final int vienormale = 10;
	void algorithm() {
		int choix = -1;
		int score = 0;
		Classement classement = new Classement();
		classement.joueur = creerJoueurs(5);
		initialiserJoueurs(classement.joueur, vienormale);
		do {
			int scoreN = 0;
			clearScreen();
			printline("Bienvenue dans le jeu !");
			passerLignes(3);
			printline("Meilleurs scores: ");
			afficherClassement(classement);
			printline("Que voulez-vous faire ?");
			passerLignes(2);
			printline("0. Quitter");
			printline("1. Jouer");
			printline("2. Jouer en difficile");
			printline("3. Jouer en multijoueurs");
			passerLignes(3);
			choix = demanderChoix();
			if (choix == 0) {
				print("Fin du programme, appuyez sur une touche...");
				readString();
			} else if (choix == 1) {
				actualiserClassement(jouer(vienormale, 1), classement);
			} else if (choix == 2) {
				actualiserClassement(jouer(1, 1), classement);
			} else if (choix == 3) {
				clearScreen();
				printline("Combien de joueurs ?");
				passerLignes(3);
				int nbjoueurs = demanderChoix();
				actualiserClassement(jouer(vienormale, nbjoueurs), classement);
			} else {
				clearScreen();
				printline("Votre choix est correct mais la fonctionnalité est indisponible...");
				readString();
			}
		} while(choix != 0);
	}
	void afficherClassement(Classement classement){
		printline("Premier  : "+ classement.joueur[0].nom + "  |  " + classement.joueur[0].score);
		printline("Deuxieme : "+ classement.joueur[1].nom + "  |  " + classement.joueur[1].score);
		printline("Troisieme: "+ classement.joueur[2].nom + "  |  " + classement.joueur[2].score);
		printline("Quatrieme: "+ classement.joueur[3].nom + "  |  " + classement.joueur[3].score);
		printline("Cinquieme: "+ classement.joueur[4].nom + "  |  " + classement.joueur[4].score);
	}
	void testGenererBarreVie() {
		assertEquals("|█████─────|     (5/10)", genererBarreVie(5,'█', 10));
		assertEquals("|#####─────|     (5/10)", genererBarreVie(5,'#', 10));
		assertEquals("|=====─────|     (5/10)", genererBarreVie(5,'=', 10));
		assertEquals("|██████████|     (10/10)", genererBarreVie(10,'█', 10));
		assertEquals("|──────────|     (0/10)", genererBarreVie(0,'█', 10));
		assertEquals("|─|     (0/1)", genererBarreVie(0,'█', 1));
		assertEquals("|█|     (1/1)", genererBarreVie(1,'█', 1));
		assertEquals("|█████|     (5/5)", genererBarreVie(5,'█', 5));
	}
	void printline (String chaine) {
		println("     " + chaine);
	}
	String genererBarreVie(int pv, char modele, int maxvie) {
		String resultat = "|";
		int nbcarres = pv;
		for (int i = 0; i < maxvie; i++) {
			if (nbcarres > 0) {
				resultat = resultat + modele;
				nbcarres = nbcarres - 1;
			} else {
				resultat = resultat + "─";
			}
		}
		resultat = resultat + "|     (" + pv + "/"+ maxvie +")";
		resultat = resultat;
		return resultat;
	}
	void afficherVie(int pv, int maxvie){
		printline("Votre vie : "+genererBarreVie(pv, caracterevie, maxvie));
	}
	void afficherPerdu(int vieactuelle) {
		printline("██████╗ ███████╗██████╗ ██████╗ ██╗   ██╗    ██╗");
		printline("██╔══██╗██╔════╝██╔══██╗██╔══██╗██║   ██║    ██║");
		printline("██████╔╝█████╗  ██████╔╝██║  ██║██║   ██║    ██║");
		printline("██╔═══╝ ██╔══╝  ██╔══██╗██║  ██║██║   ██║    ╚═╝");
		printline("██║     ███████╗██║  ██║██████╔╝╚██████╔╝    ██╗");
		printline("╚═╝     ╚══════╝╚═╝  ╚═╝╚═════╝  ╚═════╝     ╚═╝");
		if (vieactuelle == 0) {
			passerLignes(6);
			printline("██████╗ ██╗     ██╗   ██╗███████╗    ██████╗ ███████╗    ██╗   ██╗██╗███████╗");
			printline("██╔══██╗██║     ██║   ██║██╔════╝    ██╔══██╗██╔════╝    ██║   ██║██║██╔════╝");
			printline("██████╔╝██║     ██║   ██║███████╗    ██║  ██║█████╗      ██║   ██║██║█████╗  ");
			printline("██╔═══╝ ██║     ██║   ██║╚════██║    ██║  ██║██╔══╝      ╚██╗ ██╔╝██║██╔══╝  ");
			printline("██║     ███████╗╚██████╔╝███████║    ██████╔╝███████╗     ╚████╔╝ ██║███████╗");
			printline("╚═╝     ╚══════╝ ╚═════╝ ╚══════╝    ╚═════╝ ╚══════╝      ╚═══╝  ╚═╝╚══════╝");
		}
		readString();
	}
	void testAugmenterScore() {
		assertEquals(5, augmenterScore(2, 3));
		assertEquals(100, augmenterScore(10, 90));
		assertEquals(5, augmenterScore(0, 5));
		assertEquals(0, augmenterScore(0, 0));
		assertEquals(5, augmenterScore(5, 0));
		assertEquals(20, augmenterScore(10, 10));
	}
	int augmenterScore(int scoreactuel, int augmentation) {
		return scoreactuel + augmentation;
	}
	void testGagnerVie() {
		assertEquals(10, gagnerVie(10, 10, 10));
		assertEquals(10, gagnerVie(10, 0, 10));
		assertEquals(10, gagnerVie(5, 5, 10));
		assertEquals(10, gagnerVie(5, 5, 15));
		assertEquals(0, gagnerVie(0, 0, 0));
		assertEquals(7, gagnerVie(0, 7, 10));
	}
	int gagnerVie(int vieactuelle, int gain, int maxvie) {
		if (vieactuelle + gain < maxvie) {
			return vieactuelle + gain;
		} else {
			return maxvie;
		}
	}
	void testPerdreVie() {
		assertEquals(10, perdreVie(10, 0));
		assertEquals(0, perdreVie(10, 10));
		assertEquals(5, perdreVie(10, 5));
		assertEquals(0, perdreVie(10, 100));
		assertEquals(100, perdreVie(100, 0));
		assertEquals(50, perdreVie(100, 50));
	}
	int perdreVie(int vieactuelle, int perte) {
		if (vieactuelle - perte > 0) {
			return vieactuelle - perte;
		} else {
			return 0;
		}
	}
	String[] genererQuestion(int numeroquestion) {
		String[] laquestion = new String[2];
		String[] textQuestion = {
			"Combien font 1 + 1 ?\n1. 1\n2. 2\n3. 4\n4. 10 ",
			"Combien font 8 x 9 ?\n1. 64\n2. 73\n3. 72\n4. 89",
			"Quel célèbre dictateur dirigea l’URSS du milieu des années 1920 à 1953 ?\n1. Trotski\n2. Lénine\n3. Staline\n4. Molotov",
			"Dans quel pays peut-on trouver la Catalogne, l’Andalousie et la Castille ?\n1. L'Espagne\n2. L'Italie\n3. Le Portugal\n4. La France",
			"Qui a dit \"Le sort en est jeté\"?\n1. Hitler\n2. Napoléon\n3. Jules César\n4. Staline",
			"Quel pays a remporté la coupe du monde de football en 2014 ?\n1. L'Argentine\n2. L'Italie\n3. Le Brésil\n4. L'Allemagne",
			"Dans quelle ville italienne se situe l’action de la pièce de Shakespeare “Roméo et Juliette” ?\n1. Milan\n2. Vérone\n3. Rome\n4. Venise",
			"Par quel mot désigne-t-on une belle-mère cruelle ?\n1. Une jocrisse\n2. Une chenapan\n3. Une godiche\n4. Une marâtre",
			"En France, il y a :\n1. 5 régions\n2. 10 régions\n3. 22 régions\n4. 95 régions",
		};
		String[] reponse = {"2","3","3","1","3","4","2","4","3"};
		laquestion[0] = textQuestion[numeroquestion];
		laquestion[1] = reponse[numeroquestion];
		return laquestion;
	}
	void testEstBonneReponse() {
		assertTrue(estBonneReponse(1, new String[] {"Question aléatoire", "1"}));
		assertTrue(estBonneReponse(4, new String[] {"Question aléatoire", "4"}));
		assertFalse(estBonneReponse(6, new String[] {"Question aléatoire", "2"}));
		assertFalse(estBonneReponse(4, new String[] {"Question aléatoire", "3"}));
	}
	boolean estBonneReponse(int reponse, String[] question) {
		boolean resultat = false;
		if (reponse == stringToInt(question[1])) {
			resultat = true;
		}
		return resultat;
	}
	void passerLignes(int nblignes) {
		for (int i = nblignes ; i > 0; i--) {
			printline("");
		}
	}
	void afficherBravo(int serieactuelle) {
		printline("██████╗ ██████╗  █████╗ ██╗   ██╗ ██████╗     ██╗");
		printline("██╔══██╗██╔══██╗██╔══██╗██║   ██║██╔═══██╗    ██║");
		printline("██████╔╝██████╔╝███████║██║   ██║██║   ██║    ██║");
		printline("██╔══██╗██╔══██╗██╔══██║╚██╗ ██╔╝██║   ██║    ╚═╝");
		printline("██████╔╝██║  ██║██║  ██║ ╚████╔╝ ╚██████╔╝    ██╗");
		printline("╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝  ╚═══╝   ╚═════╝     ╚═╝");
		if (serieactuelle >= 3) {
			passerLignes(10);
			printline("Vous êtes dans une série de bonnes réponses, vous gagnez un point de vie !");
		}
		readString();
	}
	void afficherPerso(int vieactuelle){
		if (vieactuelle < 5) {
			printline("    ▄████▄▄");
			printline("   ▄▀█▀▐└─┐");
			printline("   █▄▐▌▄█▄┘");
			printline("   └▄▄▄▄─┘");
			printline("▄███▒██▒███▄");
			printline("▒▒█▄▒▒▒▒▄█▒▒");
			printline("  ▒▒▒▀▀▒▒▒");
			printline("▄███    ███▄");
		} else {
			printline("              ███████  ███████");
			printline("          ████▓▓▓▓▓▓████░░░░░██");
			printline("        ██▓▓▓▓▓▓▓▓▓▓▓▓██░░░░░░██");
			printline("      ██▓▓▓▓▓▓████████████░░░░██");
			printline("    ██▓▓▓▓▓▓████████████████░██");
			printline("    ██▓▓████░░░░░░░░░░░░██████");
			printline("  ████████░░░░░░██░░██░░██▓▓▓▓██");
			printline("  ██░░████░░░░░░██░░██░░██▓▓▓▓██");
			printline("██░░░░██████░░░░░░░░░░░░░░██▓▓██");
			printline("██░░░░░░██░░░░██░░░░░░░░░░██▓▓██");
			printline("  ██░░░░░░░░░███████░░░░██████");
			printline("    ████░░░░░░░███████████▓▓██");
			printline("      ██████░░░░░░░░░░██▓▓▓▓██");
			printline("    ██▓▓▓▓██████████████▓▓██");
			printline("  ██▓▓▓▓▓▓▓▓████░░░░░░████");
			printline("████▓▓▓▓▓▓▓▓██░░░░░░░░░░██");
			printline("████▓▓▓▓▓▓▓▓██░░░░░░░░░░██");
			printline("██████▓▓▓▓▓▓▓▓██░░░░░░████████");
			printline("  ██████▓▓▓▓▓▓████████████████");
			printline("    ██████████████████████▓▓▓▓██");
			printline("  ██▓▓▓▓████████████████▓▓▓▓▓▓██");
			printline("████▓▓██████████████████▓▓▓▓▓▓██");
			printline("██▓▓▓▓██████████████████▓▓▓▓▓▓██");
			printline("██▓▓▓▓██████████      ██▓▓▓▓████");
			printline("██▓▓▓▓████              ██████ ");
			printline("  ████");
		}
	}
	void afficherMechant() {
		printline("       ▄█          █         █▄       ");
		printline("     ▐██      ▄█  ███  █▄     ██▌     ");
		printline("    ▐██▀     █████████████    ▀██▌    ");
		printline("   ▐██▌     ██████████████     ▐██▌   ");
		printline("   ████    ████████████████    ████   ");
		printline("  ▐█████  ██████████████████  █████▌  ");
		printline("   ████████████████████████████████   ");
		printline("    ███████▀▀████████████▀▀███████    ");
		printline("     █████▌  ▄▄ ▀████▀ ▄▄  ▐█████     ");
		printline("   ▄▄██████▄ ▀▀  ████  ▀▀ ▄██████▄▄   ");
		printline("  ██████████████████████████████████  ");
		printline(" ████████████████████████████████████ ");
		printline("▐██████  ███████▀▄██▄▀███████  ██████▌");
		printline("▐█████    ██████████████████    █████▌");
		printline("▐█████     ██████▀  ▀██████     █████▌");
		printline(" █████▄     ███        ███     ▄█████ ");
		printline("  ██████     █          █     ██████  ");
		printline("    █████                    █████    ");
		printline("     █████                  █████     ");
		printline("      █████                █████      ");
		printline("       ████   ▄        ▄   ████       ");
		printline("        ████ ██        ██ ████        ");
		printline("        ████████ ▄██▄ ████████        ");
		printline("       ████████████████████████       ");
		printline("       ████████████████████████       ");
		printline("        ▀█████████▀▀█████████▀        ");
		printline("          ▀███▀        ▀███▀         ");
	}
	void testGenererRandom() {
		for (int i = 0; i < 1000; i++) {
			assertLessThan(maxquestion, genererRandom(1, maxquestion));
			assertGreaterThan(0, genererRandom(1, maxquestion));
		}
	}
	int genererRandom(int borne1, int borne2) {
		return (int) (random() * (borne2 - borne1)) + borne1;
	}
	int demanderChoix() {
		int resultat = 0;
		print("Votre choix (0 pour quitter):");
		String temp = readString();
		if ((length(temp) == 1) && (charAt(temp,0) >= '0' && charAt(temp,0) <= '9')){
			resultat = stringToInt(temp);
		} else {
			printline("Ceci n'est pas un choix valide !");
			resultat = demanderChoix();
		}
		return resultat;
	}
	int demanderChoix(int min, int max) {
		int resultat = 0;
		print("Votre choix (0 pour quitter):");
		String temp = readString();
		if ((length(temp) == 1) && (charAt(temp,0) >= toChar(max) && charAt(temp,0) <= toChar(max))){
			resultat = stringToInt(temp);
		} else {
			printline("Ceci n'est pas un choix valide !");
			resultat = demanderChoix();
		}
		return resultat;
	}
	char toChar(int nb) {
		return (char) nb;
	}
	void testDejaPosee() {
		assertTrue(dejaPosee(new boolean[] {true, true, true}, 2));		
		assertTrue(dejaPosee(new boolean[] {false, false, true}, 2));
		assertFalse(dejaPosee(new boolean[] {true, true, false}, 2));
		assertFalse(dejaPosee(new boolean[] {false, false, false}, 2));
	}
	boolean dejaPosee(boolean[] questionposees, int numeroquestion) {
		return questionposees[numeroquestion];
	}
	boolean[] tableauFullFalse(int taille){
		boolean[] resultat = new boolean[taille];
		for (int i = 0; i < taille; i++) {
			resultat[i] = false;
		}
		return resultat;
	} 
	void afficherScore(int score){
		printline("Votre score: "+score);
	}
	void testValeurReponse(){
		assertEquals(2000000, valeurReponse(1, 1, 1, 1));
		assertEquals(3000000, valeurReponse(1, 1, 2 , 1));
		assertEquals(11000000, valeurReponse(1, 1, 10, 1));
		assertEquals(1500000, valeurReponse(2, 1, 2 ,1));
	}
	int valeurReponse(long temps, int tentative, int serie, int viemax) {
		int resultat = 0;
		resultat = (int) ((1000000 * (serie + 1)) / temps);
		return (resultat/tentative)/viemax; 
	}
	void testIsFullTrue() {
		assertTrue(isFullTrue(new boolean[] {true, true, true, true, true, true, true}));
		assertFalse(isFullTrue(new boolean[] {true, true, false, true, true, true, true}));
		assertFalse(isFullTrue(new boolean[] {false, true, true, false, true, true, true}));
		assertFalse(isFullTrue(new boolean[] {false, false, false, false, false, false, false}));
	}
	boolean isFullTrue(boolean[] tableau){
		boolean resultat = true;
		int idx = 0;
		while (resultat && idx < length(tableau)) {
			if (!tableau[idx]) {
				resultat = false;
			}
			idx += 1;
		}
		return resultat;
	}
	void testCreerJoueurs() {
		int valeurtest = 2;
		Joueur[] joueurs = creerJoueurs(2);
		assertEquals(valeurtest, length(joueurs));
		for (int i = 0; i < length(joueurs); i++) {
			assertEquals(0, joueurs[i].score);
			assertEquals("Inconnu", joueurs[i].nom);
			assertEquals(0, joueurs[i].vie);
			assertEquals(0, joueurs[i].serie);
			assertEquals(1, joueurs[i].tentative);
		}
	}
	Joueur[] creerJoueurs(int nb) {
		Joueur[] joueurs = new Joueur[nb];
		for (int i = 0; i < length(joueurs); i++) {
			joueurs[i] = new Joueur();
		}
		return joueurs;
	}
	void testInitialiserJoueurs() {
		Joueur[] joueurs = creerJoueurs(10);
		initialiserJoueurs(joueurs, 10);
		for (int i = 0; i < length(joueurs); i++) {
			assertEquals(0, joueurs[i].score);
			assertEquals("Inconnu", joueurs[i].nom);
			assertEquals(10, joueurs[i].vie);
			assertEquals(0, joueurs[i].serie);
			assertEquals(1, joueurs[i].tentative);
		}
	}
	void initialiserJoueurs(Joueur[] tab, int maxvie){
		for (int i = 0; i < length(tab); i++) {
			tab[i].vie = maxvie;
		}
	}
	void donnerNoms(Joueur[] tab) {
		for (int i = 0; i < length(tab); i++) {
			clearScreen();
			printline("Nom du joueur "+(i+1)+": ");
			tab[i].nom = saisirNomValide();
		}
	}
	String saisirNomValide() {
		String nom = readString();
		if (length(nom) > 12) {
			printline("Ce nom n'est pas valide, il est trop long ! ");
			print("Votre nom : ");
			saisirNomValide();
		}
		return nom;
	}
	void testActualiserClassement() {
		for(int i =0;i<10;i++){
			Joueur player1 = new Joueur();
			player1.score = genereRandom(5000,10000);
			Joueur player2 = new Joueur();
			player2.score = genererRandom(0,3000);
			Classement rank = new Classement();
			Joueur[] party = {player1,player2};
			actualiserClassement(party, rank);
			assertequals(player1.score, rank.joueur[0]);
			assertequals(player2.score, rank.joueur[1]);
		}
	}
	void actualiserClassement(Joueur[] tab, Classement classement){
		for (int i = 0; i < length(tab) ; i++) {
			int j = 0;
			boolean dejatrouvee = false;
			while (j < length(classement.joueur) && !dejatrouvee) {
				if (tab[i].score > classement.joueur[j].score) {
					decaler(classement.joueur, j);
					classement.joueur[j] = tab[i];
					dejatrouvee = true;
				}
				j += 1;
			}
		}
	}
	Joueur[] decaler(Joueur[] tab, int debut){
		for (int idx = (length(tab)-1); idx > debut; idx--) {
			tab[idx] = tab[idx-1];
		}
		return tab;
	}
	boolean allDeads(Joueur[] tab){
		for(int i = 0; i < length(tab); i++){
			if (tab[i].vie > 0) {
				return false;
			}
		}
		return true;
	}
	Joueur[] jouer(int viemax, int nbjoueurs) {
		int tour = 0;
		Joueur[] joueurs = creerJoueurs(nbjoueurs);
		initialiserJoueurs(joueurs, viemax);
		donnerNoms(joueurs);
		int numeroquestion = genererRandom(0, maxquestion);
		String[] question = new String[2];
		question = genererQuestion(numeroquestion);
		boolean[] questionposees = tableauFullFalse(maxquestion);
		boolean quitter = false;
		while (!quitter && !allDeads(joueurs)) {
			if (length(joueurs) > 1 && joueurs[tour % nbjoueurs].vie <= 0) {
				tour++;
			} else {
				if (nbjoueurs > 1) {
					clearScreen();
					printline("C'est au tour de "+ joueurs[tour % nbjoueurs].nom +" préparez-vous ! (Entrée quand vous êtes prêt !)");
					readString();
				}
				question = genererQuestion(numeroquestion);
				clearScreen();
				afficherPerso(joueurs[tour % nbjoueurs].vie);
				passerLignes(5);
				printline("C'est au joueur "+((tour % nbjoueurs) + 1));
				afficherScore(joueurs[tour % nbjoueurs].score);
				afficherVie(joueurs[tour % nbjoueurs].vie, viemax);
				passerLignes(1);
				printline(question[0]);
				passerLignes(3);
				long debut = getTime();
				int reponse = demanderChoix();
				long fin = getTime();
				if (reponse != 0) {
					if (estBonneReponse(reponse, question)) {
						clearScreen();
						questionposees[numeroquestion] = true;
						afficherBravo(joueurs[tour % nbjoueurs].serie);
						attaquer(joueurs, nbjoueurs);
						actualiserJoueurReussite(joueurs, nbjoueurs, tour, debut, fin, viemax);
						if (!isFullTrue(questionposees)){
							while (dejaPosee(questionposees, numeroquestion)) {
								numeroquestion = genererRandom(0, maxquestion);
							}
						} else {
							quitter = true;
						}
						tour += 1;
					} else {
						clearScreen();
						afficherMechant();
						passerLignes(5);
						afficherPerdu(joueurs[tour % nbjoueurs].vie);
						actualiserJoueurEchec(joueurs, nbjoueurs, tour);
						if (nbjoueurs > 1) {
							if (!isFullTrue(questionposees)){
								while (dejaPosee(questionposees, numeroquestion)) {
									numeroquestion = genererRandom(0, maxquestion);
								}
							} else {
								quitter = true;
							}
						}
						if (length(joueurs) == 1 && joueurs[0].vie <= 0){
							quitter = true;
						} else {
							tour+=1;
						}
					}
				} else {
					quitter = true;
				}
			}
		}
		return joueurs;
	}
	void actualiserJoueurEchec(Joueur[] joueurs, int nbjoueurs, int tour){
		joueurs[tour % nbjoueurs].vie = perdreVie(joueurs[tour % nbjoueurs].vie, 1);
		joueurs[tour % nbjoueurs].tentative += 1;
		joueurs[tour % nbjoueurs].serie = 0;
	}
	String listeJoueurs(Joueur[] joueurs){
		String resultat = "";
		for (int i = 0; i < length(joueurs); i++) {
			resultat += (i+1) + " : " + joueurs[i].nom +"\n";
		}
		return resultat;
	}
	void attaquer(Joueur[] joueurs, int nbjoueurs) {
		if (nbjoueurs > 1){
			passerLignes(5);
			println(listeJoueurs(joueurs));
			passerLignes(5);
			printline("Qui attaquez-vous ? (numero joueur)");
			int numerojoueur = demanderChoix() - 1;
			if (numerojoueur < length(joueurs)){
					joueurs[numerojoueur].vie = perdreVie(joueurs[numerojoueur].vie, 1);
			}
		}
	}
	void actualiserJoueurReussite(Joueur[] joueurs, int nbjoueurs, int tour, long debut, long fin , int viemax){
		joueurs[tour % nbjoueurs].score = augmenterScore(joueurs[tour % nbjoueurs].score, valeurReponse(fin-debut, joueurs[tour % nbjoueurs].tentative, joueurs[tour % nbjoueurs].serie, viemax));
		joueurs[tour % nbjoueurs].serie += 1;
		joueurs[tour % nbjoueurs].tentative = 1;
	}
}
