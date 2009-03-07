/*
 * deadend.roles.DogTeam
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.roles.DogTeam is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.roles.DogTeam is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.roles;

import java.util.ArrayList;

import deadend.game.DeadEndGame;
import deadend.game.GameConfigClass;
import deadend.ai.*;
import deadend.ai.dog.DogTeamBrain;


/**
 * This class controls the dogs' intelligence
 * Two dog could work individually or cooperately
 *
 * @author Yang JiaJian
 */
public class DogTeam {
    public ArrayList<Dog> dogTeam;

    // TODO add fields DogTeamBrain
    DeadEndGame game;

    // Strategy
    private StrategyInterface strategy;

    private DogTeamBrain brain;

    public DogTeam(DeadEndGame game) {
        this.game=game;
    }

    // TODO add initialize logic
    public void initialize(){
        this.dogTeam=new ArrayList<Dog>();
        int dogLimit=GameConfigClass.NumberOfDogs;
        for(int i=1;i<=dogLimit;i++){
            Dog d=new Dog(this.game);
            d.initialize();
            this.dogTeam.add(d);
        }
        
    }

    // TODO add compute logic
    public void compute(){
        
    }
    // TODO add reset logic
    public void reset(){
        for(Dog d:this.dogTeam){
            d.bornAtHome();
        }
    }

    public StrategyInterface getStrategy() {
        return strategy;
    }

    public void setStrategy(StrategyInterface strategy) {
        this.strategy = strategy;
    }

}
