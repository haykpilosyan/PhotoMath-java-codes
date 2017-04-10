/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.microblink.android.support.extensions.animation;

import android.view.View;
import android.view.ViewPropertyAnimator;

public class AnimationUtils {
    public static long DEFAULT_FADE_DURATION = 300;
    public static long DEFAULT_HINT_VISIBILE_DURATION = 1000;

    public static void fadeInView(View view) {
        AnimationUtils.fadeInView(view, DEFAULT_FADE_DURATION, null);
    }

    public static void fadeInView(View view, long l2, Runnable runnable) {
        if (view.getVisibility() != 0) {
            view.setVisibility(0);
            view.setAlpha(0.0f);
        }
        view.animate().alpha(1.0f).setDuration(l2).withEndAction(runnable).start();
    }

    public static void fadeOutView(View view) {
        AnimationUtils.fadeOutView(view, null);
    }

    public static void fadeOutView(final View view, long l2, final int n2, final Runnable runnable) {
        if (view.getVisibility() != 0) {
            return;
        }
        view.animate().alpha(0.0f).setDuration(l2).withEndAction(new Runnable(){

            public void run() {
                view.setVisibility(n2);
                if (runnable != null) {
                    runnable.run();
                }
            }
        }).start();
    }

    public static void fadeOutView(View view, Runnable runnable) {
        AnimationUtils.fadeOutView(view, DEFAULT_FADE_DURATION, 8, runnable);
    }

}

