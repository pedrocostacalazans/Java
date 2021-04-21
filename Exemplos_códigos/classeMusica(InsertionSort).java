import java.io.*;
import java.text.*;
import java.util.*;

/*=========================================
 * classe classeMusica
 *=========================================*/
public class classeMusica {

  // Declaração de atributos
  private String id, nome, key, artists;
  private String release_date;
  private double acousticness,
      danceability,
      energy,
      instrumentalness,
      valence,
      liveness,
      loudness,
      speechiness;
  private float tempo;
  private int duration_ms, popularity, year;

  // Construtor default
  public classeMusica() {

    this.setId("");
    this.setNome("");
    this.setKey("");
    this.setArtists("");
    this.setDanceability(0.0);
    this.setAcousticness(0.0);
    this.setEnergy(0.0);
    this.setInstrumentalness(0.0);
    this.setValence(0.0);
    this.setLiveness(0.0);
    this.setLoudness(0.0);
    this.setSpeechiness(0.0);
    this.setTempo(0);
    this.setDuration_ms(0);
    this.setPopularity(0);
    this.setYear(0);
    this.setRelease_date("");
  }

  // Construtor parametrizado
  public classeMusica(
      String id,
      String nome,
      String key,
      String artists,
      String release_date,
      double acousticness,
      double danceability,
      double energy,
      int duration_ms,
      double instrumentalness,
      double valence,
      int popularity,
      float tempo,
      double liveness,
      double loudness,
      double speechiness,
      int year) {
    this.id = id;
    this.nome = nome;
    this.key = key;
    this.artists = artists;
    this.danceability = danceability;
    this.acousticness = acousticness;
    this.energy = energy;
    this.instrumentalness = instrumentalness;
    this.valence = valence;
    this.liveness = liveness;
    this.loudness = loudness;
    this.speechiness = speechiness;
    this.tempo = tempo;
    this.duration_ms = duration_ms;
    this.popularity = popularity;
    this.year = year;
    this.release_date = release_date;
  }

  // Gets
  public String getId() {
    return this.id;
  }

  public String getNome() {
    return this.nome;
  }

  public String getKey() {
    return this.key;
  }

  public String getArtists() {
    return this.artists;
  }

  public double getDanceability() {
    return this.danceability;
  }

  public double getAcousticness() {
    return this.acousticness;
  }

  public double getEnergy() {
    return this.energy;
  }

  public double getInstrumentalness() {
    return this.instrumentalness;
  }

  public double getValence() {
    return this.valence;
  }

  public double getLiveness() {
    return this.liveness;
  }

  public double getLoudness() {
    return this.loudness;
  }

  public double getSpeechiness() {
    return this.speechiness;
  }

  public float getTempo() {
    return this.tempo;
  }

  public int getDuration_ms() {
    return this.duration_ms;
  }

  public int getPopularity() {
    return this.popularity;
  }

  public int getYear() {
    return this.year;
  }

  public String getRelease_date() {
    return this.release_date;
  }

  // Sets
  public void setId(String id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public void setArtists(String artists) {
    this.artists = artists;
  }

  public void setDanceability(Double danceability) {
    this.danceability = danceability;
  }

  public void setAcousticness(Double acousticness) {
    this.acousticness = acousticness;
  }

  public void setEnergy(Double energy) {
    this.energy = energy;
  }

  public void setInstrumentalness(Double instrumentalness) {
    this.instrumentalness = instrumentalness;
  }

  public void setValence(Double valence) {
    this.valence = valence;
  }

  public void setLiveness(Double liveness) {
    this.liveness = liveness;
  }

  public void setLoudness(Double loudness) {
    this.loudness = loudness;
  }

  public void setSpeechiness(Double speechiness) {
    this.speechiness = speechiness;
  }

  public void setTempo(float tempo) {
    this.tempo = tempo;
  }

  public void setDuration_ms(int duration_ms) {
    this.duration_ms = duration_ms;
  }

  public void setPopularity(int popularity) {
    this.popularity = popularity;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public void setRelease_date(String release_date) {
    this.release_date = release_date;
  }

  /*=========================================
   * main
   *=========================================*/

  public static void main(String[] args) {

    boolean status = false;

    int i = 0, j = 0;

    String console = new String();

    File arquivoCSV = new File("data.csv");

    ArrayList<classeMusica> listaDeMusicas = new ArrayList<>();

    ArrayList<classeMusica> subConjMusicas = new ArrayList<>();

    ArrayList<classeMusica> testeFinal = new ArrayList<>();

    try {

      Scanner entradaArquivo = new Scanner(arquivoCSV);

      String linhasDoArquivo = new String();

      entradaArquivo.nextLine();

      while (entradaArquivo.hasNext()) {

        linhasDoArquivo = entradaArquivo.nextLine();

        String[] valoresEntreVirgulas = linhasDoArquivo.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

        classeMusica musicas = new classeMusica();

        musicas.setValence(Double.parseDouble(valoresEntreVirgulas[0]));
        musicas.setYear(Integer.parseInt(valoresEntreVirgulas[1]));
        musicas.setAcousticness(Double.parseDouble(valoresEntreVirgulas[2]));
        valoresEntreVirgulas[3] = valoresEntreVirgulas[3].replaceAll("\"", "");
        valoresEntreVirgulas[3] = valoresEntreVirgulas[3].replaceAll("\'", "");
        musicas.setArtists(valoresEntreVirgulas[3]);
        musicas.setDanceability(Double.parseDouble(valoresEntreVirgulas[4]));
        musicas.setDuration_ms(Integer.parseInt(valoresEntreVirgulas[5]));
        musicas.setEnergy(Double.parseDouble(valoresEntreVirgulas[6]));
        musicas.setId(valoresEntreVirgulas[8]);
        musicas.setInstrumentalness(Double.parseDouble(valoresEntreVirgulas[9]));
        musicas.setKey(valoresEntreVirgulas[10]);
        musicas.setLiveness(Double.parseDouble(valoresEntreVirgulas[11]));
        musicas.setLoudness(Double.parseDouble(valoresEntreVirgulas[12]));
        valoresEntreVirgulas[14] = valoresEntreVirgulas[14].replaceAll("\"", "");
        musicas.setNome(valoresEntreVirgulas[14]);
        musicas.setPopularity(Integer.parseInt(valoresEntreVirgulas[15]));

        if (valoresEntreVirgulas[16].equals("")) {
          musicas.setRelease_date("01");
        } else {
          String[] valoresEntreHifen = valoresEntreVirgulas[16].split("-");
          if (valoresEntreHifen.length == 1) {
            String dataFormat = "01" + "/" + "01" + "/" + valoresEntreHifen[0];
            musicas.setRelease_date(dataFormat);
          }
          if (valoresEntreHifen.length == 3) {
            String data =
                valoresEntreHifen[2] + "/" + valoresEntreHifen[1] + "/" + valoresEntreHifen[0];
            musicas.setRelease_date(data);
          }
        }

        musicas.setSpeechiness(Double.parseDouble(valoresEntreVirgulas[17]));
        musicas.setTempo(Float.parseFloat(valoresEntreVirgulas[18]));

        listaDeMusicas.add(musicas);
      }

    } catch (FileNotFoundException e) {
      System.out.println(e);
    }

    Scanner entradaTeclado = new Scanner(System.in);

    // Entrando com os id's
    console = entradaTeclado.next();

    while (!(console.equals("FIM"))) {
      for (i = 0; i < listaDeMusicas.size(); i++) {
        if (listaDeMusicas.get(i).getId().equals(console)) {
          subConjMusicas.add(listaDeMusicas.get(i));
          break;
        }
      }
      console = entradaTeclado.next();
    }

    for (i = 0; i < subConjMusicas.size(); i++) {
      for (j = 1; j < subConjMusicas.size(); j++) {
        testeFinal.add(subConjMusicas.get(0));
        if (subConjMusicas.get(j - 1).getNome().compareTo(subConjMusicas.get(j).getNome()) > 0) {
          testeFinal.set(0, subConjMusicas.get(j - 1));
          subConjMusicas.set(j - 1, subConjMusicas.get(j));
          subConjMusicas.set(j, testeFinal.get(0));
        }
      }
    }

    for (i = 0; i < subConjMusicas.size(); i++) {
      System.out.println(
          subConjMusicas.get(i).getId()
              + " ## "
              + subConjMusicas.get(i).getArtists()
              + " ## "
              + subConjMusicas.get(i).getNome()
              + " ## "
              + subConjMusicas.get(i).getRelease_date()
              + " ## "
              + subConjMusicas.get(i).getAcousticness()
              + " ## "
              + subConjMusicas.get(i).getDanceability()
              + " ## "
              + subConjMusicas.get(i).getInstrumentalness()
              + " ## "
              + subConjMusicas.get(i).getLiveness()
              + " ## "
              + subConjMusicas.get(i).getLoudness()
              + " ## "
              + subConjMusicas.get(i).getSpeechiness()
              + " ## "
              + subConjMusicas.get(i).getEnergy()
              + " ## "
              + subConjMusicas.get(i).getDuration_ms());
    }
  }
}
