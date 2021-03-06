package hu.schonherz.homework.order.vo;

import java.io.Serializable;

public class UserVo implements Serializable {

	private static final long serialVersionUID = 5282108759829130028L;
	private Long id;
	private String name;

	public UserVo() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserVo [id=" + id + ", name=" + name + "]";
	}

}
