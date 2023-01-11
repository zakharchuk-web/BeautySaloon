package dto;

import java.util.Objects;

public class Master extends User {
    private Long masterId;
    private Level level;
    private String phoneNumber;
    private String description;

    public Long getMasterId() {
        return masterId;
    }

    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Master master = (Master) o;
        return Objects.equals(masterId, master.masterId) &&
                level == master.level &&
                Objects.equals(phoneNumber, master.phoneNumber) &&
                Objects.equals(description, master.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), masterId, level, phoneNumber, description);
    }

    @Override
    public String toString() {
        return "Master{" +
                "masterId=" + masterId +
                ", level=" + level +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }
}
