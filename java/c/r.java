/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Date
 *  java.util.List
 */
package c;

import c.a.b.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class r {
    private final String[] a;

    private r(a a2) {
        this.a = (String[])a2.a.toArray((Object[])new String[a2.a.size()]);
    }

    private r(String[] arrstring) {
        this.a = arrstring;
    }

    public static /* varargs */ r a(String ... arrstring) {
        if (arrstring == null || arrstring.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] arrstring2 = (String[])arrstring.clone();
        for (int i2 = 0; i2 < arrstring2.length; ++i2) {
            if (arrstring2[i2] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            arrstring2[i2] = arrstring2[i2].trim();
        }
        for (int i3 = 0; i3 < arrstring2.length; i3 += 2) {
            String string = arrstring2[i3];
            String string2 = arrstring2[i3 + 1];
            if (string.length() != 0 && string.indexOf(0) == -1 && string2.indexOf(0) == -1) continue;
            throw new IllegalArgumentException("Unexpected header: " + string + ": " + string2);
        }
        return new r(arrstring2);
    }

    private static String a(String[] arrstring, String string) {
        for (int i2 = -2 + arrstring.length; i2 >= 0; i2 -= 2) {
            if (!string.equalsIgnoreCase(arrstring[i2])) continue;
            return arrstring[i2 + 1];
        }
        return null;
    }

    public int a() {
        return this.a.length / 2;
    }

    public String a(int n2) {
        return this.a[n2 * 2];
    }

    public String a(String string) {
        return r.a(this.a, string);
    }

    public a b() {
        a a2 = new a();
        Collections.addAll((Collection)a2.a, (Object[])this.a);
        return a2;
    }

    public String b(int n2) {
        return this.a[1 + n2 * 2];
    }

    public Date b(String string) {
        String string2 = this.a(string);
        if (string2 != null) {
            return f.a(string2);
        }
        return null;
    }

    public List<String> c(String string) {
        int n2 = this.a();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!string.equalsIgnoreCase(this.a(i2))) continue;
            if (arrayList == null) {
                arrayList = new ArrayList(2);
            }
            arrayList.add((Object)this.b(i2));
        }
        if (arrayList != null) {
            return Collections.unmodifiableList((List)arrayList);
        }
        return Collections.emptyList();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = this.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append(this.a(i2)).append(": ").append(this.b(i2)).append("\n");
        }
        return stringBuilder.toString();
    }

    public static final class a {
        private final List<String> a = new ArrayList(20);

        private void d(String string, String string2) {
            if (string == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (string.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int n2 = string.length();
            for (int i2 = 0; i2 < n2; ++i2) {
                char c2 = string.charAt(i2);
                if (c2 > '\u001f' && c2 < '') continue;
                Object[] arrobject = new Object[]{c2, i2, string};
                throw new IllegalArgumentException(String.format((String)"Unexpected char %#04x at %d in header name: %s", (Object[])arrobject));
            }
            if (string2 == null) {
                throw new IllegalArgumentException("value == null");
            }
            int n3 = string2.length();
            for (int i3 = 0; i3 < n3; ++i3) {
                char c3 = string2.charAt(i3);
                if (c3 > '\u001f' && c3 < '') continue;
                Object[] arrobject = new Object[]{c3, i3, string, string2};
                throw new IllegalArgumentException(String.format((String)"Unexpected char %#04x at %d in %s value: %s", (Object[])arrobject));
            }
        }

        a a(String string) {
            int n2 = string.indexOf(":", 1);
            if (n2 != -1) {
                return this.b(string.substring(0, n2), string.substring(n2 + 1));
            }
            if (string.startsWith(":")) {
                return this.b("", string.substring(1));
            }
            return this.b("", string);
        }

        public a a(String string, String string2) {
            this.d(string, string2);
            return this.b(string, string2);
        }

        public r a() {
            return new r(this);
        }

        public a b(String string) {
            for (int i2 = 0; i2 < this.a.size(); i2 += 2) {
                if (!string.equalsIgnoreCase((String)this.a.get(i2))) continue;
                this.a.remove(i2);
                this.a.remove(i2);
                i2 -= 2;
            }
            return this;
        }

        a b(String string, String string2) {
            this.a.add((Object)string);
            this.a.add((Object)string2.trim());
            return this;
        }

        public a c(String string, String string2) {
            this.d(string, string2);
            this.b(string);
            this.b(string, string2);
            return this;
        }
    }

}

