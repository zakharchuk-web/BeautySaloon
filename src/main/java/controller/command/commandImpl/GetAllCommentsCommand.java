package controller.command.commandImpl;

import controller.command.Command;
import controller.util.constants.Pages;
import dto.Comment;
import services.factory.ServiceFactory;
import services.impl.CommentService;
import services.impl.MasterService;
import services.impl.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Return all comments for page with comments
 */
public class GetAllCommentsCommand implements Command {
    private CommentService commentService;
    private MasterService masterService;
    private UserService userService;

    public GetAllCommentsCommand() {
        commentService = ServiceFactory.getCommentService();
        masterService = ServiceFactory.getMasterService();
        userService = ServiceFactory.getUserService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Comment> commentList = commentService.getAllComments();
        for (Comment comment : commentList) {
            comment.setMaster(masterService.findById(comment.getMaster().getMasterId()));
            comment.setUser(userService.findById(comment.getUser().getUserId()));
        }
        request.setAttribute("comments", commentList);
        return Pages.COMMENT_LIST;
    }
}
