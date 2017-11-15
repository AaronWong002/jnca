package cai.flow.collector;

import java.util.Enumeration;
import java.util.Vector;

import cai.flow.packets.FlowPacket;
import cai.flow.struct.Scheme_DataInterface;
import cai.sql.SQL;

public class Scheme_AggregatorDstInterface extends Scheme_Aggregator {
	/**
	 * 
	 */
	private static final long serialVersionUID = -770427626329575448L;

	public Scheme_AggregatorDstInterface(SQL sql, long interval) {
		super(sql, "DstInterface", interval);
	}

	public void add(FlowPacket packet) {
		Vector v = packet.getDstInterfaceVector();

		if (v == null)
			return;

		for (Enumeration f = v.elements(); f.hasMoreElements();)
			add(new Scheme_ItemInterface((Scheme_DataInterface) f.nextElement()));
	}

}
