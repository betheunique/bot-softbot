package com.bot.softbot.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author abhishekrai
 * @since 17/01/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SlackUserProfile {

        private String first_name;
        private String last_name;
        private String real_name;
        private String email;
        private String skype;
        private String phone;

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getReal_name() {
            return real_name;
        }

        public void setReal_name(String real_name) {
            this.real_name = real_name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getSkype() {
            return skype;
        }

        public void setSkype(String skype) {
            this.skype = skype;
        }

        @Override
        public String toString() {
            return "Profile{" +
                    "first_name='" + first_name + '\'' +
                    ", last_name='" + last_name + '\'' +
                    ", real_name='" + real_name + '\'' +
                    ", email='" + email + '\'' +
                    ", skype='" + skype + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
}
