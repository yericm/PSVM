package com.bywin.dto;

import lombok.Data;

@Data
public class KefuSeatDTO {
	/**
	 * 政策ID
	 */
	private Integer policyId;

	/**
	 * 组类型
	 */
	private Integer groupType;

	/**
	 * 部门ID
	 */
	private String deptId;

	/**
	 * 1:工单,2:坐席
	 */
	private Integer type = 2;

	private String name;
	public KefuSeatDTO () {}

	public KefuSeatDTO(Integer policyId, Integer groupType, Integer type, String name) {
		this.policyId = policyId;
		this.groupType = groupType;
		this.type = type;
		this.name = name;
	}
}
