  class Projet extends Program {
  	final int maxquestion = 9;
  	void algorithm() {
  		do {
  			int choix = 0;
  			clearScreen();
  			println("Bienvenue dans le jeu !");
  			println("Que voulez-vous faire ?");
  			choix = demanderChoix();
  			if (choix == 10) {
  			} else {
  				println("Votre choix est correct mais la fonctionnalité est indisponnible...");
  			}
  			delay(10000);
  		} while(choix != 9);
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
  	void afficherPerdu(int vieactuelle) {
  		println("██████╗ ███████╗██████╗ ██████╗ ██╗   ██╗    ██╗");
  		println("██╔══██╗██╔════╝██╔══██╗██╔══██╗██║   ██║    ██║");
  		println("██████╔╝█████╗  ██████╔╝██║  ██║██║   ██║    ██║");
  		println("██╔═══╝ ██╔══╝  ██╔══██╗██║  ██║██║   ██║    ╚═╝");
  		println("██║     ███████╗██║  ██║██████╔╝╚██████╔╝    ██╗");
  		println("╚═╝     ╚══════╝╚═╝  ╚═╝╚═════╝  ╚═════╝     ╚═╝");
  		passerLignes(6);
  		if (vieactuelle == 0) {
  			println("██████╗ ██╗     ██╗   ██╗███████╗    ██████╗ ███████╗    ██╗   ██╗██╗███████╗");
  			println("██╔══██╗██║     ██║   ██║██╔════╝    ██╔══██╗██╔════╝    ██║   ██║██║██╔════╝");
  			println("██████╔╝██║     ██║   ██║███████╗    ██║  ██║█████╗      ██║   ██║██║█████╗  ");
  			println("██╔═══╝ ██║     ██║   ██║╚════██║    ██║  ██║██╔══╝      ╚██╗ ██╔╝██║██╔══╝  ");
  			println("██║     ███████╗╚██████╔╝███████║    ██████╔╝███████╗     ╚████╔╝ ██║███████╗");
  			println("╚═╝     ╚══════╝ ╚═════╝ ╚══════╝    ╚═════╝ ╚══════╝      ╚═══╝  ╚═╝╚══════╝");
  		}
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
  	String[] genererQuestion(int numeroquestion) {
  		String[] laquestion = new String[2];
  		String[] textQuestion = {
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
  		String[] reponse = {"","2","3","3","1","3","4","2","4","3"};
  		laquestion[0] = textQuestion[numeroquestion];
  		laquestion[1] = reponse[numeroquestion];
  		return laquestion;
  	}
  	void passerLignes(int nblignes) {
  		for (int i = nblignes ; i > 0; i--) {
  			println("");
  		}
  	}
  	void afficherBravo(int serieactuelle) {
  		clearScreen();
  		println("██████╗ ██████╗  █████╗ ██╗   ██╗ ██████╗     ██╗");
  		println("██╔══██╗██╔══██╗██╔══██╗██║   ██║██╔═══██╗    ██║");
  		println("██████╔╝██████╔╝███████║██║   ██║██║   ██║    ██║");
  		println("██╔══██╗██╔══██╗██╔══██║╚██╗ ██╔╝██║   ██║    ╚═╝");
  		println("██████╔╝██║  ██║██║  ██║ ╚████╔╝ ╚██████╔╝    ██╗");
  		println("╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝  ╚═══╝   ╚═════╝     ╚═╝");
  		passerLignes(10);
  		if (serieactuelle >= 3) {
  			println("Vous êtes dans une série de bonnes réponses, vous gagnez un point de vie !");
  		}
  	}
  	void afficherPerso(int vieactuelle){
  		if (vieactuelle < 5) {
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
  	int demanderChoix() {
  		int resultat = 0;
  		print("Votre choix:");
  		String temp = readString();
  		if ((length(temp) == 1) && (charAt(temp,0) > '0' && charAt(temp,0) < '9')){
  			resultat = stringToInt(temp);
  		} else {
  			println("Ceci n'est pas un choix valide !");
  			demanderChoix();
  		}
  		return resultat;
  	}
  }