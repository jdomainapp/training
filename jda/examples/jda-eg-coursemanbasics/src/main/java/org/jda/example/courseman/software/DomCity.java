package org.jda.example.courseman.software;

import org.jda.example.courseman.services.student.model.City;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;
import jda.modules.common.exceptions.DataSourceException;
import jda.modules.common.exceptions.NotImplementedException;
import jda.mosa.software.SoftwareFactory;
import jda.mosa.software.impl.DomSoftware;
import jda.software.ddd.MicroDomSoftware;

/**
 * @overview 
 *
 * @author Duc Minh Le (ducmle)
 *
 * @version 
 */
public class DomCity extends MicroDomSoftware<City>{
  
  private static Logger logger = (Logger) LoggerFactory.getLogger(DomCity.class.getSimpleName());

  public static void main(String[] args) {
    DomSoftware sw = SoftwareFactory.createDefaultDomSoftware();
    
    // this should be run subsequent times
    sw.init();
    
    try {
      new DomCity(sw).run();
    } catch (DataSourceException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @Override
  public DomCity run() throws DataSourceException {
    return (DomCity) initDom()
    .loadAndDisplay()
    .create()
    .displaySource();
  }
  
  /**
   * @effects 
   *
   * @version 
   */
  public DomCity(DomSoftware sw) {
    super(sw, City.class);
  }

  @Override
  public DomCity create() throws DataSourceException {
    // create some objects
    City obj = new
//        City(6, "Hoa Binh");
//          City(5, "Thai Nguyen");
//        City(4, "Hue");
//          City(3, "Danang");
//          City(2, "HCM");
        City(1, "Hanoi");
        getSw().addObject(City.class, obj);  
        
    return this;
  }
  
  @Override
  protected void doUpdate(City obj, Object id) throws DataSourceException {
    throw new NotImplementedException("Not implemented");
  }
}
