package com.crud.tasks.covering;

import com.crud.tasks.domain.AttachmentsByType;
import com.crud.tasks.domain.BadgesDto;
import com.crud.tasks.domain.Trello;
import com.crud.tasks.trello.config.TrelloConfig;
import org.junit.Assert;
import org.junit.Test;

public class VariousTests {

    @Test
    public void testTrelloMethods() {
        // Given
        Trello trello = new Trello(1, 1);

        // When
        int board = trello.getBoard();
        int card = trello.getCard();

        // Then
        Assert.assertEquals(1, board);
        Assert.assertEquals(1, card);
    }

    @Test
    public void testAttachmentsByTypeMethod() {
        // Given
        Trello trello = new Trello(1, 1);
        AttachmentsByType attachments = new AttachmentsByType(trello);

        // When
        Trello trello1 = attachments.getTrello();

        // Then
        Assert.assertEquals(trello.getBoard(), trello1.getBoard());
        Assert.assertEquals(trello.getCard(), trello1.getCard());
    }

    @Test
    public void testBadgesDtoMethods() {
        // Given
        Trello trello = new Trello(2, 2);
        AttachmentsByType attachments = new AttachmentsByType(trello);
        BadgesDto badgesDto = new BadgesDto(1, attachments);

        // When
        int votes = badgesDto.getVotes();
        AttachmentsByType attachments1 = badgesDto.getAttachments();

        // Then
        Assert.assertEquals(1, votes);
        Assert.assertEquals(attachments1, attachments);
    }

    @Test
    public void testTrelloConfigMethods() {
        // Given
        TrelloConfig trelloConfig = new TrelloConfig();

        // When
        String t1 = trelloConfig.getTrelloApiEndpoint();
        String t2 = trelloConfig.getTrelloAppKey();
        String t3 = trelloConfig.getTrelloToken();
        String t4 = trelloConfig.getTrelloUsername();

        // Then
        Assert.assertEquals(null, t1);
        Assert.assertEquals(null, t2);
        Assert.assertEquals(null, t3);
        Assert.assertEquals(null, t4);
    }

}
