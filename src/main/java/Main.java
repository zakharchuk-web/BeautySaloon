import dto.*;
import model.dao.daoImpl.CommentJdbcDao;
import model.dao.daoImpl.MasterJdbcDao;
import model.dao.daoImpl.RecordJdbcDao;
import model.dao.daoImpl.ServicePriceJdbcDao;
import model.dao.daoInterfaces.RecordDao;
import model.dao.jdbc.ConnectionManager;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Main {
    public static void main(String[] args) {
        ConnectionManager.initFromProperties();

        ServicePriceJdbcDao dao = new ServicePriceJdbcDao();
        /*ServicePrice servicePrice = new ServicePrice();
        System.out.println(dao.findAll());*/
        /*Comment comment = new Comment();
        User user=new User();
        user.setUserId(15L);
        Master master=new Master();
        master.setMasterId(3L);
        Record record=new Record();
        record.setRecordId(1L);
        comment.setRecord(record);
        comment.setMaster(master);
        comment.setUser(user);
        comment.setComment("SOme text");
        dao.add(comment);*/

        //System.out.println(dao.findAll());
/*

        System.out.println(java.sql.Date.valueOf("2018-01-24").getTime() > java.sql.Date.valueOf("2018-01-23").getTime());
        Date date = new Date(java.sql.Date.valueOf("2018-01-24").getTime());

        java.sql.Date.valueOf("2018-01-24").getTime() + new SimpleDateFormat("HH:mm").parse("10:00");

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date date1 = sdf.parse("10:00");
            Date date2 = sdf.parse("11:00");
            System.out.println(date1.getTime() > date2.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
*/

    }
}
