package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 将ResultSet转换成List的接口
 * @author LiZanhong
 *
 * @param <E>
 */
public interface Mapper<E> {
	public List<E> map(ResultSet rs) throws SQLException;
}