package com.answer.notinote.Notice.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class Notice {
    @Id
    @Column(name="nid")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment 가능
    private Long nid;

    @Column
    private String nimagename;
    private String nimageoriginal;
    private String nimageurl;

    @Column(length=5000)
    private String origin_full;
    @Column(length=5000)
    private String trans_full;
    @Column(length=3000)
    private String trans_sum;

    @Column
    private boolean registered;
    @Column
    private boolean highlight;
    
    private LocalDate ndate;

    //Not Using Constructor
    @Builder
    public Notice (String nimagename, String nimageoriginal, String nimageurl, String origin_full, String trans_full, String trans_sum, LocalDate ndate, Boolean registered, Boolean highlight){
        this.nimagename = nimagename;
        this.nimageoriginal = nimageoriginal;
        this.nimageurl = nimageurl;
        this.origin_full = origin_full;
        this.trans_full = trans_full;
        this.trans_sum = trans_sum;
        this.ndate = ndate;
        this.registered = false;
        this.highlight = false;
    }


    public void update_origin_full(String origin_full){
        this.origin_full = origin_full;
    }

    public void update_trans_full(String trans_full){
        this.trans_full = trans_full;
    }

    public void update_trans_sum(String trans_sum){
        this.trans_sum = trans_sum;
    }

    public void update_highlight(Boolean highlight){
        this.highlight = highlight;
    }
}
