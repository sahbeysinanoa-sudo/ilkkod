import java.time.LocalDate;

// --- Ana Sınıf ---
class Kullanici {
    private int id;
    private String ad;
    private String sifre;
    private String eposta;

    public Kullanici(int id, String ad, String sifre, String eposta) {
        this.id = id;
        this.ad = ad;
        this.sifre = sifre;
        this.eposta = eposta;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }

    public String getSifre() { return sifre; }
    public void setSifre(String sifre) { this.sifre = sifre; }

    public String getEposta() { return eposta; }
    public void setEposta(String eposta) { this.eposta = eposta; }
}

// --- Üye Sınıfı ---
class Uye extends Kullanici {
    public Uye(int id, String ad, String sifre, String eposta) {
        super(id, ad, sifre, eposta);
    }
}

// --- Görevli Sınıfı ---
class Gorevli extends Kullanici {
    public Gorevli(int id, String ad, String sifre, String eposta) {
        super(id, ad, sifre, eposta);
    }
}

// --- Kitap Sınıfı ---
class Kitap {
    private int id;
    private String ad;
    private String yazar;
    private String durum;

    public Kitap(int id, String ad, String yazar, String durum) {
        this.id = id;
        this.ad = ad;
        this.yazar = yazar;
        this.durum = durum;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }

    public String getYazar() { return yazar; }
    public void setYazar(String yazar) { this.yazar = yazar; }

    public String getDurum() { return durum; }
    public void setDurum(String durum) { this.durum = durum; }
}

// --- Ödünç Alma Sınıfı ---
class OduncAlma {
    private int id;
    private LocalDate odunctarihi;
    private LocalDate teslimtarihi;
    
    private Uye uye;
    private Gorevli gorevli;
    private Kitap kitap;

    public OduncAlma(int id, LocalDate odunctarihi, LocalDate teslimtarihi, Uye uye, Gorevli gorevli, Kitap kitap) {
        this.id = id;
        this.odunctarihi = odunctarihi;
        this.teslimtarihi = teslimtarihi;
        this.uye = uye;
        this.gorevli = gorevli;
        this.kitap = kitap;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getOdunctarihi() { return odunctarihi; }
    public void setOdunctarihi(LocalDate odunctarihi) { this.odunctarihi = odunctarihi; }

    public LocalDate getTeslimtarihi() { return teslimtarihi; }
    public void setTeslimtarihi(LocalDate teslimtarihi) { this.teslimtarihi = teslimtarihi; }

    public Uye getUye() { return uye; }
    public void setUye(Uye uye) { this.uye = uye; }

    public Gorevli getGorevli() { return gorevli; }
    public void setGorevli(Gorevli gorevli) { this.gorevli = gorevli; }

    public Kitap getKitap() { return kitap; }
    public void setKitap(Kitap kitap) { this.kitap = kitap; }
}

// --- Test / Main Sınıfı ---
public class Main {
    public static void main(String[] args) {
        // Örnek nesne oluşturma ve test
        Uye uye = new Uye(1, "Ahmet Yılmaz", "1234", "ahmet@mail.com");
        Gorevli gorevli = new Gorevli(2, "Mehmet Demir", "abcd", "mehmet@mail.com");
        Kitap kitap = new Kitap(1, "Suç ve Ceza", "Dostoyevski", "Mevcut");

        OduncAlma odunc = new OduncAlma(
            1, 
            LocalDate.now(), 
            LocalDate.now().plusDays(15), 
            uye, 
            gorevli, 
            kitap
        );

        System.out.println("--- Kütüphane Ödünç Sistemi ---");
        System.out.println("Kitap: " + odunc.getKitap().getAd() + " (" + odunc.getKitap().getYazar() + ")");
        System.out.println("Alan Üye: " + odunc.getUye().getAd());
        System.out.println("İşlemi Yapan Görevli: " + odunc.getGorevli().getAd());
        System.out.println("Ödünç Tarihi: " + odunc.getOdunctarihi());
        System.out.println("Teslim Tarihi: " + odunc.getTeslimtarihi());
    }
}