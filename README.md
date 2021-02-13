# ChessGameRepository
Basic Chess Game

TODO
### Pawn double square start

### En Passant
	If pawn moves two squares on first move, set enPassable to true. 
	If any other piece moves next, check other players pawns for enPassable and set false
	If moving a pawn check for enpassable pawns next to it
	If enPassant capture, remove icon from the other square

Castling
	Cannot castle unless king not in check and squares between rook not being attacked
	if king first move and rook first move both true, can castle
	move king two squares towards Rook, move Rook next to king
	Mark Player as castled

### Pawn promotion

Check
	If king is on any of the other players pieces possible moves squares
	Change king to inCheck
	If king in check, must either move king or block check
	If king trying to castle and one of the two squares is a possiblemove for the other players pieces, cannot castle

CheckMate
	if king in check, can't move and no blocking moves available, checkmate and gameOver

Stalemate

King unable to move next to other king

Track time for each player

Show time for each player on scorepanel

Track captures for each player

Show captures on scorepanel

New game

Flip board

Undo move

Computer AI

