import java.util.Random;

/**
 * Created by chigichan24 on 2017/07/03.
 */
public class Solver {

    private class Player{
        private int y,x;
        Player(int y,int  x){
            this.y = y;
            this.x = x;
        }
        void move(String way){
            if(way.equals("Up")){
                this.y++;
            }
            else if(way.equals("Down")){
                this.y--;
            }
            else if(way.equals("Right")){
                this.x++;
            }
            else if(way.equals("Left")) {
                this.x--;
            }
        }
    }

    private static final int challenges     = 10;
    private static final int stageHeight    = 10;
    private static final int stageWidth     = 10;

    private enum stageState{
        CLEAR(0),
        PLAYER_A(1),
        PLAYER_B(2),
        BLOCK(3),
        CLOSED_BLOCK(4);

        private final int id;

        private stageState(final int id){
            this.id =  id;
        }

        public int getId(){
            return id;
        }
    }

    private int stage[][] = new int[stageHeight][stageWidth];

    public Solver(){
        initialStage();
    }

    public void initialStage(){

        for(int i = 0; i < stageHeight; ++i){
            for(int j = 0; j < stageWidth; ++j){
                stage[i][j] = stageState.CLEAR.getId();
            }
        }

        Random rnd = new Random();
        for(int i = 0 ; i < challenges; ++i){
            int h = rnd.nextInt(stageHeight - 2)+1;
            int w = rnd.nextInt(stageWidth - 2) +1;
            stage[h][w] = stageState.BLOCK.getId();
        }
        stage[0][0]                         = stageState.PLAYER_A.getId();
        stage[stageHeight-1][stageWidth-1]  = stageState.PLAYER_B.getId();

        for(int i = 0 ; i < stageHeight; ++i){
            for (int j = 0 ; j < stageWidth; ++j){
                System.out.print(stage[i][j]);
            }
            System.out.println();
        }

    }

}
