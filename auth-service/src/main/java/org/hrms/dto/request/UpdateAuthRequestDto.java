package org.hrms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAuthRequestDto {

    private Long id;
    private String username;
    private String password;
    private String personalEmail;
    private String taxNo;
    private String companyName;

}
