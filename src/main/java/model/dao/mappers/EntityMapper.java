package model.dao.mappers;

import java.sql.ResultSet;

@FunctionalInterface
public interface EntityMapper<T> {
    T map(ResultSet resultSet);
}
