package controller.command.commandImpl;

import controller.command.Command;
import controller.util.constants.Pages;
import dto.Comment;
import dto.Master;
import dto.Record;
import dto.User;
import services.factory.ServiceFactory;
import services.impl.CommentService;
import services.impl.MasterService;
import services.impl.RecordService;
import services.impl.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Redirect to user page handler
 */
public class UserPageInfoCommand implements Command {
    private UserService userService;
    private CommentService commentService;
    private RecordService recordService;
    private MasterService masterService;

    public UserPageInfoCommand() {
        userService = ServiceFactory.getUserService();
        commentService = ServiceFactory.getCommentService();
        recordService = ServiceFactory.getRecordService();
        masterService = ServiceFactory.getMasterService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("currentUser");
        List<Record> recordList = recordService.getAllRecords().stream().filter(a -> {
            try {
                return a.getUser().getUserId()
                        .equals(user.getUserId()) && new java.util.Date().getTime() > Date.valueOf(a.getDate()).getTime()
                        + new SimpleDateFormat("HH:mm").parse(a.getTimeFrom()).getTime();
            } catch (ParseException e) {
                return false;
            }
        }).collect(Collectors.toList());


        Set<Long> masters = new HashSet<>();
        for (int i = 0; i < recordList.size(); i++) {
            masters.add(recordList.get(i).getMaster().getMasterId());
        }
        List<Comment> commentList = commentService.getAllComments().stream().filter(a -> a.getUser().getUserId()
                .equals(user.getUserId())).collect(Collectors.toList());

        Long masterId = null;
        boolean ifNeedComment = false;
        for (Record record : recordList) {
            if (commentService.findCommentByRecord(record.getRecordId()) == null) {
                masterId = record.getMaster().getMasterId();
                ifNeedComment = true;
                request.setAttribute("record",record);
                break;
            }
        }
        request.setAttribute("master", masterService.findById(masterId));
        request.setAttribute("ifNeedComment", ifNeedComment);
        return Pages.USER_PAGE;
    }
}
