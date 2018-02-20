package com.keludo.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.keludo.Try;

/**
 * Created by Eldar on 28/09/2017.
 */

public class GameOver implements Screen {
    final Rofus game;
    OrthographicCamera camera;

    public GameOver(final Rofus game)
    {
        this.game=game;
        camera=new OrthographicCamera();
        camera.setToOrtho(false,480,800);
        game.font.getData().setScale(1.5f,1.5f);


    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0.2f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.font.draw(game.batch,"Rofus Died!",100,150);
        game.font.draw(game.batch,"Tap anywhere to retry",100,100);
        game.batch.end();
        if(Gdx.input.isTouched()){
            game.setScreen(new Try(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
