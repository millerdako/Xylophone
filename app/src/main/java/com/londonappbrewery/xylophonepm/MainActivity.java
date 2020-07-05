package com.londonappbrewery.xylophonepm;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    // Helpful Constants
    private final int NR_OF_SIMULTANEOUS_SOUNDS = 7;
    private final float LEFT_VOLUME = 1.0f;
    private final float RIGHT_VOLUME = 1.0f;
    private final int NO_LOOP = 0;
    private final int PRIORITY = 0;
    private final float NORMAL_PLAY_RATE = 1.0f;

    // TODO: Add member variables here
    private SoundPool mSoundPool;
    private int mCSoundId;
    private int mDSoundId;
    private int mESoundId;
    private int mFSoundId;
    private int mGSoundId;
    private int mASoundId;
    private int mBSoundId;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.SMART_BANNER);
        //adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        adView.setAdUnitId("ca-app-pub-9391440864407001/2855331346");


        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        // TODO: Create a new SoundPool
        mSoundPool = new SoundPool(NR_OF_SIMULTANEOUS_SOUNDS, AudioManager.STREAM_MUSIC, 0);

        // TODO: Load and get the IDs to identify the sounds
        mCSoundId = mSoundPool.load(getApplicationContext(), R.raw.note1_c, 1);
        mDSoundId = mSoundPool.load(getApplicationContext(), R.raw.note2_d, 1);
        mESoundId = mSoundPool.load(getApplicationContext(), R.raw.note3_e, 1);
        mFSoundId = mSoundPool.load(getApplicationContext(), R.raw.note4_f, 1);
        mGSoundId = mSoundPool.load(getApplicationContext(), R.raw.note5_g, 1);
        mASoundId = mSoundPool.load(getApplicationContext(), R.raw.note6_a, 1);
        mBSoundId = mSoundPool.load(getApplicationContext(), R.raw.note7_b, 1);

        final Button mC_key;
        final Button mD_key;
        final Button mE_key;
        final Button mF_key;
        final Button mG_key;
        final Button mA_key;
        final Button mB_key;

        mC_key = (Button) findViewById(R.id.c_key);
        mD_key = (Button) findViewById(R.id.d_key);
        mE_key = (Button) findViewById(R.id.e_key);
        mF_key = (Button) findViewById(R.id.f_key);
        mG_key = (Button) findViewById(R.id.g_key);
        mA_key = (Button) findViewById(R.id.a_key);
        mB_key = (Button) findViewById(R.id.b_key);

        mC_key.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    mSoundPool.play(mCSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
                    mC_key.setText(R.string.C);
                    return true;
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    mC_key.setText("");
                    return true;
                }
                return false;
            }
        });

        mD_key.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    mSoundPool.play(mDSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
                    mD_key.setText(R.string.D);
                    return true;
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    mD_key.setText("");
                    return true;
                }
                return false;
            }
        });

        mE_key.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    mSoundPool.play(mESoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
                    mE_key.setText(R.string.E);
                    return true;
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    mE_key.setText("");
                    return true;
                }
                return false;
            }
        });

        mF_key.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    mSoundPool.play(mFSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
                    mF_key.setText(R.string.F);
                    return true;
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    mF_key.setText("");
                    return true;
                }
                return false;
            }
        });

        mG_key.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    mSoundPool.play(mGSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
                    mG_key.setText(R.string.G);
                    return true;
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    mG_key.setText("");
                    return true;
                }
                return false;
            }
        });

        mA_key.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    mSoundPool.play(mASoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
                    mA_key.setText(R.string.A);
                    return true;
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    mA_key.setText("");
                    return true;
                }
                return false;
            }
        });

        mB_key.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    mSoundPool.play(mBSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
                    mB_key.setText(R.string.B);
                    return true;
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    mB_key.setText("");
                    return true;
                }
                return false;
            }
        });


    }

    // TODO: Add the play methods triggered by the buttons
//    public void playC(View v){
//        mSoundPool.play(mCSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
//    }
//
//    public void playD(View v){
//        mSoundPool.play(mDSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
//    }

//    public void playE(View v){
//        mSoundPool.play(mESoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
//    }
//
//    public void playF(View v){
//        mSoundPool.play(mFSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
//    }
//
//    public void playG(View v){
//        mSoundPool.play(mGSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
//    }
//
//    public void playA(View v){
//        mSoundPool.play(mASoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
//    }
//
//    public void playB(View v){
//        mSoundPool.play(mBSoundId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
//    }

}
