/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 */
package com.microblink.android.support.extensions.animation;

import android.animation.Animator;

public abstract class AnimatorListenerAdapter
extends android.animation.AnimatorListenerAdapter {
    public final void onAnimationCancel(Animator animator) {
        this.onAnimationFinish(animator);
    }

    public final void onAnimationEnd(Animator animator) {
        this.onAnimationFinish(animator);
    }

    public abstract void onAnimationFinish(Animator var1);
}

