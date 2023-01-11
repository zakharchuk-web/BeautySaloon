package controller.command.commandImpl;

import controller.command.Command;
import controller.util.constants.Pages;
import dto.Record;
import dto.User;
import services.factory.ServiceFactory;
import services.impl.MasterService;
import services.impl.RecordService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Record creation handler
 * Allows add records
 */
public class CreateRecordCommand implements Command {
    private RecordService recordService;
    private MasterService masterService;

    public CreateRecordCommand() {
        recordService = ServiceFactory.getRecordService();
        masterService = ServiceFactory.getMasterService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("currentUser");
        String date = request.getParameter("chosenDate");
        String timeFrom = request.getParameter("timeFrom");
        Record record = new Record();
        record.setDate(date);
        record.setTimeFrom(timeFrom);
        record.setMaster(masterService.findByEmail(request.getParameter("masterEmail")));
        record.setUser(user);
        List<Record> recordList = recordService.getAllRecords();
        if (recordList.stream().filter(a -> a.getTimeFrom().equals(timeFrom) && a.getDate().equals(date) && a.getMaster().getMasterId()
                .equals(masterService.findByEmail(request.getParameter("masterEmail")).getMasterId())).collect(Collectors.toList()).size() == 0 && !recordList.contains(record))
            recordService.add(record);
        return Pages.MAIN_PAGE;
    }
}
