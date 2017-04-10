/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package b.a.a.a.a.g;

import b.a.a.a.a.g.b;
import b.a.a.a.a.g.c;
import b.a.a.a.a.g.e;
import b.a.a.a.a.g.f;
import b.a.a.a.a.g.m;
import b.a.a.a.a.g.o;
import b.a.a.a.a.g.p;
import b.a.a.a.a.g.t;
import b.a.a.a.a.g.u;
import b.a.a.a.a.g.v;
import org.json.JSONException;
import org.json.JSONObject;

class k
implements v {
    k() {
    }

    private long a(b.a.a.a.a.b.k k2, long l2, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("expires_at")) {
            return jSONObject.getLong("expires_at");
        }
        return k2.a() + 1000 * l2;
    }

    private e a(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("identifier");
        String string2 = jSONObject.getString("status");
        String string3 = jSONObject.getString("url");
        String string4 = jSONObject.getString("reports_url");
        boolean bl = jSONObject.optBoolean("update_required", false);
        boolean bl2 = jSONObject.has("icon");
        c c2 = null;
        if (bl2) {
            boolean bl3 = jSONObject.getJSONObject("icon").has("hash");
            c2 = null;
            if (bl3) {
                c2 = this.b(jSONObject.getJSONObject("icon"));
            }
        }
        return new e(string, string2, string3, string4, bl, c2);
    }

    private c b(JSONObject jSONObject) throws JSONException {
        return new c(jSONObject.getString("hash"), jSONObject.getInt("width"), jSONObject.getInt("height"));
    }

    private m c(JSONObject jSONObject) {
        return new m(jSONObject.optBoolean("prompt_enabled", false), jSONObject.optBoolean("collect_logged_exceptions", true), jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_analytics", false));
    }

    private b d(JSONObject jSONObject) {
        return new b(jSONObject.optString("url", "https://e.crashlytics.com/spi/v2/events"), jSONObject.optInt("flush_interval_secs", 600), jSONObject.optInt("max_byte_size_per_file", 8000), jSONObject.optInt("max_file_count_per_send", 1), jSONObject.optInt("max_pending_send_file_count", 100), jSONObject.optBoolean("track_custom_events", true), jSONObject.optBoolean("track_predefined_events", true), jSONObject.optInt("sampling_rate", 1), jSONObject.optBoolean("flush_on_background", true));
    }

    private p e(JSONObject jSONObject) throws JSONException {
        return new p(jSONObject.optInt("log_buffer_size", 64000), jSONObject.optInt("max_chained_exception_depth", 8), jSONObject.optInt("max_custom_exception_events", 64), jSONObject.optInt("max_custom_key_value_pairs", 64), jSONObject.optInt("identifier_mask", 255), jSONObject.optBoolean("send_session_without_crash", false), jSONObject.optInt("max_complete_sessions_count", 4));
    }

    private o f(JSONObject jSONObject) throws JSONException {
        return new o(jSONObject.optString("title", "Send Crash Report?"), jSONObject.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject.optString("send_button_title", "Send"), jSONObject.optBoolean("show_cancel_button", true), jSONObject.optString("cancel_button_title", "Don't Send"), jSONObject.optBoolean("show_always_send_button", true), jSONObject.optString("always_send_button_title", "Always Send"));
    }

    private f g(JSONObject jSONObject) throws JSONException {
        return new f(jSONObject.optString("update_endpoint", u.a), jSONObject.optInt("update_suspend_duration", 3600));
    }

    @Override
    public t a(b.a.a.a.a.b.k k2, JSONObject jSONObject) throws JSONException {
        int n2 = jSONObject.optInt("settings_version", 0);
        int n3 = jSONObject.optInt("cache_duration", 3600);
        e e2 = this.a(jSONObject.getJSONObject("app"));
        p p2 = this.e(jSONObject.getJSONObject("session"));
        o o2 = this.f(jSONObject.getJSONObject("prompt"));
        m m2 = this.c(jSONObject.getJSONObject("features"));
        b b2 = this.d(jSONObject.getJSONObject("analytics"));
        f f2 = this.g(jSONObject.getJSONObject("beta"));
        return new t(this.a(k2, n3, jSONObject), e2, p2, o2, m2, b2, f2, n2, n3);
    }
}

