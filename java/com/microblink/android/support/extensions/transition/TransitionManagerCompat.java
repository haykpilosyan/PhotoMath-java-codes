/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.annotation.TargetApi
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.transition.AutoTransition
 *  android.transition.ChangeTransform
 *  android.transition.Transition
 *  android.transition.TransitionManager
 *  android.view.ViewGroup
 *  android.view.animation.DecelerateInterpolator
 *  java.lang.Object
 */
package com.microblink.android.support.extensions.transition;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.os.Build;
import android.transition.AutoTransition;
import android.transition.ChangeTransform;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

public class TransitionManagerCompat {
    public static void beginDelayedTransition(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 19) {
            TransitionManager.beginDelayedTransition((ViewGroup)viewGroup);
        }
    }

    public static void beginDelayedTransition(ViewGroup viewGroup, int n2) {
        TransitionManagerCompat.beginDelayedTransition(viewGroup, n2, (TimeInterpolator)new DecelerateInterpolator());
    }

    public static void beginDelayedTransition(ViewGroup viewGroup, int n2, TimeInterpolator timeInterpolator) {
        if (Build.VERSION.SDK_INT >= 19) {
            TransitionManagerCompat.beginDelayedTransition(viewGroup, n2, timeInterpolator, (Transition)new AutoTransition());
        }
    }

    @TargetApi(value=19)
    private static void beginDelayedTransition(ViewGroup viewGroup, int n2, TimeInterpolator timeInterpolator, Transition transition) {
        transition.setInterpolator(timeInterpolator);
        transition.setDuration((long)n2);
        TransitionManager.beginDelayedTransition((ViewGroup)viewGroup, (Transition)transition);
    }

    public static void beginDelayedTransitionChange(ViewGroup viewGroup, int n2, TimeInterpolator timeInterpolator) {
        if (Build.VERSION.SDK_INT >= 21) {
            TransitionManagerCompat.beginDelayedTransition(viewGroup, n2, timeInterpolator, (Transition)new ChangeTransform());
        }
    }
}

