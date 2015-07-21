package models;

import java.util.ArrayList;
import java.util.List;

import specification.IMediator;
import models.AbstractMediator;
import specification.IPartyGoer;

/**
 * 
 * @author btdiem
 *
 */

public class Mediator extends AbstractMediator implements IMediator{


	@Override
	public List<IPartyGoer> findTranslator(IPartyGoer person1, IPartyGoer person2) {
		// TODO Auto-generated method stub
		
		if (person1.languagesInCommon(person2) != null){
			return null;
		}else{
			List<IPartyGoer> translators = new ArrayList<IPartyGoer>();
			for (IPartyGoer translator : listPartyGoer){
				if (!translator.getName().equals(person1.getName()) 
						&& !translator.getName().equals(person2.getName())){
					
					Languages[] common1 = translator.languagesInCommon(person1);
					Languages[] common2 = translator.languagesInCommon(person2);
					if (common1 != null  && common2 != null ){
						translators.add(translator);
					}
					
				}//if
			}//for
			return translators;
		}

		
		
	}

}
