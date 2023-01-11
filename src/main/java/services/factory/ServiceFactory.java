package services.factory;

import dto.ServicePrice;
import services.impl.*;

/**
 * Class for getting instances of services.
 */
public class ServiceFactory {
    static private UserService userService;
    static private MasterService masterService;
    static private RecordService recordService;
    static private CommentService commentService;
    static private PriceService priceService;

    static {
        userService = new UserService();
        masterService = new MasterService();
        recordService = new RecordService();
        commentService = new CommentService();
        priceService = new PriceService();
    }

    public static PriceService getPriceService() {
        return priceService;
    }

    public static UserService getUserService() {
        return userService;
    }

    public static MasterService getMasterService() {
        return masterService;
    }

    public static RecordService getRecordService() {
        return recordService;
    }

    public static CommentService getCommentService() {
        return commentService;
    }
}

