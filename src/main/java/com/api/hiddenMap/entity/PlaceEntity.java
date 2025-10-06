package com.api.hiddenMap.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="place")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name;
    private String description;

    private String province;
    private String district;

    @Column(name = "sub_district")
    private String subDistrict;

    @ManyToOne
    private CategoryEntity category;

    @ManyToOne
    private UserEntity user;

    @Column(name = "create_dt",updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @PrePersist
    protected  void onCreate(){
        this.createdAt = LocalDateTime.now();
    }

    @PrePersist
    protected  void onUpdate(){
         this.updateAt = LocalDateTime.now();
    }
}
