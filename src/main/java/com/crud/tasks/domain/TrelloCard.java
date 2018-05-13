package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TrelloCard {

    private String id;
    private String name;
    private String pos;
    private String listId;
}
