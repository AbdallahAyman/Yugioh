package eg.edu.guc.yugioh.gui;

public class updateGui {
	GameStarts gs;
	public GameStarts getGs() {
		return gs;
	}
	public void setGs(GameStarts gs) {
		this.gs = gs;
	}
	activeDeck ad;
	activeGraveyard ag;
	activeHand ah;
	activeMonstersArea ama;
	activeSpellArea asa;
	opponentDeck od;
	opponentGraveyard og;
	opponentHand oh;
	opponentMonstersArea oma;
	opponentSpellArea osa;
	phases p;
	public void updateThisGui(){
		ad.resetActiveDeck();
		ad.setUg(this);
		ag.resetActiveGraveyard();
		ag.setUg(this);
		ah.resetActiveHand();
		ah.setUg(this);
		ama.resetActiveMonster();
		ama.setUg(this);
		asa.resetActiveSpellArea();
		asa.setUg(this);
		od.resetOppoenentDeck();
		od.setUg(this);
		og.resetOpponentGraveyard();
		og.setUg(this);
		oh.resetOpponentHand();
		oh.setUg(this);
		oma.resetOpponentMonstersArea();
		oma.setUg(this);
		osa.resetActiveSpellArea();
		osa.setUg(this);
		p.buildPhase();
		p.setUg(this);
		ad.buildActiveDeck();
		ad.setUg(this);
		ag.buildActiveGraveyard();
		ag.setUg(this);
		ah.buildActiveHand();
		ah.setUg(this);
		ama.buildActiveMonster();
		ama.setUg(this);
		asa.buildActivateSpellArea();
		asa.setUg(this);
		od.buildOpponentDeck();
		od.setUg(this);
		og.buildOpponentGraveyard();
		og.setUg(this);
		oh.buildOpponentHand();
		oh.setUg(this);
		oma.buildOpponentMonstersArea();
		oma.setUg(this);
		osa.buildActivateSpellArea();
		osa.setUg(this);
		p.resetPhase();
		p.setUg(this);

	}
}
