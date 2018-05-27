package fr.training.spring.shop.domain.customer;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class CustomerVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String password;

	public CustomerVO(@NotNull String name, @NotNull String password) {
		this.name = name;
		this.password = password;
	}

	public CustomerVO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(@NotNull String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(@NotNull String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerVO other = (CustomerVO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

}
