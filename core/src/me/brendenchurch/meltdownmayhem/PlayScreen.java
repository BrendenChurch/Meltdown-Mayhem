package me.brendenchurch.meltdownmayhem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.math.MathUtils;

public class PlayScreen implements Screen {

	private final static float CARD_WIDTH = 1f;
	private final static float CARD_HEIGHT = 1f;
	private final static float MINIMUM_VIEWPORT_SIZE = 4f;

	PerspectiveCamera cam;
	TextureAtlas atlas;
	SpriteBatch batch;
	CameraInputController controller;

	@Override
	public void show() {
		batch = new SpriteBatch();
		atlas = new TextureAtlas();

		cam = new PerspectiveCamera();
		cam.position.set(0, 0, 10);
		cam.lookAt(0, 0, 0);

		controller = new CameraInputController(cam);
		Gdx.input.setInputProcessor(controller);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		controller.update();
		
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		
	}

	@Override
	public void resize(int width, int height) {
		float halfHeight = MINIMUM_VIEWPORT_SIZE * 0.5f;
		if (height > width)
			halfHeight *= (float) height / (float) width;
		float halfFovRadians = MathUtils.degreesToRadians * cam.fieldOfView * 0.5f;
		float distance = halfHeight / (float) Math.tan(halfFovRadians);

		cam.viewportWidth = width;
		cam.viewportHeight = height;
		cam.position.set(0, 0, distance);
		cam.lookAt(0, 0, 0);
		cam.update();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		batch.dispose();
		atlas.dispose();
	
	}

}
