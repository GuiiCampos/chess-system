package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
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

        //Specialmove castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            //special move castling kingside rook
            Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(posT1)) {
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);

                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    aux[position.getRow()][position.getColumn() + 2] = true;

                }
            }

            //special move castling queenside rook
            Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(posT2)) {
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);

                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                    aux[position.getRow()][position.getColumn() - 2] = true;

                }
            }
        }

        return aux;
    }
}
