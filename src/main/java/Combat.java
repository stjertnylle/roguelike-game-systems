public class Combat {
    Entity player;
    Entity monster;

    public Combat(Entity player,Entity monster){
        this.player = player;
        this.monster = monster;
    }

    public Entity startCombat(){
        while (this.player.getCurrentHP() > 0 && this.monster.getCurrentHP() > 0) {
            Action playerAction = ((Player) this.player).getAction();
            Action monsterAction = ((Monster) this.monster).getAction(this.player.getHealthRatio());
            Action fastestAction = getFastestAction(playerAction,monsterAction);
            applyActions(playerAction,monsterAction,fastestAction);
        }
        return endCombat();
    }

    private Entity endCombat(){
        if ( this.player.getCurrentHP() <= 0 ) {
            gameOver((Player)this.player);
            return this.monster;
        } else {
            rewardPlayerXP((Player) this.player,(Monster) this.monster);
            return this.player;
        }
    }

    private void applyActions(Action playerAction,Action monsterAction,Action fastestAction){
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

    private Action getFastestAction(Action a1,Action a2){
        if ( a1.getSpeed() < a2.getSpeed() )
            return a2;
        else return a1;
    }

    private void rewardPlayerXP(Player winner,Monster loser){
        winner.increaseXP((loser.getExpReward()));
    }

    private void gameOver(Player player){
        player.getLevel().setCurrentLevel(1);
        player.getPlayerInventory().clearInventory();
        player.getPotionInventory().clearPotionInventory();
    }

}
