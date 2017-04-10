/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Type
 *  java.sql.Date
 *  java.sql.Timestamp
 *  java.text.DateFormat
 *  java.text.ParseException
 *  java.text.ParsePosition
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.Locale
 */
package com.google.a;

import com.google.a.j;
import com.google.a.k;
import com.google.a.l;
import com.google.a.p;
import com.google.a.q;
import com.google.a.r;
import com.google.a.s;
import com.google.a.t;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

final class a
implements k<Date>,
s<Date> {
    private final DateFormat a;
    private final DateFormat b;

    a() {
        this(DateFormat.getDateTimeInstance((int)2, (int)2, (Locale)Locale.US), DateFormat.getDateTimeInstance((int)2, (int)2));
    }

    public a(int n2, int n3) {
        this(DateFormat.getDateTimeInstance((int)n2, (int)n3, (Locale)Locale.US), DateFormat.getDateTimeInstance((int)n2, (int)n3));
    }

    a(String string) {
        this((DateFormat)new SimpleDateFormat(string, Locale.US), (DateFormat)new SimpleDateFormat(string));
    }

    a(DateFormat dateFormat, DateFormat dateFormat2) {
        this.a = dateFormat;
        this.b = dateFormat2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Date a(l l2) {
        DateFormat dateFormat;
        DateFormat dateFormat2 = dateFormat = this.b;
        synchronized (dateFormat2) {
            try {
                return this.b.parse(l2.b());
            }
            catch (ParseException var4_5) {
                try {
                    return this.a.parse(l2.b());
                }
                catch (ParseException var5_7) {
                    try {
                        return com.google.a.b.a.a.a.a(l2.b(), new ParsePosition(0));
                    }
                    catch (ParseException var6_9) {
                        throw new t(l2.b(), (Throwable)var6_9);
                    }
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public l a(Date date, Type type, r r2) {
        DateFormat dateFormat;
        DateFormat dateFormat2 = dateFormat = this.b;
        synchronized (dateFormat2) {
            return new q(this.a.format(date));
        }
    }

    public Date a(l l2, Type type, j j2) throws p {
        if (!(l2 instanceof q)) {
            throw new p("The date should be a string value");
        }
        Date date = this.a(l2);
        if (type == Date.class) {
            return date;
        }
        if (type == Timestamp.class) {
            return new Timestamp(date.getTime());
        }
        if (type == java.sql.Date.class) {
            return new java.sql.Date(date.getTime());
        }
        throw new IllegalArgumentException((Object)this.getClass() + " cannot deserialize to " + (Object)type);
    }

    @Override
    public /* synthetic */ Object deserialize(l l2, Type type, j j2) throws p {
        return this.a(l2, type, j2);
    }

    @Override
    public /* synthetic */ l serialize(Object object, Type type, r r2) {
        return this.a((Date)object, type, r2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.class.getSimpleName());
        stringBuilder.append('(').append(this.b.getClass().getSimpleName()).append(')');
        return stringBuilder.toString();
    }
}

