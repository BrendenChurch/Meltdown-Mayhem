package me.brendenchurch.meltdownmayhem;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MeltdownMayhem extends Game {
	
	SpriteBatch batch;
	
	@Override
	public void create () {
		setScreen(new MenuScreen(this));
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
