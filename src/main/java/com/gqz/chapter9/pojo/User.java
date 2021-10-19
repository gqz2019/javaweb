package com.gqz.chapter9.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private long id;
    private String username;
    private String password;
    private String address;
    private String nickname;
    private String gender="女";
    private String email;

}
