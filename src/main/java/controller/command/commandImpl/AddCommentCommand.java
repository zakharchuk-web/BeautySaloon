package controller.command.commandImpl;

import controller.command.Command;
import controller.util.constants.Pages;
import dto.Comment;
import dto.Master;
import dto.Record;
import dto.User;
import services.factory.ServiceFactory;
import services.impl.CommentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Comment adding handler
 * Allows user add a comment
 */
public class AddCommentCommand implements Command {
    private CommentService commentService;

    public AddCommentCommand() {
        commentService = ServiceFactory.getCommentService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Comment comment = new Comment();
        Master master = new Master();
        master.setMasterId(Long.valueOf(request.getParameter("masterId")));
        Record record = new Record();
        record.setRecordId(Long.valueOf( request.getParameter("recordId")));
        comment.setUser((User) request.getSession().getAttribute("currentUser"));
        comment.setMaster(master);
        comment.setRecord(record);
        comment.setComment(request.getParameter("comment"));

        commentService.addComment(comment);
        return Pages.USER_PAGE;
    }
}
