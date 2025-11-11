package com.arciuch.backend.factory;

import com.arciuch.backend.model.Board;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
public class BoardFactory {
    public Board createBoard(int width, int height) {
        val board = Board.builder().width(width).height(height).build();
        board.boardConfig();
        return board;
    }
}
