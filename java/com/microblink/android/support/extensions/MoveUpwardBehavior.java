/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.support.design.widget.CoordinatorLayout
 *  android.support.design.widget.CoordinatorLayout$a
 *  android.support.design.widget.Snackbar
 *  android.support.design.widget.Snackbar$SnackbarLayout
 *  android.view.View
 *  java.lang.Math
 */
package com.microblink.android.support.extensions;

import android.os.Build;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;

public class MoveUpwardBehavior
extends CoordinatorLayout.a<View> {
    private static final boolean SNACKBAR_BEHAVIOR_ENABLED;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = Build.VERSION.SDK_INT >= 11;
        SNACKBAR_BEHAVIOR_ENABLED = bl;
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (SNACKBAR_BEHAVIOR_ENABLED && view2 instanceof Snackbar.SnackbarLayout) {
            return true;
        }
        return false;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        view.setTranslationY(Math.min((float)0.0f, (float)(view2.getTranslationY() - (float)view2.getHeight())));
        return true;
    }
}

