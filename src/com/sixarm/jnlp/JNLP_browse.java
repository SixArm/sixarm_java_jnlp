package com.sixarm.jnlp;

import com.sixarm.java.lang.*;
import java.net.*;
import javax.jnlp.*;

/**
 * JNLP_browse: $on(URL) wrap com.sixarm.jnlp.JNLP#browse
 *                                                                            
 * @see com.sixarm.net.JNLP#browse
 * @see javax.jnlp.BasicService                             
 */
public class JNLP_browse implements $on<URL> {

  JNLP jnlp = null;

  public JNLP_browse(JNLP jnlp) {
    if (null == jnlp) {
      throw new XArg("jnlp", jnlp);
    }
    this.jnlp = jnlp;
  }

  public void on(URL to) {
    assert null != jnlp;
    try {
      jnlp.browse(to);
    } catch (UnavailableServiceException ex) {
      throw new RuntimeException(ex);
    }
  }
}
