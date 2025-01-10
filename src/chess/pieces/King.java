package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] aux = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position pos = new Position(0,0);

        //Above
        pos.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(pos) && canMove(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
        }
        //Below
        pos.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(pos) && canMove(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
        }
        //Left
        pos.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(pos) && canMove(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
        }
        //Right
        pos.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(pos) && canMove(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
        }

        //NW
        pos.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(pos) && canMove(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
        }
        //NE
        pos.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(pos) && canMove(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
        }
        //SW
        pos.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(pos) && canMove(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
        }
        //SE
        pos.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(pos) && canMove(pos)) {
            aux[pos.getRow()][pos.getColumn()] = true;
        }

        return aux;
    }
}
