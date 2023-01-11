package creator;

import dto.*;
import dto.Record;
import model.dao.daoInterfaces.CommentDao;
import model.dao.daoInterfaces.MasterDao;
import model.dao.daoInterfaces.RecordDao;
import model.dao.daoInterfaces.UserDao;
import model.dao.factory.DaoFactory;
import model.dao.factory.JdbcDaoFactory;

public class EntityCreator {
    private static UserDao userDao;
    private static MasterDao masterDao;
    private static CommentDao commentDao;
    private static RecordDao recordDao;
    private static int counter = 0;

    static {
        DaoFactory daoFactory = JdbcDaoFactory.getInstance();
        userDao = daoFactory.getUserDao();
        masterDao = daoFactory.getMasterDao();
        commentDao = daoFactory.getCommentDao();
        recordDao = daoFactory.getRecordDao();
    }

    public static User createUser() {
        User user = new User();
        user.setFirstName("Rick");
        user.setLastName("Tomson");
        user.setEmail("asdff" + (counter++) + "@mail.ru");
        user.setPassword("secretPass");
        user.setRole(Role.USER);
        return user;
    }

    public static Master createMaster() {
        Master master = new Master();
        master.setPhoneNumber("+38 (097) 123 23 23");
        master.setDescription("Some description");
        master.setLevel(Level.MASTER);
        master.setUserId(200L);
        master.setFirstName("Nick");
        master.setEmail("Romson");
        master.setEmail("qwe@mail.ru");
        master.setPassword("secretPass");
        master.setRole(Role.MASTER);
        return master;
    }

    public static Comment createComment() {
        Comment comment = new Comment();
        comment.setComment("Some text");
        User user = new User();
        user.setUserId(15L);
        Master master = new Master();
        master.setMasterId(3L);
        Record record = new Record();
        record.setRecordId(1L);
        comment.setUser(user);
        comment.setMaster(master);
        comment.setRecord(record);
        return comment;
    }

    public static Record createRecord() {
        Record record = new Record();
        User user = new User();
        user.setUserId(15L);
        Master master = new Master();
        master.setMasterId(3L);
        record.setUser(user);
        record.setMaster(master);
        record.setTimeFrom("10:00");
        record.setDate("2018-01-24");
        return record;
    }

    public static ServicePrice createSetvicePrice() {
        ServicePrice servicePrice = new ServicePrice();
        servicePrice.setServicePrice(100L);
        servicePrice.setServiceName("Some name");
        return servicePrice;
    }
}
