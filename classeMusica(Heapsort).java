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

  public static void heapSort(ArrayList<classeMusica> subConjMusicas) {
    int n = subConjMusicas.size();
    ArrayList<classeMusica> temp = new ArrayList<classeMusica>();
    temp.add(subConjMusicas.get(0));

    // Build heap (rearrange array)
    for (int i = n / 2 - 1; i >= 0; i--) heapify(subConjMusicas, n, i);

    // One by one extract an element from heap
    for (int i = n - 1; i > 0; i--) {
      // Move current root to end
      temp.set(0, subConjMusicas.get(0));
      subConjMusicas.set(0, subConjMusicas.get(i));
      subConjMusicas.set(i, temp.get(0));

      // call max heapify on the reduced heap
      heapify(subConjMusicas, i, 0);
    }
  }

  // To heapify a subtree rooted with node i which is
  // an index in arr[]. n is size of heap
  public static void heapify(ArrayList<classeMusica> subConjMusicas, int n, int i) {
    ArrayList<classeMusica> swap = new ArrayList<classeMusica>();
    swap.add(subConjMusicas.get(0));

    int largest = i; // Initialize largest as root
    int l = 2 * i + 1; // left = 2*i + 1
    int r = 2 * i + 2; // right = 2*i + 2

    // If left child is larger than root
    if (l < n && subConjMusicas.get(l).ano.compareTo(subConjMusicas.get(largest).ano) > 0)
      largest = l;

    // If right child is larger than largest so far
    if (r < n && subConjMusicas.get(r).ano.compareTo(subConjMusicas.get(largest).ano) > 0)
      largest = r;

    // If largest is not root
    if (largest != i) {
      swap.set(0, subConjMusicas.get(i));
      subConjMusicas.set(i, subConjMusicas.get(largest));
      subConjMusicas.set(largest, swap.get(0));

      // Recursively heapify the affected sub-tree
      heapify(subConjMusicas, n, largest);
    }
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

    heapSort(subConjMusicas);

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
