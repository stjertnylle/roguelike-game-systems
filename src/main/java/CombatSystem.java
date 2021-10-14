public class CombatSystem {
    // I think my idea is that when player engages in combat, it creates a turn.
    // After each turn it creates another turn until either player or monster reach 0 hp.
    // What I have created here is probably a turn
    // A combat should be created by the player and monster whereas each turn is probably 2 actions?

    //FIXME Instead of all these switch cases a better implementation is probably to give all actions some sort of type?
    // So e.g. we check if something is of HealingType and in that case we heal.
    // e.g. something has a mana cost and then we reduce the mana.
    // That probably makes it easier when we need to add new spells + teacher said this is not very OOP

    public CombatSystem(Player player,Monster monster){
        Action playerAction = player.getAction();
        Action monsterAction = monster.getAction(player.getHPValue());
        Action fastestAction = getFastestAction(playerAction,monsterAction);
        if ( fastestAction == playerAction ) {
            player.decreaseMana(getManaCost(playerAction));
            doDamage(playerAction, monster);
            player.increaseHP(getActionValueHealing(playerAction));
            if ( monster.getCurrentHP() <= 0 )
                endCombat();
            else{
                monster.decreaseMana(getManaCost(monsterAction));
                doDamage(monsterAction, player);
                monster.increaseHP(getActionValueHealing(monsterAction));
            }
        } else if ( fastestAction == monsterAction ) {
            monster.decreaseMana(getManaCost(monsterAction));
            doDamage(monsterAction, player);
            monster.increaseHP(getActionValueHealing(monsterAction));
            if ( player.getHPValue() <= 0 )
                gameOver();
            else{
                player.decreaseMana(getManaCost(playerAction));
                doDamage(playerAction, monster);
                player.increaseHP(getActionValueHealing(playerAction));
            }
        }
    }

    public Action getFastestAction(Action a1,Action a2){
        if ( a1.getSpeed() < a2.getSpeed() )
            return a2;
        else
            return a1;
    }

    public int getManaCost(Action action){
        switch (action.getName()) {
            case "HealingSpell":
                HealingSpell healingSpell = (HealingSpell) action;
                return healingSpell.getManaCost();
            default:
                return 0;
        }
    }

    public int getActionValueDamage(Action action){
        switch (action.getName()) {
            case "Light attack":
                LightAttack lightAttack = (LightAttack) action;
                return lightAttack.getDamage();
            case "Heavy attack":
                HeavyAttack heavyAttack = (HeavyAttack) action;
                return heavyAttack.getDamage();
            case "Life steal":
                LifeSteal lifeSteal = (LifeSteal) action;
                return lifeSteal.getDamage();
            case "Wind slash":
                WindSlash windSlash = (WindSlash) action;
                return windSlash.getDamage();
            default:
                return 0;
        }
    }

    public int getActionValueHealing(Action action){
        switch (action.getName()) {
            case "Healing spell":
                HealingSpell healingSpell = (HealingSpell) action;
                return healingSpell.getHealAmount();
            case "Life steal":
                LifeSteal lifeSteal = (LifeSteal) action;
                return lifeSteal.getDamage();
            default:
                return 0;
        }
    }

    public void doDamage(Action action, Monster monster){
        if (action instanceof Spell) {
            if ( ((Spell) action).getElement() == monster.getElement().getWeakness())
                //FIXME figure out if each monster has an element, and if not how else to implement.
                monster.decreaseHP(getActionValueDamage(action)*2);
            else monster.decreaseHP(getActionValueDamage(action));
        }
        else monster.decreaseHP(getActionValueDamage(action));
    }

    public void doDamage(Action action, Player player){
        if (action instanceof Spell) {
            if ( ((Spell) action).getElement() == player.getElement().getWeakness())
                //FIXME figure out if each monster has an element, and if not how else to implement.
                player.decreaseHP(getActionValueDamage(action)*2);
            else player.decreaseHP(getActionValueDamage(action));
        }
        else player.decreaseHP(getActionValueDamage(action));
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
