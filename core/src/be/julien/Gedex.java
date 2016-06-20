package be.julien;

import be.julien.main.Game;
import com.badlogic.gdx.ApplicationAdapter;

public class Gedex extends ApplicationAdapter {

	Game game;
	
	@Override
	public void create () {
		game.INSTANCE.create();
	}

	@Override
	public void render () {
		game.INSTANCE.render();
	}
}
