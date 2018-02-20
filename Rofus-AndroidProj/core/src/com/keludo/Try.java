package com.keludo;

import java.io.Console;
import java.util.Iterator;
import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.async.ThreadUtils;
import com.keludo.sprites.GameOver;
import com.keludo.sprites.MainMenu;
import com.keludo.sprites.Rofus;

import org.omg.PortableServer.POAManagerPackage.State;
import org.w3c.dom.css.Rect;

import sun.net.ProgressSource;

public class Try implements Screen {

    final Rofus game;
     Texture dropImage;
     Texture bucketImage;
     Sound dropSound;
     Music rainMusic;

     OrthographicCamera camera;
     Rectangle bucket;
     Array<Rectangle> raindrops;
    long lastDropTime;
    long lastDropTime1;
    Texture nana;
    int x;
    Array<Rectangle> raindrops1;
     Texture background;
    Array<Rectangle> raindrops2;
     long lastDropTime2;
    Texture bananaRakuv;
     int score;
     String yourScoreName;
     BitmapFont TheBitmapFontName;
     BitmapFont bb;
     float dt3;
     long Kamazman;
 int lives;
    long ahi;


    public Try(final Rofus game ) {
        this.game=game;
        ahi=1500000000;
        score=0;
        lives=4;
        yourScoreName="score: 0";
 bb=new BitmapFont();
        TheBitmapFontName=new BitmapFont();
        // load the images for the droplet and the bucket, 64x64 pixels each
        dropImage = new Texture(Gdx.files.internal("banana01.png"));
        bucketImage = new Texture(Gdx.files.internal("gorilla.png"));
        nana = new Texture(Gdx.files.internal("banana04.png"));
        background=new Texture(Gdx.files.internal("pixlBG.png"));
        bananaRakuv=new Texture(Gdx.files.internal("banana02.png"));
        game.font.getData().setScale(3f,3f);
        Kamazman=System.currentTimeMillis();

        // load the drop sound effect and the rain background "music"
         dropSound = Gdx.audio.newSound(Gdx.files.internal("pop.mp3"));
        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("sh.mp3"));
        rainMusic.setLooping(true);


        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false,480, 800);


        // create a Rectangle to logically represent the bucket
        bucket = new Rectangle();
        bucket.x =480 / 2 - 64 / 2; // center the bucket horizontally
        bucket.y =20 ; // bottom left corner of the bucket is 20 pixels above the bottom screen edge
        bucket.width = 55;
        bucket.height = 55;


        // create the raindrops array and spawn the first raindrop
        raindrops = new Array<Rectangle>();
        raindrops1 = new Array<Rectangle>();
        raindrops2=new Array<Rectangle>();
        spawnRaindrop();
             spqwnRaindrop1();
        spawnRakuv();
    }

    public class AllBananas {

        public int RandromIt() {
            int rand = MathUtils.random(1, 6);
            return rand;
        }


    }


    private void spawnRaindrop() {
        Rectangle raindrop = new Rectangle();
        raindrop.x = MathUtils.random(0, 480 - 64);
        raindrop.y = 800;
        raindrop.width = 64;
        raindrop.height = 64;
        raindrops.add(raindrop);

        lastDropTime = TimeUtils.nanoTime();





    }

    public void spqwnRaindrop1() {
        Rectangle raindrop1 = new Rectangle();
        raindrop1.x = MathUtils.random(0,480-64);
        raindrop1.y = 800;
        raindrop1.width = 55;
        raindrop1.height = 55;
        raindrops1.add(raindrop1);

        lastDropTime1 = TimeUtils.nanoTime();
    }
public void spawnRakuv(){
    Rectangle raindrop2=new Rectangle();
    raindrop2.x = MathUtils.random(0,480-64);
    raindrop2.y = 800;
    raindrop2.width = 55;
    raindrop2.height = 55;
    raindrops2.add(raindrop2);
    lastDropTime2=TimeUtils.nanoTime();
}


    @Override
    public void render(float delta) {
        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.
        camera.update();


        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);
        boolean flag = false;
        float dt1 = Gdx.graphics.getDeltaTime();
        int count = 0;
        float y = 480;
        // begin a new batch and draw the bucket and
        // all drops


        game.batch.begin();
game.batch.draw(background,0,0);

        game.font.draw(game.batch,yourScoreName,25,700);

        game.font.draw(game.batch,""+lives+"",455,700);
        game.batch.draw(bucketImage, bucket.x, bucket.y);
        for (Rectangle raindrop : raindrops) {

            game.batch.draw(dropImage, raindrop.x, raindrop.y, 100, 100);


        }

    for (Rectangle raindrop1 : raindrops1) {
        game.batch.draw(nana, raindrop1.x, raindrop1.y, 100, 100);
    }

        for(Rectangle raindrop2:raindrops2)
            game.batch.draw(bananaRakuv,raindrop2.x,raindrop2.y,100,100);




        game.batch.end();



        Iterator<Rectangle> iter1 = raindrops1.iterator();


while(iter1.hasNext()){

            Rectangle raindrop1 = iter1.next();
            raindrop1.y -= (300 * Gdx.graphics.getDeltaTime());
            if (raindrop1.y + 64 < 0) {
                count++;
                iter1.remove();

            }
            if (raindrop1.overlaps(bucket)) {
                dropSound.play();
                lives=0;
                iter1.remove();

            }

        }
        Iterator<Rectangle> iter2 = raindrops2.iterator();
        while(iter2.hasNext()) {
            Rectangle raindrop2 = iter2.next();


            raindrop2.y -= (250 * Gdx.graphics.getDeltaTime());

            if (raindrop2.y + 64 < 0) iter2.remove();
            if (raindrop2.overlaps(bucket)) {
                dropSound.play();
                score-=15;
                yourScoreName="score: "+score;
                iter2.remove();

            }
        }
        // process user input
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            bucket.x = touchPos.x - 64 / 2;
        }
        if (Gdx.input.isKeyPressed(Keys.LEFT)) bucket.x -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) bucket.x += 200 * Gdx.graphics.getDeltaTime();

        // make sure the bucket stays within the screen bounds
        if (bucket.x < 0) bucket.x = 0;
        if (bucket.x > 480 - 64) bucket.x = 480 - 64;


        if (System.currentTimeMillis() > Kamazman+5000&&System.currentTimeMillis()<Kamazman+40000) {
ahi-=400000;

        }
        if (TimeUtils.nanoTime() - lastDropTime > ahi-600000000)
            spawnRaindrop();
        if (TimeUtils.nanoTime() - lastDropTime1 > ahi*4)
spqwnRaindrop1();
            if (TimeUtils.nanoTime() - lastDropTime2 > ahi*2)
spawnRakuv();



        // move the raindrops, remove any that are beneath the bottom edge of
        // the screen or that hit the bucket. In the later case we play back
        // a sound effect as well.
        Iterator<Rectangle> iter = raindrops.iterator();

        while (iter.hasNext())

        {
            Rectangle raindrop = iter.next();



            raindrop.y -= (250 * Gdx.graphics.getDeltaTime());

            if (raindrop.y + 64 < 0) {
                iter.remove();
                lives--;
            }
            if (raindrop.overlaps(bucket)) {
                dropSound.play();
                score+=30;
                yourScoreName="score: "+score;
                iter.remove();

            }

        }
if(lives==0) {
    game.setScreen(new GameOver(game));
    rainMusic.stop();
}
    }


    @Override
    public void show() {
        rainMusic.play();

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
        // dispose of all the native resources
        dropImage.dispose();
        bucketImage.dispose();
        nana.dispose();
        background.dispose();
        bananaRakuv.dispose();
          rainMusic.dispose();
        dropSound.dispose();
       game.batch.dispose();
    }


}







