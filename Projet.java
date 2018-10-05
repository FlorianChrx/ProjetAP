class Projet extends Program {
	boolean quitter = false;
	boolean demo = false;
	int maxquestion = 9;
	int vie = 10;
	int serie = 0;
	void algorithm() {
		while (quitter == false) {
			if (demo == false) {
				demo = afficherDemo("");
			} else {
				afficherMenu();
			}
		}
	}
	void testAfficherVie() {
		assertEquals("|█████─────|     (5/10)", afficherVie(5,'█', 10));
		assertEquals("|#####─────|     (5/10)", afficherVie(5,'#', 10));
		assertEquals("|=====─────|     (5/10)", afficherVie(5,'=', 10));
		assertEquals("|██████████|     (10/10)", afficherVie(10,'█', 10));
		assertEquals("|──────────|     (0/10)", afficherVie(0,'█', 10));
		assertEquals("|─|     (0/1)", afficherVie(0,'█', 1));
		assertEquals("|█|     (1/1)", afficherVie(1,'█', 1));
		assertEquals("|█████|     (5/5)", afficherVie(5,'█', 5));
	}
	String afficherVie(int pv, char modele, int maxvie) {
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
	String afficherPerdu() {
		println("██████╗ ███████╗██████╗ ██████╗ ██╗   ██╗    ██╗");
		println("██╔══██╗██╔════╝██╔══██╗██╔══██╗██║   ██║    ██║");
		println("██████╔╝█████╗  ██████╔╝██║  ██║██║   ██║    ██║");
		println("██╔═══╝ ██╔══╝  ██╔══██╗██║  ██║██║   ██║    ╚═╝");
		println("██║     ███████╗██║  ██║██████╔╝╚██████╔╝    ██╗");
		println("╚═╝     ╚══════╝╚═╝  ╚═╝╚═════╝  ╚═════╝     ╚═╝");
		passerLignes(6);
		if (vie == 0) {
			println("██████╗ ██╗     ██╗   ██╗███████╗    ██████╗ ███████╗    ██╗   ██╗██╗███████╗");
			println("██╔══██╗██║     ██║   ██║██╔════╝    ██╔══██╗██╔════╝    ██║   ██║██║██╔════╝");
			println("██████╔╝██║     ██║   ██║███████╗    ██║  ██║█████╗      ██║   ██║██║█████╗  ");
			println("██╔═══╝ ██║     ██║   ██║╚════██║    ██║  ██║██╔══╝      ╚██╗ ██╔╝██║██╔══╝  ");
			println("██║     ███████╗╚██████╔╝███████║    ██████╔╝███████╗     ╚████╔╝ ██║███████╗");
			println("╚═╝     ╚══════╝ ╚═════╝ ╚══════╝    ╚═════╝ ╚══════╝      ╚═══╝  ╚═╝╚══════╝");
		}
		return "perdu";
	}
	void afficherMenu() {
		boolean dejajoue = false;
		int score = 0;
		while (quitter == false) {
			clearScreen();
			println("                     ██ ██ ██ ██    ██ ██ ██    ");
			println("               ██ ██ ▓▓ ▓▓ ▓▓ ██ ██ ░░ ░░ ░░ ██ ");
			println("            ██ ▓▓ ▓▓ ▓▓ ▓▓ ▓▓ ▓▓ ██ ░░ ░░ ░░ ██ ");
			println("         ██ ▓▓ ▓▓ ▓▓ ██ ██ ██ ██ ██ ██ ░░ ░░ ██ ");
			println("      ██ ▓▓ ▓▓ ▓▓ ██ ██ ██ ██ ██ ██ ██ ██ ░░ ██ ");
			println("      ██ ▓▓ ██ ██ ░░ ░░ ░░ ░░ ░░ ░░ ██ ██ ██    ");
			println("   ██ ██ ██ ██ ░░ ░░ ░░ ██ ░░ ██ ░░ ██ ▓▓ ▓▓ ██ ");
			println("   ██ ░░ ██ ██ ░░ ░░ ░░ ██ ░░ ██ ░░ ██ ▓▓ ▓▓ ██ ");
			println("██ ░░ ░░ ██ ██ ██ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ██ ▓▓ ██ ");
			println("██ ░░ ░░ ░░ ██ ░░ ░░ ██ ░░ ░░ ░░ ░░ ░░ ██ ▓▓ ██ ");
			println("   ██ ░░ ░░ ░░ ░░ ██ ██ ██ ██ ░░ ░░ ██ ██ ██    ");
			println("      ██ ██ ░░ ░░ ░░ ░░ ██ ██ ██ ██ ██ ▓▓ ██    ");
			println("         ██ ██ ██ ░░ ░░ ░░ ░░ ░░ ██ ▓▓ ▓▓ ██    ");
			println("   ░░ ██ ▓▓ ▓▓ ██ ██ ██ ██ ██ ██ ██ ▓▓ ██       ");
			println("   ██ ▓▓ ▓▓ ▓▓ ▓▓ ██ ██ ░░ ░░ ░░ ██ ██          ");
			println("██ ██ ▓▓ ▓▓ ▓▓ ▓▓ ██ ░░ ░░ ░░ ░░ ░░ ██          ");
			println("██ ██ ▓▓ ▓▓ ▓▓ ▓▓ ██ ░░ ░░ ░░ ░░ ░░ ██          ");
			println("██ ██ ██ ▓▓ ▓▓ ▓▓ ▓▓ ██ ░░ ░░ ░░ ██ ██ ██ ██    ");
			println("   ██ ██ ██ ▓▓ ▓▓ ▓▓ ██ ██ ██ ██ ██ ██ ██ ██    ");
			println("      ██ ██ ██ ██ ██ ██ ██ ██ ██ ██ ██ ▓▓ ▓▓ ██ ");
			println("   ██ ▓▓ ▓▓ ██ ██ ██ ██ ██ ██ ██ ██ ▓▓ ▓▓ ▓▓ ██ ");
			println("██ ██ ▓▓ ██ ██ ██ ██ ██ ██ ██ ██ ██ ▓▓ ▓▓ ▓▓ ██ ");
			println("██ ▓▓ ▓▓ ██ ██ ██ ██ ██ ██ ██ ██ ██ ▓▓ ▓▓ ▓▓ ██ ");
			println("██ ▓▓ ▓▓ ██ ██ ██ ██ ██          ██ ▓▓ ▓▓ ██ ██ ");
			println("██ ▓▓ ▓▓ ██ ██                      ██ ██ ██    ");
			println("   ██ ██                                        ");
			passerLignes(5);
			println("███╗   ███╗██╗   ██╗     ██████╗  █████╗ ███╗   ███╗███████╗");
			println("████╗ ████║╚██╗ ██╔╝    ██╔════╝ ██╔══██╗████╗ ████║██╔════╝");
			println("██╔████╔██║ ╚████╔╝     ██║  ███╗███████║██╔████╔██║█████╗  ");
			println("██║╚██╔╝██║  ╚██╔╝      ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  ");
			println("██║ ╚═╝ ██║   ██║       ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗");
			println("╚═╝     ╚═╝   ╚═╝        ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝");
			passerLignes(5);
			if (dejajoue == true) {
				println("Votre dernier score: " + score);
			}
			println("Que voulez-vous faire ?");
			println("1. Jouer");
			println("2. Jouer Hardcore");
			println("3. Quitter");
			String choix = action("menu", readString());
			if (equals(choix, "quitter")) {
				quitter = true;
			}
			if (equals(choix, "jouer")) {
				score = jouer(10);
				dejajoue = true;
			}
			if (equals(choix, "jouerhard")) {
				score = jouer(1);
				dejajoue = true;
			}
		}
	}
	void testAction() {
		assertEquals("jouer", action("menu", "1"));
		assertEquals("quitter", action("menu", "3"));
		assertEquals("continuer", action("demo", "1"));
		assertEquals("continuer", action("perdu", ""));
		assertEquals("erreur", action("", "0"));
		assertEquals("erreur", action("", "1000"));
	}
	String action(String source,String choix) {
		if (equals(source, "menu")) {
			if (equals(choix, "1")) {
				return "jouer";
			} else if (equals(choix, "2")) {
				return "jouerhard";
			} else if (equals(choix, "3")) {
				return "quitter";
			}
		} else if (equals(source, "demo") && equals(choix,"1")) {
			return "continuer";
		} else if (equals(source, "bravo") || equals(source, "perdu")) {
			return "continuer";
		}
		return "erreur";
	}
	void testAfficherScore() {
		assertEquals("Votre Score: 1000", afficherScore(1000));
		assertEquals("Votre Score: 1200", afficherScore(1200));
		assertEquals("Votre Score: 0", afficherScore(0));
	}
	String afficherScore(int scoreactuel) {
		return "Votre Score: " + scoreactuel;
	}
	void testAugmenterScore() {
		assertEquals(20, augmenterScore(0,20));
		assertEquals(10, augmenterScore(0,10));
		assertEquals(5, augmenterScore(0,5));
		assertEquals(1, augmenterScore(0,1));
	}
	void testGagnerVie() {
		assertEquals(3, gagnerVie(0,3,10));
		assertEquals(4, gagnerVie(0,4,10));
		assertEquals(5, gagnerVie(2,3,10));
		assertEquals(6, gagnerVie(3,3,10));
		assertEquals(10, gagnerVie(3,9,10));
		assertEquals(10, gagnerVie(50,50,10));
	}
	void testPerdreVie() {
		assertEquals(0, perdreVie(0,4));
		assertEquals(0, perdreVie(0,100));
		assertEquals(5, perdreVie(10,5));
		assertEquals(6, perdreVie(10,4));
		assertEquals(7, perdreVie(10,3));

	}
	int augmenterScore(int scoreactuel, int augmentation) {
		return scoreactuel + augmentation;
	}
	int augmenterScore(int scoreactuel, int base, int tentative) {
		if (tentative == 1) {
			return scoreactuel + base;
		} else if (tentative == 2) { 
			return scoreactuel + (base / 2);
		} else if (tentative == 3) {
			return scoreactuel + 1;
		}
		return scoreactuel;
	}			
	int gagnerVie(int vieactuelle, int gain, int maxvie) {
		if (vieactuelle + gain < maxvie) {
			return vieactuelle + gain;
		} else {
			return maxvie;
		}
	}
	int perdreVie(int vieactuelle, int perte) {
		if (vieactuelle - perte > 0) {
			return vieactuelle - perte;
		} else {
			return 0;
		}
	}
	int jouer(int maximumvie) {
		int question = genererRandom(1,maxquestion + 1);
		int score = 0;
		String choix = "continuer";
		int tentative = 1;
		int securite = 0;
		vie = maximumvie;
		serie = 0;
		boolean questionposees[] = new boolean [maxquestion + 1] ;
		boolean questionsuivante = true;
		while (vie > 0 && equals(choix, "continuer")) {
			clearScreen();
			afficherPerso();
			println(afficherScore(score));
			println("Votre vie :  "+ afficherVie(vie,'█', maximumvie));
				while (questionposees[question] && questionsuivante) {	
					securite = securite + 1;
					question = genererRandom(1,maxquestion + 1);
					if (securite > 1000) {
						choix = "menu";
						question = 0;
					}
				}
			String questionPosee = genererQuestion(question);
			String reponseSaisie = readString();
			boolean validitereponse = equals(questionPosee, reponseSaisie);
			if (equals(reponseSaisie,"1") || equals(reponseSaisie,"2") || equals(reponseSaisie,"3") || equals(reponseSaisie,"4"))  {
				if (validitereponse) {
					questionposees[question] = true;
					serie = serie + 1;
					questionsuivante = true;
					score = augmenterScore(score, 10 * (10 - (maximumvie - 1)), tentative);
					if (serie >= 3 && maximumvie > 1){
						score = augmenterScore(score, serie * 20);
						vie = gagnerVie(vie, 1, maximumvie);
					}
					tentative = 1;
					choix = action(afficherBravo(), readString());
				} else if (!validitereponse) {
					serie = 0;
					vie = perdreVie(vie, 1);
					clearScreen();
					afficherMechant();
					choix = action(afficherPerdu(), readString());
					tentative = tentative + 1;
					questionsuivante = false;
				}
			} else if (equals(reponseSaisie,"EXIT") || equals(reponseSaisie,"exit") || equals(reponseSaisie,"Exit")) {
				choix = "menu";
			}
		}
		return score;
	}
	String genererQuestion(int numeroquestion) {
		if (numeroquestion <= maxquestion) {
			String textQuestion [] = {
				"",
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
			String reponse [] = {"","2","3","3","1","3","4","2","4","3"};
			println(textQuestion[numeroquestion]);
			return reponse[numeroquestion];
		} else {
			vie = 0;
		}
		return "";
	}
	void passerLignes(int nblignes) {
		for (int i = nblignes ; i > 0; i--) {
			println("");
		}
	}
	void testAfficherDemo() {
		assertTrue(afficherDemo("1"));
	}
	boolean afficherDemo(String présaisie) {
		if (action("demo", présaisie) == "continuer") {
			return true;
		} else {
			clearScreen();
			println("██████╗ ███████╗███╗   ███╗ ██████╗ ");
			println("██╔══██╗██╔════╝████╗ ████║██╔═══██╗");
			println("██║  ██║█████╗  ██╔████╔██║██║   ██║");
			println("██║  ██║██╔══╝  ██║╚██╔╝██║██║   ██║");
			println("██████╔╝███████╗██║ ╚═╝ ██║╚██████╔╝");
			println("╚═════╝ ╚══════╝╚═╝     ╚═╝ ╚═════╝ ");
			passerLignes(5);
			println("Pour pouvoir répondre aux questions et jouer au jeu tu dois");
			println("entrer le numéro correspondant à ton choix et appuyer sur");
			println("la touche entrée");
			println("Pour bien voir le Jeu, met ta fenêtre en plein écran !");
			passerLignes(1);
			println("as-tu compris ?  ");
			println("1. OUI");
			String choix = action("demo", readString());
			while ( choix != "continuer" ) {
				clearScreen();
				println("Tu dois entrer le numéro de ton choix, le seul choix");
				println("ici est le 1");
				choix = action("demo", readString());
			}
		}
		return true;
	}
	String afficherBravo() {
		clearScreen();
		println("██████╗ ██████╗  █████╗ ██╗   ██╗ ██████╗     ██╗");
		println("██╔══██╗██╔══██╗██╔══██╗██║   ██║██╔═══██╗    ██║");
		println("██████╔╝██████╔╝███████║██║   ██║██║   ██║    ██║");
		println("██╔══██╗██╔══██╗██╔══██║╚██╗ ██╔╝██║   ██║    ╚═╝");
		println("██████╔╝██║  ██║██║  ██║ ╚████╔╝ ╚██████╔╝    ██╗");
		println("╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝  ╚═══╝   ╚═════╝     ╚═╝");
		passerLignes(10);
		if (serie >= 3) {
			println("Vous êtes dans une série de bonnes réponses, vous gagnez un point de vie !");
		}
		return "bravo";
	}
	void afficherPerso(){
		if (vie < 5) {
			println("    ▄████▄▄");
			println("   ▄▀█▀▐└─┐");
			println("   █▄▐▌▄█▄┘");
			println("   └▄▄▄▄─┘");
			println("▄███▒██▒███▄");
			println("▒▒█▄▒▒▒▒▄█▒▒");
			println("  ▒▒▒▀▀▒▒▒");
			println("▄███    ███▄");
		} else {
			println("              ███████  ███████");
			println("          ████▓▓▓▓▓▓████░░░░░██");
			println("        ██▓▓▓▓▓▓▓▓▓▓▓▓██░░░░░░██");
			println("      ██▓▓▓▓▓▓████████████░░░░██");
			println("    ██▓▓▓▓▓▓████████████████░██");
			println("    ██▓▓████░░░░░░░░░░░░██████");
			println("  ████████░░░░░░██░░██░░██▓▓▓▓██");
			println("  ██░░████░░░░░░██░░██░░██▓▓▓▓██");
			println("██░░░░██████░░░░░░░░░░░░░░██▓▓██");
			println("██░░░░░░██░░░░██░░░░░░░░░░██▓▓██");
			println("  ██░░░░░░░░░███████░░░░██████");
			println("    ████░░░░░░░███████████▓▓██");
			println("      ██████░░░░░░░░░░██▓▓▓▓██");
			println("    ██▓▓▓▓██████████████▓▓██");
			println("  ██▓▓▓▓▓▓▓▓████░░░░░░████");
			println("████▓▓▓▓▓▓▓▓██░░░░░░░░░░██");
			println("████▓▓▓▓▓▓▓▓██░░░░░░░░░░██");
			println("██████▓▓▓▓▓▓▓▓██░░░░░░████████");
			println("  ██████▓▓▓▓▓▓████████████████");
			println("    ██████████████████████▓▓▓▓██");
			println("  ██▓▓▓▓████████████████▓▓▓▓▓▓██");
			println("████▓▓██████████████████▓▓▓▓▓▓██");
			println("██▓▓▓▓██████████████████▓▓▓▓▓▓██");
			println("██▓▓▓▓██████████      ██▓▓▓▓████");
			println("██▓▓▓▓████              ██████ ");
			println("  ████");
		}
		passerLignes(5);
	}
	void afficherMechant() {
		println("       ▄█          █         █▄       ");
		println("     ▐██      ▄█  ███  █▄     ██▌     ");
		println("    ▐██▀     █████████████    ▀██▌    ");
		println("   ▐██▌     ██████████████     ▐██▌   ");
		println("   ████    ████████████████    ████   ");
		println("  ▐█████  ██████████████████  █████▌  ");
		println("   ████████████████████████████████   ");
		println("    ███████▀▀████████████▀▀███████    ");
		println("     █████▌  ▄▄ ▀████▀ ▄▄  ▐█████     ");
		println("   ▄▄██████▄ ▀▀  ████  ▀▀ ▄██████▄▄   ");
		println("  ██████████████████████████████████  ");
		println(" ████████████████████████████████████ ");
		println("▐██████  ███████▀▄██▄▀███████  ██████▌");
		println("▐█████    ██████████████████    █████▌");
		println("▐█████     ██████▀  ▀██████     █████▌");
		println(" █████▄     ███        ███     ▄█████ ");
		println("  ██████     █          █     ██████  ");
		println("    █████                    █████    ");
		println("     █████                  █████     ");
		println("      █████                █████      ");
		println("       ████   ▄        ▄   ████       ");
		println("        ████ ██        ██ ████        ");
		println("        ████████ ▄██▄ ████████        ");
		println("       ████████████████████████       ");
		println("       ████████████████████████       ");
		println("        ▀█████████▀▀█████████▀        ");
		println("          ▀███▀        ▀███▀         ");
		passerLignes(5);
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
}
