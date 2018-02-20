package com.keludo.sprites;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Eldar on 28/09/2017.
 */

public class Rofus extends Game {
    public SpriteBatch batch;
    public BitmapFont font;

    @Override
    public void create() {
        batch=new SpriteBatch();
        font=new BitmapFont();
        font.getData().setScale(1.5f,1.5f);
        this.setScreen(new MainMenu(this));
    }
    @Override
    public void render(){
        super.render();
    }
    @Override
    public void dispose(){
        batch.dispose();
        font.dispose();
    }
}
