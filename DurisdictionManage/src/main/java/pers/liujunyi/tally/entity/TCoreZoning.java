package pers.liujunyi.tally.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * TCoreZoning entity.
 * @Description 区划管理
 * @author liujunyi
 * @date 2016-09-20 11:39
 */
@Entity
@Table(name="T_CORE_ZONING")
public class TCoreZoning implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/*主键ID*/
	private String id;
	/*区划代码*/
	private String zoningCode;
	/*父ID*/
	private String parentId;
	/*区划名称*/
	private String name;
	/*简称*/
	private String shortName;
	/*经度*/
	private float longitude;
	/*纬度*/
	private float latitudelatitude;
	/*区划等级*/
	private Integer level;
	/*顺序*/
	private Integer sort;
	/*状态*/
	private Integer status;
	/*邮编*/
	private Integer postCode;


	/**default constructor*/
	public TCoreZoning(){}

	/** full constructor */
	/**主键ID,区划代码,父ID,区划名称,简称,经度,纬度,区划等级,顺序,状态,邮编**/
	public TCoreZoning(String id,String zoningCode,String parentId,String name,String shortName,float longitude,
		float latitudelatitude,Integer level,Integer sort,Integer status,Integer postCode){
		super();
		this.id = id;
		this.zoningCode = zoningCode;
		this.parentId = parentId;
		this.name = name;
		this.shortName = shortName;
		this.longitude = longitude;
		this.latitudelatitude = latitudelatitude;
		this.level = level;
		this.sort = sort;
		this.status = status;
		this.postCode = postCode;
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

	/** zoningCode get、set方法**/
	@Column(name = "ZONING_CODE", length = 32, nullable = true)
	public String getZoningCode(){
		return zoningCode;
	}
	public void setZoningCode(String zoningCode){
		this.zoningCode = zoningCode != null ? zoningCode.trim() : zoningCode;
	}

	/** parentId get、set方法**/
	@Column(name = "PARENT_ID", length = 32, nullable = true)
	public String getParentId(){
		return parentId;
	}
	public void setParentId(String parentId){
		this.parentId = parentId != null ? parentId.trim() : parentId;
	}

	/** name get、set方法**/
	@Column(name = "NAME", length = 50, nullable = true)
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name != null ? name.trim() : name;
	}

	/** shortName get、set方法**/
	@Column(name = "SHORT_NAME", length = 30, nullable = true)
	public String getShortName(){
		return shortName;
	}
	public void setShortName(String shortName){
		this.shortName = shortName != null ? shortName.trim() : shortName;
	}

	/** longitude get、set方法**/
	@Column(name = "LONGITUDE", nullable = true)
	public float getLongitude(){
		return longitude;
	}
	public void setLongitude(float longitude){
		this.longitude = longitude;
	}

	/** latitudelatitude get、set方法**/
	@Column(name = "LATITUDELATITUDE", nullable = true)
	public float getLatitudelatitude(){
		return latitudelatitude;
	}
	public void setLatitudelatitude(float latitudelatitude){
		this.latitudelatitude = latitudelatitude;
	}

	/** level get、set方法**/
	@Column(name = "LEVEL", nullable = true)
	public Integer getLevel(){
		return level;
	}
	public void setLevel(Integer level){
		this.level = level;
	}

	/** sort get、set方法**/
	@Column(name = "SORT", nullable = true)
	public Integer getSort(){
		return sort;
	}
	public void setSort(Integer sort){
		this.sort = sort;
	}

	/** status get、set方法**/
	@Column(name = "STATUS", nullable = true)
	public Integer getStatus(){
		return status;
	}
	public void setStatus(Integer status){
		this.status = status;
	}

	/** postCode get、set方法**/
	@Column(name = "POST_CODE", nullable = true)
	public Integer getPostCode(){
		return postCode;
	}
	public void setPostCode(Integer postCode){
		this.postCode = postCode;
	}


}
