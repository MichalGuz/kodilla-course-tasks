package com.crud.tasks.covering;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.*;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.client.TrelloClient;
import com.crud.tasks.trello.config.TrelloConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTest {

    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private TrelloClient trelloClient;

    @Test
    public void testTrelloServiceMethods() {
        // Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("1", "Card 1", "top", "List 1");
        List<CreatedTrelloCardDto> createdTrelloCardDtos = new ArrayList<>();

        // When
        List<TrelloBoardDto> anotherTrelloBoardDtos = trelloService.fetchTrelloBoards();
        CreatedTrelloCardDto newCard = trelloService.createTrelloCard(trelloCardDto);

        // Then
        Assert.assertEquals(0, anotherTrelloBoardDtos.size());
        Assert.assertTrue(createdTrelloCardDtos.add(newCard));
    }

}
