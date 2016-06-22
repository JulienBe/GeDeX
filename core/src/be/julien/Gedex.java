package be.julien;

import be.julien.main.Game;
import be.julien.main.GdxProvider;
import com.badlogic.gdx.ApplicationAdapter;

public class Gedex extends ApplicationAdapter {

	Game game;
	
	@Override
	public void create () {
        game = new Game(new GdxProvider());
		game.create();
	}

	@Override
	public void render () {
		game.render();
	}
}
