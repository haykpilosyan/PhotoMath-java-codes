/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.SharedPreferences
 *  android.database.DatabaseErrorHandler
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  java.io.File
 *  java.lang.String
 */
package b.a.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

class d
extends ContextWrapper {
    private final String a;
    private final String b;

    public d(Context context, String string, String string2) {
        super(context);
        this.b = string;
        this.a = string2;
    }

    public File getCacheDir() {
        return new File(super.getCacheDir(), this.a);
    }

    public File getDatabasePath(String string) {
        File file = new File(super.getDatabasePath(string).getParentFile(), this.a);
        file.mkdirs();
        return new File(file, string);
    }

    @TargetApi(value=8)
    public File getExternalCacheDir() {
        return new File(super.getExternalCacheDir(), this.a);
    }

    @TargetApi(value=8)
    public File getExternalFilesDir(String string) {
        return new File(super.getExternalFilesDir(string), this.a);
    }

    public File getFilesDir() {
        return new File(super.getFilesDir(), this.a);
    }

    public SharedPreferences getSharedPreferences(String string, int n2) {
        return super.getSharedPreferences(this.b + ":" + string, n2);
    }

    public SQLiteDatabase openOrCreateDatabase(String string, int n2, SQLiteDatabase.CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase((File)this.getDatabasePath(string), (SQLiteDatabase.CursorFactory)cursorFactory);
    }

    @TargetApi(value=11)
    public SQLiteDatabase openOrCreateDatabase(String string, int n2, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openOrCreateDatabase((String)this.getDatabasePath(string).getPath(), (SQLiteDatabase.CursorFactory)cursorFactory, (DatabaseErrorHandler)databaseErrorHandler);
    }
}

