package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {
    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] aux = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position pos = new Position(0,0);

        //NW
        pos.setValues(position.getRow() - 1, position.getColumn() - 1);

        while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
            pos.setValues(pos.getRow() - 1, pos.getColumn() - 1);
        }
        if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
        }

        //NE
        pos.setValues(position.getRow() - 1, position.getColumn() + 1);

        while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
            pos.setValues(pos.getRow() - 1, pos.getColumn() + 1);
        }
        if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
        }

        //SE
        pos.setValues(position.getRow() + 1, position.getColumn() + 1);

        while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
            pos.setValues(pos.getRow() + 1, pos.getColumn() + 1);
        }
        if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
        }

        //SW
        pos.setValues(position.getRow() + 1, position.getColumn() - 1);

        while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
            pos.setValues(pos.getRow() + 1, pos.getColumn() - 1);
        }
        if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
        }

        return aux;
    }
}

