package me.brendenchurch.meltdownmayhem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuScreen implements Screen {

	private static final int MENU_SIZE = 640;
	
	private MeltdownMayhem game;
	
	private SpriteBatch batch;
	private Stage stage;
	private Viewport viewport;
	private OrthographicCamera camera;
	private TextureAtlas atlas;
	private Skin skin;
	
	
	public MenuScreen(MeltdownMayhem game) {
		this.game = game;
		
		atlas = new TextureAtlas(Gdx.files.internal("pack/menu/biological-attack-ui.atlas"));
		skin = new Skin(Gdx.files.internal("pack/menu/biological-attack-ui.json"), atlas);
		
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		viewport = new FitViewport(MENU_SIZE, MENU_SIZE, camera);
		viewport.apply();
		
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
		camera.update();
		
		stage = new Stage(viewport, batch);
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
		
		Table mainTable = new Table();
		mainTable.setFillParent(true);
		mainTable.top();
		
		Label title = new Label("Meltdown Mayhem", skin, "title");
		
		ImageTextButton playButton = new ImageTextButton("Play", skin);
		ImageTextButton optionsButton = new ImageTextButton("Options", skin);
		ImageTextButton exitButton = new ImageTextButton("Exit", skin);
		
		
		playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new PlayScreen());
            }
        });
        exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
        
        mainTable.add(title);
        mainTable.row();
        
        mainTable.add(playButton);
        mainTable.row();
        mainTable.add(optionsButton);
        mainTable.row();
        mainTable.add(exitButton);

        stage.addActor(mainTable);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1f, 1f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
		camera.update();
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
		skin.dispose();
		atlas.dispose();
	}
	
	
	
}