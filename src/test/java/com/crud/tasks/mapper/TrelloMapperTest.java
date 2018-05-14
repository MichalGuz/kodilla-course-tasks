package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testOfTrelloMapperMethods() {
        // Given
        TrelloCard card = new TrelloCard("1", "card 1", "top", "list things to do");
        List<TrelloCard> listOfCards = new ArrayList<>();
        listOfCards.add(card);
        TrelloList list = new TrelloList("List ID", "List name", false);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(list);
        TrelloBoard board = new TrelloBoard("Board ID", "Board name", trelloLists);
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(board);

        // When
        TrelloCardDto mappedTrelloCard = trelloMapper.mapToCardDto(card);
        TrelloCard newCard = trelloMapper.mapToCard(mappedTrelloCard);
        List<TrelloBoardDto> mappdedTrelloBoard = trelloMapper.mapToBoardDto(trelloBoardList);
        List<TrelloBoard> newTrelloBoard = trelloMapper.mapToBoard(mappdedTrelloBoard);

        // Then
        System.out.println("trelloBoardList size is: " + trelloBoardList.size());
        System.out.println("mappdedTrelloBoard size is: " + mappdedTrelloBoard.size());
        System.out.println("newTrelloBoard size is: " + newTrelloBoard.size());
        Assert.assertEquals(card.getName(), newCard.getName());
        Assert.assertEquals(card.getPos(), newCard.getPos());
        Assert.assertEquals(1, mappdedTrelloBoard.size());
        Assert.assertEquals(trelloBoardList.size(), mappdedTrelloBoard.size());
    }
}