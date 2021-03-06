package javasmmr.zoowsome.services.factories.animals;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Snake;
import javasmmr.zoowsome.models.animals.Turtle;
import javasmmr.zoowsome.models.animals.Lizard;

public class ReptileFactory extends SpeciesFactory {

	public Animal getAnimal(String type) throws Exception{
		if(Constants.Animals.Reptiles.Snake.equals(type))
			return new Snake();
		else
			if(Constants.Animals.Reptiles.Turtle.equals(type))
				return new Turtle();
			else
				if(Constants.Animals.Reptiles.Lizard.equals(type))
					return new Lizard();
				else 
					throw new Exception("Invalid animal exception!");	
	}
}
