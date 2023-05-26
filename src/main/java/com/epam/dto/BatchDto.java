package com.epam.dto;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public class BatchDto {
	@Schema(accessMode = AccessMode.READ_ONLY)
	private int id;
	@NotBlank(message = "name is required")
	@Size(min=3,max=10,message="Name should contain only 3 to 10 characters")
	private String name;
	@NotBlank(message = "practice is required")
	private String practice;
	@NotBlank(message = "startDate is required")
	private Date startDate;
	@NotBlank(message = " endDate is required")
	private Date endDate;
	

}
