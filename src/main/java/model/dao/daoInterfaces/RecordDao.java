package model.dao.daoInterfaces;

import dto.Master;
import dto.Record;

import java.util.Date;
import java.util.List;

public interface RecordDao extends Dao<Record, Long> {
    public List<Record> getRecordsByDateAndMaster(Long masterId, String date);
}
