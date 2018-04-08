
public class Game {
    private User user1, user2;
    private Board board1, board2;
    private int turn;

    public Game(User user1, User user2, Board board1, Board board2) {
        this.user1 = user1;
        this.user2 = user2;
        this.board1 = board1;
        this.board2 = board2;
        turn=1;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public Board getBoard1() {
        return board1;
    }

    public void setBoard1(Board board1) {
        this.board1 = board1;
    }

    public Board getBoard2() {
        return board2;
    }

    public void setBoard2(Board board2) {
        this.board2 = board2;
    }

    public int nextTurn(){
        if(turn==1) turn=2;
        else turn=1;
        return turn;
    }

    public int getTurn() {
        return turn;
    }
}
