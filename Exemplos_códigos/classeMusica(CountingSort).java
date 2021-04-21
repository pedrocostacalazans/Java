import java.io.*;
import java.text.*;
import java.util.*;

/*=========================================
 * classe classeMusica
 *=========================================*/
public class classeMusica {

  // Declaração de atributos
  private String id, nome, key, artists, ano;
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
    this.setAno("");
  }

  // Construtor parametrizado
  public classeMusica(
      String id,
      String nome,
      String key,
      String artists,
      String release_date,
      String ano,
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
    this.ano = ano;
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

  public void setAno(String ano) {
    this.ano = ano;
  }

  /** Algoritmo de ordenacao CountingSort. */
  private static void countingSort(classeMusica arr[], int n) {
    classeMusica[] arr1 = new classeMusica[n + 1];

    classeMusica x = arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i].getPopularity() > x.getPopularity()) x = arr[i];
    }
    int[] count_arr = new int[x.getPopularity() + 1];

    for (int i = 0; i < x.getPopularity(); ++i) {
      count_arr[i] = 0;
    }

    for (int i = 0; i < n; i++) {
      count_arr[arr[i].getPopularity()]++;
    }

    for (int i = 1; i <= x.getPopularity(); i++) {
      count_arr[i] += count_arr[i - 1];
    }

    for (int i = n - 1; i >= 0; i--) {
      arr1[count_arr[arr[i].getPopularity()] - 1] = arr[i];
      count_arr[arr[i].getPopularity()]--;
    }

    for (int i = 0; i < n; i++) {
      arr[i] = arr1[i];
    }
  }

  public static void selectionSort(classeMusica subConjMusicas[], int low, int high) {

    int i, rh;
    classeMusica temp = new classeMusica();

    if (low < high) {
      rh = low;
      for (i = low + 1; i <= high; i++) {
        if (subConjMusicas[i].getNome().compareTo(subConjMusicas[rh].getNome()) < 0) rh = i;
      }
      temp = subConjMusicas[low];
      subConjMusicas[low] = subConjMusicas[rh];
      subConjMusicas[rh] = temp;
      selectionSort(subConjMusicas, low + 1, high);
    }
  }

  public static void fragmentSort(classeMusica[] subConjMusicas, int tam) {
    boolean status = false;
    int i = 0;

    while (i < tam - 1) {
      for (int j = i + 1; j < tam; j++) {
        if (subConjMusicas[i].getPopularity() == subConjMusicas[j].getPopularity()) {
          status = true;
        } else if (status == true) {
          selectionSort(subConjMusicas, i, j - 1);
          i = j;
          status = false;
          break;
        } else {
          i++;
          break;
        }
      }
    }
  }

  /*=========================================
   * main
   *=========================================*/

  public static void main(String[] args) {

    boolean status = false;

    int i = 0, j = 0, cont = 0;

    String console = new String();

    File arquivoCSV = new File("data.csv");

    classeMusica listaDeMusicas[] = new classeMusica[180000];

    classeMusica subConjMusicas[] = new classeMusica[600];

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
        musicas.setAno(valoresEntreVirgulas[16]);

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

        listaDeMusicas[cont] = musicas;
        cont++;
      }

    } catch (FileNotFoundException e) {
      System.out.println(e);
    }

    Scanner entradaTeclado = new Scanner(System.in);

    // Entrando com os id's
    console = entradaTeclado.next();

    cont = 0;
    while (!(console.equals("FIM"))) {
      for (i = 0; i < listaDeMusicas.length; i++) {
        if (listaDeMusicas[i].getId().equals(console)) {
          subConjMusicas[cont] = listaDeMusicas[i];
          break;
        }
      }
      console = entradaTeclado.next();
      cont++;
    }

    countingSort(subConjMusicas, cont);
    fragmentSort(subConjMusicas, cont - 1);

    for (i = 0; i < cont; i++) {
      System.out.println(
          subConjMusicas[i].getId()
              + " ## "
              + subConjMusicas[i].getArtists()
              + " ## "
              + subConjMusicas[i].getNome()
              + " ## "
              + subConjMusicas[i].getRelease_date()
              + " ## "
              + subConjMusicas[i].getAcousticness()
              + " ## "
              + subConjMusicas[i].getDanceability()
              + " ## "
              + subConjMusicas[i].getInstrumentalness()
              + " ## "
              + subConjMusicas[i].getLiveness()
              + " ## "
              + subConjMusicas[i].getLoudness()
              + " ## "
              + subConjMusicas[i].getSpeechiness()
              + " ## "
              + subConjMusicas[i].getEnergy()
              + " ## "
              + subConjMusicas[i].getDuration_ms());
    }
  }
}
