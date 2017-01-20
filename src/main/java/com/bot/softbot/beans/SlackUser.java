package com.bot.softbot.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author abhishekrai
 * @since 17/01/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SlackUser {
    private String id;
    private String name;
    private boolean deleted;
    private String color;
    private SlackUserProfile profile;
    private boolean is_admin;
    private boolean is_primary_owner;
    private boolean is_restricted;
    private boolean is_ultra_restricted;
    private boolean has_2fa;
    private String two_factor_type;
    private String presence;
    private String status;
    private String real_name;
    private String tz;
    private String tz_label;
    private int tz_offset;

    public int getTz_offset() {
        return tz_offset;
    }

    public void setTz_offset(int tz_offset) {
        this.tz_offset = tz_offset;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getTz_label() {
        return tz_label;
    }

    public void setTz_label(String tz_label) {
        this.tz_label = tz_label;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SlackUserProfile getProfile() {
        return profile;
    }

    public void setProfile(SlackUserProfile profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTwo_factor_type() {
        return two_factor_type;
    }

    public void setTwo_factor_type(String two_factor_type) {
        this.two_factor_type = two_factor_type;
    }

    public boolean is_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public boolean is_primary_owner() {
        return is_primary_owner;
    }

    public void setIs_primary_owner(boolean is_primary_owner) {
        this.is_primary_owner = is_primary_owner;
    }

    public boolean is_restricted() {
        return is_restricted;
    }

    public void setIs_restricted(boolean is_restricted) {
        this.is_restricted = is_restricted;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean is_ultra_restricted() {
        return is_ultra_restricted;
    }

    public void setIs_ultra_restricted(boolean is_ultra_restricted) {
        this.is_ultra_restricted = is_ultra_restricted;
    }

    public boolean isHas_2fa() {
        return has_2fa;
    }

    public void setHas_2fa(boolean has_2fa) {
        this.has_2fa = has_2fa;
    }

    public String getPresence() {
        return presence;
    }

    public void setPresence(String presence) {
        this.presence = presence;
    }

    @Override
    public String toString() {
        return "SlackUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", deleted=" + deleted +
                ", color='" + color + '\'' +
                ", profile=" + profile +
                ", is_admin=" + is_admin +
                ", is_primary_owner=" + is_primary_owner +
                ", is_restricted=" + is_restricted +
                ", is_ultra_restricted=" + is_ultra_restricted +
                ", has_2fa=" + has_2fa +
                ", two_factor_type='" + two_factor_type + '\'' +
                ", presence='" + presence + '\'' +
                ", status='" + status + '\'' +
                ", real_name='" + real_name + '\'' +
                ", tz='" + tz + '\'' +
                ", tz_label='" + tz_label + '\'' +
                ", tz_offset=" + tz_offset +
                '}';
    }
}
