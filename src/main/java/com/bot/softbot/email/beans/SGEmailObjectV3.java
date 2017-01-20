package com.bot.softbot.email.beans;

import java.util.Arrays;
import java.util.Map;

/**
 * @author abhishekrai
 * @since 20/12/2016
 */
public class SGEmailObjectV3 {

    private EmailPersonalizations[] personalizations;
    private From from;
    private ReplyTo reply_to;
    private String subject;
    private Content[] content;
    private Attachments[] attachments;
    private String template_id;
    private Map<String, String> sections;
    private Map<String, String> headers;
    private String[] categories;
    private Map<String, String> custom_args;
    private int send_at;
    private String batch_id;
    private String ip_pool_name;
    private ASM asm;
    private MailSetting mail_settings;
    private TrackingSettings tracking_settings;

    public static class From {
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

    public static class ReplyTo {
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

    public static class Content {
        private String type;
        private String value;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "type='" + type + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public static class Attachments {
        private String content;
        private String type;
        private String filename;
        private String disposition;
        private String content_id;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getDisposition() {
            return disposition;
        }

        public void setDisposition(String disposition) {
            this.disposition = disposition;
        }

        public String getContent_id() {
            return content_id;
        }

        public void setContent_id(String content_id) {
            this.content_id = content_id;
        }

        @Override
        public String toString() {
            return "Attachments{" +
                    "content='" + content + '\'' +
                    ", type='" + type + '\'' +
                    ", filename='" + filename + '\'' +
                    ", disposition='" + disposition + '\'' +
                    ", content_id='" + content_id + '\'' +
                    '}';
        }
    }

    public static class ASM {
        private int group_id;
        private int[] groups_to_display;

        public int getGroup_id() {
            return group_id;
        }

        public void setGroup_id(int group_id) {
            this.group_id = group_id;
        }

        public int[] getGroups_to_display() {
            return groups_to_display;
        }

        public void setGroups_to_display(int[] groups_to_display) {
            this.groups_to_display = groups_to_display;
        }

        @Override
        public String toString() {
            return "ASM{" +
                    "group_id=" + group_id +
                    ", groups_to_display=" + Arrays.toString(groups_to_display) +
                    '}';
        }
    }

    public static class MailSetting {
        private Bcc bcc;
        private BypassListManagement bypass_list_management;
        private Footer footer;
        private SpamCheck spam_check;
        private SandboxMode sandbox_mode;

        public static class Bcc {
            private boolean enable;
            private String email;

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }

            @Override
            public String toString() {
                return "Bcc{" +
                        "enable=" + enable +
                        ", email='" + email + '\'' +
                        '}';
            }
        }

        public static class BypassListManagement {
            private boolean enable;

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }
        }

        public static class Footer {
            private boolean enable;
            private String text;
            private String html;

            public String getHtml() {
                return html;
            }

            public void setHtml(String html) {
                this.html = html;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }
        }

        public static class SpamCheck {
            private boolean enable;
            private int threshold;
            private String post_to_url;

            public int getThreshold() {
                return threshold;
            }

            public void setThreshold(int threshold) {
                this.threshold = threshold;
            }

            public String getPost_to_url() {
                return post_to_url;
            }

            public void setPost_to_url(String post_to_url) {
                this.post_to_url = post_to_url;
            }

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }
        }

        public static class SandboxMode {
            private boolean enable;

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }
        }

        public Bcc getBcc() {
            return bcc;
        }

        public void setBcc(Bcc bcc) {
            this.bcc = bcc;
        }

        public BypassListManagement getBypass_list_management() {
            return bypass_list_management;
        }

        public void setBypass_list_management(BypassListManagement bypass_list_management) {
            this.bypass_list_management = bypass_list_management;
        }

        public Footer getFooter() {
            return footer;
        }

        public void setFooter(Footer footer) {
            this.footer = footer;
        }

        public SandboxMode getSandbox_mode() {
            return sandbox_mode;
        }

        public void setSandbox_mode(SandboxMode sandbox_mode) {
            this.sandbox_mode = sandbox_mode;
        }

        public SpamCheck getSpam_check() {
            return spam_check;
        }

        public void setSpam_check(SpamCheck spam_check) {
            this.spam_check = spam_check;
        }
    }

    public static class TrackingSettings {
        private ClickTracking click_tracking;
        private OpenTracking open_tracking;
        private SubscriptionTracking subscription_tracking;
        private Ganalytics ganalytics;

        public static class ClickTracking {
            private boolean enable;
            private boolean enable_text;

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }

            public boolean isEnable_text() {
                return enable_text;
            }

            public void setEnable_text(boolean enable_text) {
                this.enable_text = enable_text;
            }
        }

        public static class OpenTracking {
            private boolean enable;
            private String substitution_tag;

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }

            public String getSubstitution_tag() {
                return substitution_tag;
            }

            public void setSubstitution_tag(String substitution_tag) {
                this.substitution_tag = substitution_tag;
            }
        }

        public static class SubscriptionTracking {
            private boolean enable;
            private String text;
            private String html;
            private String substitution_tag;

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getHtml() {
                return html;
            }

            public void setHtml(String html) {
                this.html = html;
            }

            public String getSubstitution_tag() {
                return substitution_tag;
            }

            public void setSubstitution_tag(String substitution_tag) {
                this.substitution_tag = substitution_tag;
            }
        }

        public static class Ganalytics {
            private boolean enable;
            private String utm_source;
            private String utm_medium;
            private String utm_term;
            private String utm_content;
            private String utm_campaign;

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }

            public String getUtm_campaign() {
                return utm_campaign;
            }

            public void setUtm_campaign(String utm_campaign) {
                this.utm_campaign = utm_campaign;
            }

            public String getUtm_content() {
                return utm_content;
            }

            public void setUtm_content(String utm_content) {
                this.utm_content = utm_content;
            }

            public String getUtm_medium() {
                return utm_medium;
            }

            public void setUtm_medium(String utm_medium) {
                this.utm_medium = utm_medium;
            }

            public String getUtm_source() {
                return utm_source;
            }

            public void setUtm_source(String utm_source) {
                this.utm_source = utm_source;
            }

            public String getUtm_term() {
                return utm_term;
            }

            public void setUtm_term(String utm_term) {
                this.utm_term = utm_term;
            }
        }

        public ClickTracking getClick_tracking() {
            return click_tracking;
        }

        public void setClick_tracking(ClickTracking click_tracking) {
            this.click_tracking = click_tracking;
        }

        public Ganalytics getGanalytics() {
            return ganalytics;
        }

        public void setGanalytics(Ganalytics ganalytics) {
            this.ganalytics = ganalytics;
        }

        public OpenTracking getOpen_tracking() {
            return open_tracking;
        }

        public void setOpen_tracking(OpenTracking open_tracking) {
            this.open_tracking = open_tracking;
        }

        public SubscriptionTracking getSubscription_tracking() {
            return subscription_tracking;
        }

        public void setSubscription_tracking(SubscriptionTracking subscription_tracking) {
            this.subscription_tracking = subscription_tracking;
        }
    }

    public EmailPersonalizations[] getPersonalizations() {
        return personalizations;
    }

    public void setPersonalizations(EmailPersonalizations[] personalizations) {
        this.personalizations = personalizations;
    }

    public ASM getAsm() {
        return asm;
    }

    public void setAsm(ASM asm) {
        this.asm = asm;
    }

    public Attachments[] getAttachments() {
        return attachments;
    }

    public void setAttachments(Attachments[] attachments) {
        this.attachments = attachments;
    }

    public Content[] getContent() {
        return content;
    }

    public void setContent(Content[] content) {
        this.content = content;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public int getSend_at() {
        return send_at;
    }

    public void setSend_at(int send_at) {
        this.send_at = send_at;
    }

    public MailSetting getMail_settings() {
        return mail_settings;
    }

    public void setMail_settings(MailSetting mail_settings) {
        this.mail_settings = mail_settings;
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

    public Map<String, String> getSections() {
        return sections;
    }

    public void setSections(Map<String, String> sections) {
        this.sections = sections;
    }

    public ReplyTo getReply_to() {
        return reply_to;
    }

    public void setReply_to(ReplyTo reply_to) {
        this.reply_to = reply_to;
    }

    public String getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public String getIp_pool_name() {
        return ip_pool_name;
    }

    public void setIp_pool_name(String ip_pool_name) {
        this.ip_pool_name = ip_pool_name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public TrackingSettings getTracking_settings() {
        return tracking_settings;
    }

    public void setTracking_settings(TrackingSettings tracking_settings) {
        this.tracking_settings = tracking_settings;
    }
}

