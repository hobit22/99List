package com.hanghea.list99.domain;


import com.hanghea.list99.dto.PlanDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Plan extends Timestamped{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long planId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int stars;

    @Column(nullable = false)
    private Boolean status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    public Plan(PlanDto.Request request, User user){
        this.title = request.getTitle();
        this.content = request.getContent();
        this.stars = request.getStars();
        this.user = user;
        this.status = false;
    }
}
