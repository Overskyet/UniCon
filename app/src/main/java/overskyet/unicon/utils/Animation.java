package overskyet.unicon.utils;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

public class Animation {

    public static void slideView(View view, int currentWidth, int newWidth) {

        ValueAnimator slideAnimator = ValueAnimator
                .ofInt(currentWidth, newWidth)
                .setDuration(300);

        /* We use an update listener which listens to each tick
         * and manually updates the width of the view  */

        slideAnimator.addUpdateListener(animation1 -> {
            view.getLayoutParams().width = (Integer) animation1.getAnimatedValue();
            view.requestLayout();
        });

        /*  We use an animationSet to play the animation  */

        AnimatorSet animationSet = new AnimatorSet();
        animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animationSet.play(slideAnimator);
        animationSet.start();
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

}
