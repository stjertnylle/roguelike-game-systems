public class Combat {
    Entity player, monster, winner, loser;

    public Combat(Entity player,Entity monster){
        this.player = player;
        this.monster = monster;
    }

    public Entity startCombat(){
        while (this.player.getCurrentHP() > 0 && this.monster.getCurrentHP() > 0) {
            Action playerAction = ((StandardPlayer)this.player).getAction();
            Action monsterAction = ((Monster)this.monster).getAction(this.player.getCurrentHP());
            Action fastestAction = getFastestAction(playerAction,monsterAction);
            if ( fastestAction == playerAction ) {
                playerAction.use(this.player,this.monster);
                if ( monster.getCurrentHP() > 0 )
                    monsterAction.use(this.monster,this.player);
            } else {
                monsterAction.use(this.monster,this.player);
                if ( player.getCurrentHP() > 0 )
                    playerAction.use(this.player,this.monster);
            }
        }
        if ( this.player.getCurrentHP() <= 0 ) {
            gameOver();
            loser = player;
            return winner = monster;
        } else {
            endCombat();
            loser = monster;
            return winner = player;
        }
    }

    public Action getFastestAction(Action a1,Action a2){
        if ( a1.getSpeed() < a2.getSpeed() )
            return a2;
        else return a1;
    }

    public void endCombat(){
        //TODO determine what happens when combat ends
        // + XP for player?
    }

    public void gameOver(){
        //TODO determine what happens when player dies
        // Reset player level?
        // Clear player inventory?
    }

}
