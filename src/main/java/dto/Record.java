package dto;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class Record {
    private Long recordId;
    private User user;
    private Master master;
    private String timeFrom;
    private String date;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(recordId, record.recordId) &&
                Objects.equals(user, record.user) &&
                Objects.equals(master, record.master) &&
                Objects.equals(timeFrom, record.timeFrom) &&
                Objects.equals(date, record.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(recordId, user, master, timeFrom, date);
    }

    @Override
    public String toString() {
        return "Record{" +
                "recordId=" + recordId +
                ", user=" + user +
                ", master=" + master +
                ", timeFrom='" + timeFrom + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
