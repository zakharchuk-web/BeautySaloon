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
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Return records for chosen date
 */
public class GetRecordsForDateCommand implements Command {
    private RecordService recordService;
    private MasterService masterService;

    public GetRecordsForDateCommand() {
        recordService = ServiceFactory.getRecordService();
        masterService = ServiceFactory.getMasterService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("masterEmail");
        request.setAttribute("date", request.getParameter("chosenDate"));
        request.setAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        request.setAttribute("master", masterService.findByEmail(email));


        List<Record> records = recordService.findByMasterAndDate(masterService.findByEmail(email).getMasterId(),
                request.getParameter("chosenDate"));

        Collections.sort(records, (a, b) -> {
            if (Integer.valueOf(a.getTimeFrom().split(":")[0]) > Integer.valueOf(b.getTimeFrom().split(":")[0]))
                return 1;
            else return -1;
        });
        List<Record> recordsList = new ArrayList<>(9);
        System.out.println(records);
        for (int i = 0, j = 0; i < 9; i++) {
            if (j != records.size() && records.get(j).getTimeFrom().equals("" + (i + 9) + ":00")) {
                recordsList.add(records.get(j++));
            } else recordsList.add(null);
        }

        request.setAttribute("records", recordsList);
        return Pages.RECORD_PAGE;
    }
}
