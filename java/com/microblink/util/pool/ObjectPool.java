/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.microblink.util.pool;

import com.microblink.util.pool.PoolObject;
import com.microblink.util.pool.PoolObjectFactory;

public class ObjectPool {
    protected final int MAX_FREE_OBJECT_INDEX;
    private PoolObjectFactory mFactory;
    private int mFreeObjectIndex = -1;
    private PoolObject[] mFreeObjects;

    public ObjectPool(PoolObjectFactory poolObjectFactory, int n2) {
        this.mFactory = poolObjectFactory;
        this.mFreeObjects = new PoolObject[n2];
        this.MAX_FREE_OBJECT_INDEX = n2 - 1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void freeObject(PoolObject poolObject) {
        ObjectPool objectPool = this;
        synchronized (objectPool) {
            if (poolObject != null) {
                poolObject.finalizePoolObject();
                if (this.mFreeObjectIndex < this.MAX_FREE_OBJECT_INDEX) {
                    this.mFreeObjectIndex = 1 + this.mFreeObjectIndex;
                    this.mFreeObjects[this.mFreeObjectIndex] = poolObject;
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public PoolObject newObject() {
        ObjectPool objectPool = this;
        synchronized (objectPool) {
            PoolObject poolObject;
            if (this.mFreeObjectIndex == -1) {
                poolObject = this.mFactory.createPoolObject();
            } else {
                poolObject = this.mFreeObjects[this.mFreeObjectIndex];
                this.mFreeObjectIndex = -1 + this.mFreeObjectIndex;
            }
            poolObject.initializePoolObject();
            return poolObject;
        }
    }
}

