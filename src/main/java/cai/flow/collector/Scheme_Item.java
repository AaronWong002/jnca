package cai.flow.collector;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import cai.flow.struct.Scheme_Data;

public interface Scheme_Item {
	boolean equals(Object oi);

	int hashCode();

	void add(Object oi);

	int fill(PreparedStatement stm, int numi) throws SQLException;

	Scheme_Data getData();
}
