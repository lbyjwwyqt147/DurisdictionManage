package pers.liujunyi.tally.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * TCoreMyAccount entity.
 * @Description 我的帐户（绑定其他账户）
 * @author liujunyi
 * @date 2016-09-20 11:39
 */
@Entity
@Table(name="T_CORE_MY_ACCOUNT")
public class TCoreMyAccount implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/*主键ID*/
	private String id;
	/*用户ID*/
	private String userId;
	/*绑定的账户*/
	private String userAccount;
	/*账户类型*/
	private String accountType;
	/*账户等级*/
	private Integer accountLevel;
	/*账户积分*/
	private float accountIntegral;
	/*是否激活*/
	private String isActivate;
	/*删除标志*/
	private String deleteFlag;
	/*创建时间*/
	private String createDate;


	/**default constructor*/
	public TCoreMyAccount(){}

	/** full constructor */
	/**主键ID,用户ID,绑定的账户,账户类型,账户等级,账户积分,是否激活,删除标志,创建时间**/
	public TCoreMyAccount(String id,String userId,String userAccount,String accountType,Integer accountLevel,float accountIntegral,
		String isActivate,String deleteFlag,String createDate){
		super();
		this.id = id;
		this.userId = userId;
		this.userAccount = userAccount;
		this.accountType = accountType;
		this.accountLevel = accountLevel;
		this.accountIntegral = accountIntegral;
		this.isActivate = isActivate;
		this.deleteFlag = deleteFlag;
		this.createDate = createDate;
	}
	
	/** id get、set方法**/
	@Id
	@Column(name = "ID", length = 32)
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id != null ? id.trim() : id;
	}

	/** userId get、set方法**/
	@Column(name = "USER_ID", length = 32, nullable = true)
	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId = userId != null ? userId.trim() : userId;
	}

	/** userAccount get、set方法**/
	@Column(name = "USER_ACCOUNT", length = 32, nullable = true)
	public String getUserAccount(){
		return userAccount;
	}
	public void setUserAccount(String userAccount){
		this.userAccount = userAccount != null ? userAccount.trim() : userAccount;
	}

	/** accountType get、set方法**/
	@Column(name = "ACCOUNT_TYPE", length = 4, nullable = true)
	public String getAccountType(){
		return accountType;
	}
	public void setAccountType(String accountType){
		this.accountType = accountType != null ? accountType.trim() : accountType;
	}

	/** accountLevel get、set方法**/
	@Column(name = "ACCOUNT_LEVEL", nullable = true)
	public Integer getAccountLevel(){
		return accountLevel;
	}
	public void setAccountLevel(Integer accountLevel){
		this.accountLevel = accountLevel;
	}

	/** accountIntegral get、set方法**/
	@Column(name = "ACCOUNT_INTEGRAL", nullable = true)
	public float getAccountIntegral(){
		return accountIntegral;
	}
	public void setAccountIntegral(float accountIntegral){
		this.accountIntegral = accountIntegral;
	}

	/** isActivate get、set方法**/
	@Column(name = "IS_ACTIVATE", length = 4, nullable = true)
	public String getIsActivate(){
		return isActivate;
	}
	public void setIsActivate(String isActivate){
		this.isActivate = isActivate != null ? isActivate.trim() : isActivate;
	}

	/** deleteFlag get、set方法**/
	@Column(name = "DELETE_FLAG", length = 4, nullable = true)
	public String getDeleteFlag(){
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag){
		this.deleteFlag = deleteFlag != null ? deleteFlag.trim() : deleteFlag;
	}

	/** createDate get、set方法**/
	@Column(name = "CREATE_DATE", length = 19, nullable = true)
	public String getCreateDate(){
		return createDate;
	}
	public void setCreateDate(String createDate){
		this.createDate = createDate != null ? createDate.trim() : createDate;
	}


}
