package cai.flow.collector;

import java.util.Enumeration;
import java.util.Vector;

import cai.flow.packets.FlowPacket;
import cai.flow.struct.Scheme_DataProtocol;
import cai.sql.SQL;

public class Scheme_AggregatorProtocol extends Scheme_Aggregator {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2504483711313062173L;

	public Scheme_AggregatorProtocol(SQL sql, long interval) {
		super(sql, "Protocol", interval);
	}

	public void add(FlowPacket packet) {
		Vector v = packet.getProtocolVector();

		if (v == null)
			return;

		for (Enumeration f = v.elements(); f.hasMoreElements();)
			add(new Scheme_ItemProtocol((Scheme_DataProtocol) f.nextElement()));
	}

}
