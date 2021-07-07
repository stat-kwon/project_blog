package com.prject.myblog.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.regex.Pattern;


@Setter
@Getter
public class SignupRequestDto {

    @NotBlank
    @Length(min = 3, message = "최소 3자 이상 입력하세요.")
    private String username;

    @NotBlank
    @Length(min = 4, message = "최소 4자 이상 입력하세요.")
    private String password;

    @NotBlank
    @Email
    private String email;

    public void isValidUsername() {
        String rex = "^(?=.*\\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{3,20}$";
        if (!Pattern.matches(rex, username)) {
            throw new IllegalArgumentException("닉네임은 알파벳 대소문자 숫자로 구성되야 합니다.");
        }
    }

    public void isSameUsernamePassword() {
        if (username.equals(password)){
            throw new IllegalArgumentException("닉네임과 패스워드가 일치합니다.");
        }
    }

}