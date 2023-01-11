package model.dao.daoImpl;

import dto.Record;
import model.dao.daoImpl.template.GenericJdbcDao;
import model.dao.daoInterfaces.RecordDao;
import model.dao.jdbc.ConnectionManager;
import model.dao.mappers.RecordMapper;

import java.util.List;
import java.util.stream.Collectors;

public class RecordJdbcDao implements RecordDao {
    ConnectionManager cm;
    GenericJdbcDao genericJdbcDao;

    public RecordJdbcDao() {
        this.cm = ConnectionManager.getInstance();
        genericJdbcDao = new GenericJdbcDao(cm);
    }

    @Override
    public Long add(Record record) {
        return genericJdbcDao.insert("INSERT INTO record " +
                        "(user_id," +
                        "master_id," +
                        "time_from," +
                        "date)" +
                        "VALUES(?,?,?,?)",
                record.getUser().getUserId(),
                record.getMaster().getMasterId(),
                record.getTimeFrom(),
                record.getDate());
    }

    @Override
    public Record find(Long id) {
        return genericJdbcDao.findObject("SELECT * FROM record JOIN user ON user.iduser=record.user_id WHERE idrecord=?", RecordMapper::map, id);
    }

    @Override
    public void update(Record record) {
        genericJdbcDao.update("UPDATE record " +
                        "SET " +
                        "user_id=?, " +
                        "master_id=?, " +
                        "time_form=?, " +
                        "date=?, " +
                        "WHERE idrecord=?",
                record.getUser().getUserId(),
                record.getMaster().getMasterId(),
                record.getTimeFrom(),
                record.getDate(),
                record.getRecordId());
    }

    @Override
    public void delete(Long id) {
        genericJdbcDao.remove("DELETE FROM record WHERE idrecod=?", id);
    }

    @Override
    public List<Record> getRecordsByDateAndMaster(Long masterId, String date) {
        List<Record> records = findAll();
        List<Record> result = records.stream().filter(a -> a.getDate().equals(date) && a.getMaster().getMasterId()
                .equals(masterId)).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<Record> findAll() {
        return genericJdbcDao.findAll("SELECT * FROM record JOIN user ON user.iduser=record.user_id", RecordMapper::map);
    }
}
