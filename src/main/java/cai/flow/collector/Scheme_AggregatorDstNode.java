package cai.flow.collector;

import java.util.Enumeration;
import java.util.Vector;

import cai.flow.packets.FlowPacket;
import cai.flow.struct.Scheme_DataNode;
import cai.sql.SQL;

public class Scheme_AggregatorDstNode extends Scheme_Aggregator {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4210550454080131175L;

	public Scheme_AggregatorDstNode(SQL sql, long interval) {
		super(sql, "DstNode", interval);
	}

	public void add(FlowPacket packet) {
		Vector v = packet.getDstNodeVector();

		if (v == null)
			return;

		for (Enumeration f = v.elements(); f.hasMoreElements();)
			add(new Scheme_ItemNode((Scheme_DataNode) f.nextElement()));
	}

}
