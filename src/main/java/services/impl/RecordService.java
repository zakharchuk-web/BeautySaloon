package services.impl;

import dto.Record;
import model.dao.daoInterfaces.RecordDao;
import model.dao.factory.JdbcDaoFactory;

import java.util.List;

public class RecordService {
    private RecordDao dao;

    public RecordService() {
        dao = JdbcDaoFactory.getInstance().getRecordDao();
    }

    public List<Record> findByMasterAndDate(Long id, String date) {
        return dao.getRecordsByDateAndMaster(id, date);
    }

    public void add(Record record) {
        dao.add(record);
    }

    public Record findRecordById(Long id) {
        return dao.find(id);
    }

    public List<Record> getAllRecords() {
        return dao.findAll();
    }
}
