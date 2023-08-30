package com.fun90.admin.VO;

import com.fun90.admin.model.Package;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserPackageVO extends BaseEntityVO implements Serializable {


	@Transient
    Package aPackage;
	private Integer planId;
	private Date startDate;
	private Date endDate;
	private String description;
	private Integer status;

}
