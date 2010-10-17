package com.sixarm.java.jnlp;
import com.sixarm.java.lang.*;
import static com.sixarm.java.lang.K.SUCCESS;
import static com.sixarm.java.lang.K.FAILURE;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import javax.jnlp.*;

/**
 * JNLP: loads all the JNLP services
 */

public class JNLP {

 public static transient BasicService               amBasicService;
 public static transient ClipboardService           amClipboardService;
 public static transient DownloadService            amDownloadService;
 public static transient FileOpenService            amFileOpenService;
 public static transient FileSaveService            amFileSaveService;
 public static transient PersistenceService         amPersistenceService;
 public static transient PrintService               amPrintService;


 /**
  * New: load all the JNLP services.
  * <ul>
  * <li>BasicService
  * <li>ClipBoardService
  * <li>Service
  * <li>DownloadService
  * <li>FileOpenService
  * <li>FileSaveService
  * <li>PersistenceService
  * <li>PrintService
  * </ul>
  * @throws UnavailableServiceException if any of its subparts throws it.
  */
 public JNLP() throws UnavailableServiceException{
  String s=null;
  s="javax.jnlp.BasicService";               amBasicService                = (BasicService)                ServiceManager.lookup(s);
  s="javax.jnlp.ClipboardService";           amClipboardService            = (ClipboardService)            ServiceManager.lookup(s);
  s="javax.jnlp.DownloadService";            amDownloadService             = (DownloadService)             ServiceManager.lookup(s);
  s="javax.jnlp.FileOpenService";            amFileOpenService             = (FileOpenService)             ServiceManager.lookup(s);
  s="javax.jnlp.FileSaveService";            amFileSaveService             = (FileSaveService)             ServiceManager.lookup(s);
  s="javax.jnlp.PersistenceService";         amPersistenceService          = (PersistenceService)          ServiceManager.lookup(s);
  s="javax.jnlp.PrintService";               amPrintService                = (PrintService)                ServiceManager.lookup(s);
 }


 //=
 // OK: your classes can use these for your assertions
 //=

 public boolean okBasicService()               throws UnavailableServiceException{ if(null==amBasicService           ){throw new UnavailableServiceException("JNLP BasicService is null");}               return true;}
 public boolean okClipboardService()           throws UnavailableServiceException{ if(null==amClipboardService       ){throw new UnavailableServiceException("JNLP ClipboardService is null");}           return true;}
 public boolean okDownloadService()            throws UnavailableServiceException{ if(null==amDownloadService        ){throw new UnavailableServiceException("JNLP DownloadService is null");}            return true;}
 public boolean okFileOpenService()            throws UnavailableServiceException{ if(null==amFileOpenService        ){throw new UnavailableServiceException("JNLP FileOpenService is null");}            return true;}
 public boolean okFileSaveService()            throws UnavailableServiceException{ if(null==amFileSaveService        ){throw new UnavailableServiceException("JNLP FileSaveService is null");}            return true;}
 public boolean okPersistenceService()         throws UnavailableServiceException{ if(null==amPersistenceService     ){throw new UnavailableServiceException("JNLP PersistenceService is null");}         return true;}
 public boolean okPrintService()               throws UnavailableServiceException{ if(null==amPrintService           ){throw new UnavailableServiceException("JNLP PrintService is null");}               return true;}


 /**
  * browse: show a web page using the JNLP BasicService
  *
  * @param url the url to browse
  * @return true if the web page is loaded, false if BasicService is not initialized, or there isn't a web browser supported, or the user is offline
  * @throws UnavailableServiceException
  * @see javax.jnlp.BasicService#isWebBrowserSupported
  * @see javax.jnlp.BasicService#isOffline
  */
 public @AsSuccess boolean browse(java.net.URL url) throws UnavailableServiceException{
  if(null==amBasicService){throw new UnavailableServiceException("JNLP BasicService is null");}
  if(amBasicService.isWebBrowserSupported() && !amBasicService.isOffline()){
    amBasicService.showDocument(url);
    return SUCCESS;
  }
  return FAILURE;
 }


 /**
  * to_in: get a file's input stream
  * @param fc file contents
  * @return the file contents as a stream
  * @throws IOException if the file contents are not usabl
  * @see javax.jnlp.FileContents#getInputStream
  */
 public static BufferedInputStream to_in(FileContents fc) throws IOException {
  if(null==fc){throw new XArg("FileContents are null");}
  if(!fc.canRead()){throw new XArg("fc.canRead",fc);}
  return new BufferedInputStream(fc.getInputStream());
 }

 /**
  * to_out: get a file's output stream and decide if we can overwrite it
  * @param fc file contents
  * @param overwrite is this allowed to overwrite an existing stream?
  * @return the file contents as a stream
  * @throws IOException if the file contents are not usable
  * @see javax.jnlp.FileContents#getOutputStream
  */
 public static BufferedOutputStream to_out(FileContents fc, boolean overwrite) throws IOException {
  if(null==fc){throw new XArg("fc",fc);}
  if(!fc.canWrite()){throw new XArg("fc.canWrite",fc);}
  return new BufferedOutputStream(fc.getOutputStream(overwrite));
 }

 /**
  * to_length: return the file contents length, i.e. fc.getLength()
  * @param fc file contents
  * @return the length of the file contents
  * @throws IOException if there's a problem with the file contents
  */
 public static long to_length(FileContents fc) throws IOException {
  if(null==fc){throw new XArg("fc",fc);}
  return (int)fc.getLength();
 }

}
