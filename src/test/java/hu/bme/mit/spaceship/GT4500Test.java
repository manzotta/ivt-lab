package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;

  TorpedoStore primaryTs;
  TorpedoStore secondaryTs;  

  @BeforeEach
  public void init(){
    this.primaryTs = mock(TorpedoStore.class);
    this.secondaryTs = mock(TorpedoStore.class);

    this.ship = new GT4500(primaryTs, secondaryTs);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(primaryTs.isEmpty()).thenReturn(false); 
    when(primaryTs.fire(1)).thenReturn(true);
    
    when(secondaryTs.isEmpty()).thenReturn(false); 
    when(secondaryTs.fire(1)).thenReturn(true);


    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(primaryTs.isEmpty()).thenReturn(false); 
    // when(primaryTs.getTorpedoCount()).thenReturn(10);        
    when(primaryTs.fire(primaryTs.getTorpedoCount())).thenReturn(true);
    
    when(secondaryTs.isEmpty()).thenReturn(false); 
    //when(primaryTs.getTorpedoCount()).thenReturn(15);        
    when(secondaryTs.fire(secondaryTs.getTorpedoCount())).thenReturn(true);

    
    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
  }

}
