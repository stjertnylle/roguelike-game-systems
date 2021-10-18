public class Combat {
    Entity player, monster, winner, loser;

    public Combat(Entity player,Entity monster){
        this.player = player;
        this.monster = monster;
    }

    public Entity startCombat(){
        while (this.player.getCurrentHP() > 0 && this.monster.getCurrentHP() > 0) {
            Action playerAction = ((Player) this.player).getAction();
            Action monsterAction = ((Monster) this.monster).getAction(this.player.getHealthRatio());
            Action fastestAction = getFastestAction(playerAction,monsterAction);
            if ( fastestAction == playerAction ) {
                playerAction.apply(this.monster);
                if ( this.monster.getCurrentHP() > 0 )
                    monsterAction.apply(this.player);
            } else {
                monsterAction.apply(this.player);
                if ( this.player.getCurrentHP() > 0 )
                    playerAction.apply(this.monster);
            }
        }
        if ( this.player.getCurrentHP() <= 0 ) {
            gameOver((Player)player);
            loser = this.player;
            return winner = this.monster;
        } else {
            loser = this.monster;
            endCombat((Player) this.player,(Monster) this.loser);
            return winner = this.player;
        }
    }

    public Action getFastestAction(Action a1,Action a2){
        if ( a1.getSpeed() < a2.getSpeed() )
            return a2;
        else return a1;
    }

    public void endCombat(Player winner,Monster loser){
        winner.increaseXP((loser.getExpReward()));
    }


    public void gameOver(Player player){
        //TODO clear player inventory
        player.getLevel().setCurrentLevel(1);
    }

}
