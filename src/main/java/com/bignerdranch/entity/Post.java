package com.bignerdranch.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {


    Integer userId;

    @Id
    @GeneratedValue
    Integer id;

    String title;
    String body;

}
