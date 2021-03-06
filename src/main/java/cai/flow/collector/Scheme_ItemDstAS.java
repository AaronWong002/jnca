package cai.flow.collector;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import cai.flow.struct.Scheme_Data;
import cai.flow.struct.Scheme_DataDstAS;
import cai.utils.Params;

public class Scheme_ItemDstAS implements Scheme_Item {
	Scheme_DataDstAS data;

	public Scheme_ItemDstAS(Scheme_DataDstAS data) {
		this.data = data;
	}

	public Scheme_Data getData() {
		return (Scheme_Data) data;
	}

	public boolean equals(Object oi) {
		if (oi == this)
			return true;

		Scheme_ItemDstAS o = (Scheme_ItemDstAS) oi;

		if (!data.equals(o.data))
			return false;

		if (!data.Dst_As.equals(o.data.Dst_As))
			return false;

		return true;
	}

	public String toString() {
		return "DstAS: " + data.RouterIP + " " + data.Dst_As + " " + data.dPkts
				+ " pkts, " + data.dOctets + " octets, " + data.Flows
				+ " flows";
	}

	public int hashCode() {
		return new String(data.RouterIP + data.Dst_As).hashCode();
	}

	public void add(Object o) {
		data.add(((Scheme_ItemDstAS) o).data);
	}

	public int fill(PreparedStatement stm, int numi) throws SQLException {
		int num = data.fill(stm, numi);

		stm.setString(num++, data.Dst_As);
		stm.setString(num++, Params.getCurrentTime());

		return num;
	}

}
