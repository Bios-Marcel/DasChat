package util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * General utility Class
 *
 * @author msc
 *
 */
public class Util
{

  /**
   * Komprimiert ein byte array und gibt ihn zurück
   *
   * @param data zu komprimierende Daten
   * @return komprimierte Daten, im Falle eines Fehlschlages wird null zurückgegeben.
   */
  public static byte[] compress( final byte[] data )
  {

    final Deflater deflater = new Deflater();
    deflater.setInput( data );

    try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream( data.length );)
    {
      deflater.finish();
      final byte[] buffer = new byte[1024];
      while ( !deflater.finished() )
      {
        final int count = deflater.deflate( buffer );
        outputStream.write( buffer, 0, count );
      }
      outputStream.close();
      final byte[] output = outputStream.toByteArray();
      deflater.end();

      return output;
    }
    catch ( final IOException e )
    {
      return null;
    }
  }

  /**
   * Dekomprimiert ein byte array und gibt diesen wieder zurück
   *
   * @param data zu dekomprimerendes byte array
   * @return Gibt entweder das dekomprimierte byte array oder null im Falle eines fehlschlages zurück
   */
  public static byte[] decompress( final byte[] data )
  {
    final Inflater inflater = new Inflater();
    inflater.setInput( data );

    try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream( data.length );)
    {
      final byte[] buffer = new byte[1024];
      while ( !inflater.finished() )
      {
        final int count = inflater.inflate( buffer );
        outputStream.write( buffer, 0, count );
      }
      inflater.end();
      outputStream.close();
      final byte[] output = outputStream.toByteArray();

      return output;
    }
    catch ( final IOException | DataFormatException e )
    {
      return null;
    }
  }
}
