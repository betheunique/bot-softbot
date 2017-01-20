package com.bot.softbot.email.beans;

import java.util.Arrays;
import java.util.Map;

/**
 * @author abhishekrai
 * @since 20/12/2016
 */
public class EmailPersonalizations {

    private To[] to;
    private Cc[] cc;
    private Bcc[] bcc;
    private Map<String, String> substitutions;
    private String subject;
    private Map<String, String> headers;
    private Map<String, String> custom_args;
    private int send_at;

    public To[] getTo() {
        return to;
    }

    public void setTo(To[] to) {
        this.to = to;
    }

    public Cc[] getCc() {
        return cc;
    }

    public void setCc(Cc[] cc) {
        this.cc = cc;
    }

    public Bcc[] getBcc() {
        return bcc;
    }

    public void setBcc(Bcc[] bcc) {
        this.bcc = bcc;
    }

    public Map<String, String> getSubstitutions() {
        return substitutions;
    }

    public void setSubstitutions(Map<String, String> substitutions) {
        this.substitutions = substitutions;
    }

    public Map<String, String> getCustom_args() {
        return custom_args;
    }

    public void setCustom_args(Map<String, String> custom_args) {
        this.custom_args = custom_args;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getSend_at() {
        return send_at;
    }

    public void setSend_at(int send_at) {
        this.send_at = send_at;
    }

    public static class To {
        private String email;
        private String name;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "To{" +
                    "email='" + email + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static class Cc {
        private String email;
        private String name;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Cc{" +
                    "email='" + email + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static class Bcc {
        private String email;
        private String name;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Bcc{" +
                    "email='" + email + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "EmailPersonalizations{" +
                "to=" + Arrays.toString(to) +
                ", cc=" + Arrays.toString(cc) +
                ", bcc=" + Arrays.toString(bcc) +
                ", substitutions=" + substitutions +
                ", subject='" + subject + '\'' +
                ", headers=" + headers +
                ", custom_args=" + custom_args +
                ", send_at=" + send_at +
                '}';
    }
}
