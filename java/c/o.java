/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.net.InetAddress
 *  java.net.UnknownHostException
 *  java.util.Arrays
 *  java.util.List
 */
package c;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public interface o {
    public static final o a = new o(){

        @Override
        public List<InetAddress> a(String string) throws UnknownHostException {
            if (string == null) {
                throw new UnknownHostException("hostname == null");
            }
            return Arrays.asList((Object[])InetAddress.getAllByName((String)string));
        }
    };

    public List<InetAddress> a(String var1) throws UnknownHostException;

}

