package in.foodPlaza.pojo;

public class Customer {

	private int custId;
	private String custName;
	private String custEmail;
	private String custContact;
	private String custAddress;
	private String custPassword;
	private  String custConfirmpassword;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String custName, String custEmail, String custContact, String custAddress, String custPassword,
			String custConfirmpassword) {
		super();
		this.custName = custName;
		this.custEmail = custEmail;
		this.custContact = custContact;
		this.custAddress = custAddress;
		this.custPassword = custPassword;
		this.custConfirmpassword = custConfirmpassword;
	}
	public Customer(int custId, String custName, String custEmail, String custContact, String custAddress,
			String custPassword, String custConfirmpassword) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custContact = custContact;
		this.custAddress = custAddress;
		this.custPassword = custPassword;
		this.custConfirmpassword = custConfirmpassword;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustContact() {
		return custContact;
	}
	public void setCustContact(String custContact) {
		this.custContact = custContact;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustPassword() {
		return custPassword;
	}
	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}
	public String getCustConfirmpassword() {
		return custConfirmpassword;
	}
	public void setCustConfirmpassword(String custConfirmpassword) {
		custConfirmpassword = custConfirmpassword;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custEmail=" + custEmail + ", custContact="
				+ custContact + ", custAddress=" + custAddress + ", custPassword=" + custPassword
				+ ", CustConfirmpassword=" + custConfirmpassword + "]";
	}
	
	
	}


/*create  table customer_22377
-> (custid int unique not null auto_increment,
-> custname varchar(100),
-> custemail varchar(100) primary key,
-> custcontact varchar(100) unique not null,
-> custaddress varchar(100),
-> custpassword varchar(100),
-> custconfirmpassword varchar(100));
*/