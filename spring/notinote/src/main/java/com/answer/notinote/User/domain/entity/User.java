package com.answer.notinote.User.domain.entity;

import com.answer.notinote.auth.data.ProviderType;
import com.answer.notinote.auth.data.RoleType;
import com.answer.notinote.User.dto.UserRequestDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long uid;

    @Column(length = 20)
    private String ufirstname;

    @Column(length = 20)
    private String ulastname;

    @Column(nullable = false, length = 20, unique = true)
    private String uemail;

    @Column()
    private String ulanguage;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ProviderType uproviderType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private RoleType uroleType;

    public User(UserRequestDto requestDto) {
        this.ufirstname = requestDto.getFirstname();
        this.ulastname = requestDto.getLastname();
        this.uemail = requestDto.getEmail();
    }

    public User(com.answer.notinote.auth.data.dto.UserRequestDto requestDto) {
        this.uemail = requestDto.getEmail();
        this.uproviderType = requestDto.getProviderType();
        this.uroleType = requestDto.getRoleType();
    }

    public String getFullname() {
        return this.ufirstname + this.ulastname;
    }

    public void update(UserRequestDto requestDto) {
        this.ufirstname = requestDto.getFirstname();
        this.ulastname = requestDto.getLastname();
        this.uemail = requestDto.getEmail();
    }
}
