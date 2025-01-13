package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {
    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "Q";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] aux = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position pos = new Position(0,0);

        //Above
        pos.setValues(position.getRow() - 1, position.getColumn());

        while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
            pos.setRow(pos.getRow() - 1);
        }
        if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
        }
        //Below
        pos.setValues(position.getRow() + 1, position.getColumn());

        while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
            pos.setRow(pos.getRow() + 1);
        }
        if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
        }
        //Left
        pos.setValues(position.getRow(), position.getColumn() - 1);

        while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
            pos.setColumn(pos.getColumn() - 1);
        }
        if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
        }
        //Right
        pos.setValues(position.getRow(), position.getColumn() + 1);

        while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
            pos.setColumn(pos.getColumn() + 1);
        }
        if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
        }

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
