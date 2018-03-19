package com.crm.client.company;

public class CRM_company {
	private Integer id;
	private Integer CRM_user_master_id;
	private String company_name;

	public CRM_company() {
	}

	public CRM_company(Integer id, Integer crmUserMasterId, String companyName) {
		this.id = new Integer(id);
		this.CRM_user_master_id = new Integer(crmUserMasterId);
		this.company_name = new String(companyName);
	}

	public CRM_company(Integer crmUserMasterId, String companyName) {
		this.CRM_user_master_id = new Integer(crmUserMasterId);
		this.company_name = new String(companyName);
	}

	public String toString() {
		return "CRM_Company{" + "ID=" + this.id + "," + "UserMasterID=" + this.CRM_user_master_id + "," + "CompanyName="
				+ this.company_name + '}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCRM_user_master_id() {
		return CRM_user_master_id;
	}

	public void setCRM_user_master_id(Integer cRM_user_master_id) {
		CRM_user_master_id = cRM_user_master_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

}
