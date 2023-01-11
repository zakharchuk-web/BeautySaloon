package dto;

import java.util.Objects;

public class Comment {
    private Long commentId;
    private String comment;
    private User user;
    private Master master;
    private Record record;

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return Objects.equals(commentId, comment1.commentId) &&
                Objects.equals(comment, comment1.comment) &&
                Objects.equals(user, comment1.user) &&
                Objects.equals(master, comment1.master);
    }

    @Override
    public int hashCode() {

        return Objects.hash(commentId, comment, user, master);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", comment='" + comment + '\'' +
                ", user=" + user +
                ", master=" + master +
                ", record=" + record +
                '}';
    }
}
