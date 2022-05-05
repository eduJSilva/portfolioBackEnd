/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.portfolio.EduSilva.model.authapp.payload;

import com.portfolio.EduSilva.validation.annotation.MatchPassword;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@MatchPassword
@ApiModel(value = "Password reset Request", description = "The password reset request payload")
public class PasswordResetRequest {

    @NotBlank(message = "The email for which the password needs to be reset can not be empty")
    @ApiModelProperty(value = "The user email", required = true, allowableValues = "NonEmpty String")
    private String email;

    @NotBlank(message = "New password cannot be blank")
    @ApiModelProperty(value = "New user password", required = true, allowableValues = "NonEmpty String")
    private String password;

    @NotBlank(message = "Confirm Password cannot be blank")
    @ApiModelProperty(value = "Must match the new user password. Else exception will be thrown", required = true,
            allowableValues = "NonEmpty String matching the password")
    private String confirmPassword;

    @NotBlank(message = "Password reset token for the specified email has to be supplied")
    @ApiModelProperty(value = "Reset token received in mail", required = true, allowableValues = "NonEmpty String")
    private String token;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
