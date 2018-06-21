package shared;
/**
 * © 2016 isp-insoft all rights reserved.
 */

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Sammlung von Variablen welche sowohl vom Server als auch vom Client genutzt werden.
 *
 * @author msc
 * @date 15.07.2016
 *
 */
public class GeneralSharedInformation
{
  /**
   * Version von DasChat
   */
  public static final String  VERSION                  = "0.3.5";

  /**
   * Über diesen Port lässt sich der Server im Netzwerk lokalisieren.
   */
  public static final int     DISCOVERY_PORT           = 8888;

  /**
   * Über diesen Port werden eingehende Verbindungen angenommen und die Kommunikation geregelt.
   */
  public static final int     SERVER_PORT              = 55001;

  /**
   * Über diesen Port werden Fonts gesendet.
   */
  public static final int     FONT_TRANSFER_PORT       = 55002;

  /**
   * Standard CharSet
   */
  public static final Charset CHARSET                  = StandardCharsets.UTF_8;

  /**
   * Hier speichert der Server die Fonts welche er gesendet bekommen hat.
   */
  public static final String  SERVER_FONT_LOCATION     = "Fonts" + File.separator;

  /**
   * Konfigurationsdateipfad des Servers
   */
  public static final String  SERVER_CONFIG_PATH       = "config.cfg";

  /**
   * Hier werden die einzelnen Hash Tags gespeichert.
   */
  public static final String  SERVER_HASH_TAG_LOCATION = "hashtags.list";

}
