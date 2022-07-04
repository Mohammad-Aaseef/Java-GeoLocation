package learning;

import org.springframework.stereotype.Service;

@Service
public interface LearningServiceInterface {
	
		void changeGear(int a);
	    void speedUp(int a);
	    void applyBrakes(int a);

}
