package edu.android.floatingbuttontest;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton floatingActionButton;
    private FloatingActionButton floatingBtnEmoticon;
    private FloatingActionButton floatingBtnFilter;
    private FloatingActionButton floatingBtnTest;
    private Animation mShowButton;
    private Animation mHideButton;
    private Animation mShowResButton;
    private Animation mHideResButton;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingBtnEmoticon = (FloatingActionButton) findViewById(R.id.floatinBtnEmoticon);
        floatingBtnFilter= (FloatingActionButton) findViewById(R.id.floatingBtnTest);
        floatingBtnTest = (FloatingActionButton) findViewById(R.id.floatingBtnFilter);
        floatingBtnEmoticon.setVisibility(View.INVISIBLE);
        floatingBtnFilter.setVisibility(View.INVISIBLE);
        floatingBtnTest.setVisibility(View.INVISIBLE);
        mShowButton = AnimationUtils.loadAnimation(this, R.anim.show_button);
        mHideButton = AnimationUtils.loadAnimation(this, R.anim.hide_button);
        mShowResButton = AnimationUtils.loadAnimation(this, R.anim.show_res_button);
        mHideResButton = AnimationUtils.loadAnimation(this, R.anim.hide_res_button);
        layout = (ConstraintLayout) findViewById(R.id.layout);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (floatingBtnEmoticon.getVisibility() == View.INVISIBLE &&
                        floatingBtnFilter.getVisibility() == View.INVISIBLE &&
                        floatingBtnTest.getVisibility() == View.INVISIBLE) {
                    layout.setBackgroundColor(getResources().getColor(R.color.colorDarkGray));
                    floatingBtnEmoticon.setVisibility(View.VISIBLE);
                    floatingBtnFilter.setVisibility(View.VISIBLE);
                    floatingBtnTest.setVisibility(View.VISIBLE);


                    floatingBtnEmoticon.startAnimation(mShowResButton);
                    floatingBtnFilter.startAnimation(mShowResButton);
                    floatingBtnTest.startAnimation(mShowResButton);

                    floatingActionButton.startAnimation(mShowButton);




                } else if(floatingBtnEmoticon.getVisibility() == View.VISIBLE &&
                        floatingBtnFilter.getVisibility() == View.VISIBLE &&
                        floatingBtnTest.getVisibility() == View.VISIBLE) {

                    layout.setBackgroundColor(getResources().getColor(R.color.colorWhiete));
                    floatingBtnEmoticon.setVisibility(View.INVISIBLE);
                    floatingBtnFilter.setVisibility(View.INVISIBLE);
                    floatingBtnTest.setVisibility(View.INVISIBLE);
                    floatingBtnEmoticon.setClickable(false);
                    floatingBtnFilter.setClickable(false);
                    floatingBtnTest.setClickable(false);

                    floatingBtnEmoticon.startAnimation(mHideResButton);
                    floatingBtnFilter.startAnimation(mHideResButton);
                    floatingBtnTest.startAnimation(mHideResButton);

                    floatingActionButton.startAnimation(mHideButton);
                }


            }
        });
    }


}
