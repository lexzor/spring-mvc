package ro.ucv.inf.ead.ropharma.dto;

import javax.validation.constraints.NotBlank;

public class TypeDTO {
	private Long id;
	
	@NotBlank(message = "The name can't be empty")
	private String name;
	
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
