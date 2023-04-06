import javax.mail.*;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.*;
public class JavaMail {

    UyeYonetimSistemi a1 = new UyeYonetimSistemi();
    public static void sendMail(String alici) throws Exception {
        System.out.println("Mesaj gönderiliyor.");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        String myAccountEmail = "abdullahkaratas2002@gmail.com";
        String password = "kpdr onoi vstu ypds\n";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail,password);
            }
        });

        Message message = prepareMessage(session,myAccountEmail,alici);
        Transport.send(message);
        System.out.println("Mesaj başarıyla gönderildi");
    }
    private static Message prepareMessage(Session session, String myAccountEmail, String recepient){
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject("Java Proje Vizesi");
            message.setText(""+UyeYonetimSistemi.icerik);
            return message;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
class JavaMailAc {
    public static void main(String[] args) throws Exception {
        UyeYonetimSistemi uyeYonetimSistemi = new UyeYonetimSistemi();
       mailGonder();
        uyeYonetimSistemi.menuGoster();

    }
    public static void mailGonder() throws Exception {

    }
}

class Uye {
    //İleride Genel ve Elit uye sınıflarımın miras alacağı ata sınıfı burada oluşturuyorum.
    private String isim;
    private String soyisim;
    private String email;

    public Uye(String isim, String soyisim, String email) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.email = email;
    }

    public String getIsim() {
        return isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return isim + "\t" + soyisim + "\t" + email;
    }
}

class ElitUye extends Uye {
    public ElitUye(String isim, String soyisim, String email) {
        super(isim, soyisim, email);
    }
}

class GenelUye extends Uye {
    public GenelUye(String isim, String soyisim, String email) {
        super(isim, soyisim, email);
    }
}

 class UyeYonetimSistemi {
     private List<ElitUye> elitUyeler = new ArrayList<>();
    private List<GenelUye> genelUyeler = new ArrayList<>();
    private String dosyaAdi = "Uyeler.txt";//Uyelerin icine yazılacağı dosya adını burda belirliyorum.
     public static String icerik;

     public void menuGoster() throws Exception {
        Scanner scanner = new Scanner(System.in);
        //Main methodumun içine yazılacak ve programı başlatacak methodu burda tanımladım.
        while (true) {
            System.out.println("\n\nÜye Yönetim Sistemi\n");
            System.out.println("1- Elit üye ekleme");
            System.out.println("2- Genel üye ekleme");
            System.out.println("3- Mail Gönderme");
            System.out.print("Seçiminiz (1-3): ");

            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    elitUyeEkle();
                    break;
                case 2:
                    genelUyeEkle();
                    break;
                case 3:
                    mailGondermeMenu();
                    break;
                default:
                    System.out.println("Hatalı seçim. Tekrar deneyin.");
            }
        }
    }

    private void elitUyeEkle() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("İsim: ");
        String isim = scanner.nextLine();

        System.out.print("Soyisim: ");
        String soyisim = scanner.nextLine();

        System.out.print("E-posta: ");
        String email = scanner.nextLine();

        ElitUye elitUye = new ElitUye(isim, soyisim, email);
        elitUyeler.add(elitUye);
        System.out.println("Elit üye eklendi.");
        dosyayaYaz(elitUye);
    }

    private void genelUyeEkle() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("İsim: ");
        String isim = scanner.nextLine();

        System.out.print("Soyisim: ");
        String soyisim = scanner.nextLine();

        System.out.print("E-posta: ");
        String email = scanner.nextLine();

        GenelUye genelUye = new GenelUye(isim, soyisim, email);
        genelUyeler.add(genelUye);
        System.out.println("Genel üye eklendi.");
        dosyayaYaz(genelUye);
    }

    private void mailGondermeMenu() throws Exception {
         Scanner scanner = new Scanner(System.in);
         scanner.useDelimiter("\n");

        while (true) {
            System.out.println("\n\nMail Gönderme\n");
            System.out.println("1- Elit üyelere mail");
            System.out.println("2- Genel üyelere mail");
            System.out.println("3- Tüm üyelere mail");
            System.out.print("Seçiminiz (1-3): ");

            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.print("Mail içeriği: ");
                    scanner.nextLine();
                    // İki kere
                    // scanner.nextLine() kullanmamın sebebi;
                    // icerik stringimi tutması için scanner.Next atadığımda sadece stringin ilk kelimesini tutuyordu.
                    // Scanner.NextLine kullandığımdaysa bir önceki scanner int değer tuttuğu için input girişi beklemeden geçiyordu.
                    //Aşağıdaki kaynak aracılığıyla sorunun çözümüne bu şekilde ulaştım.
                    //https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo

                    icerik = scanner.nextLine();
                    elitUyelereMailGonder(icerik);
                    break;
                case 2:
                    System.out.print("Mail içeriği: ");
                    scanner.nextLine();
                    icerik = scanner.nextLine();
                    genelUyelereMailGonder(icerik);
                    break;
                case 3:
                    System.out.print("Mail içeriği: ");
                    scanner.nextLine();
                    icerik = scanner.nextLine();
                    tumUyelereMailGonder(icerik);
                    break;
                default:
                    System.out.println("Hatalı seçim. Tekrar deneyin.");
            }
        }
    }

    private void elitUyelereMailGonder(String icerik) throws Exception {
        for (ElitUye elitUye : elitUyeler) {
            mailGonder(elitUye.getEmail(), icerik);
        }
        System.out.println("Elit üyelere mail gönderildi.");
    }

    private void genelUyelereMailGonder(String icerik) throws Exception {
        for (GenelUye genelUye : genelUyeler) {
            mailGonder(""+genelUye.getEmail(),""+icerik);
        }
        System.out.println("Genel üyelere mail gönderildi.");
    }

    private void tumUyelereMailGonder(String icerik) throws Exception {
        System.out.println(icerik);
         elitUyelereMailGonder(icerik);
        genelUyelereMailGonder(icerik);
    }


    private void mailGonder(String alici, String icerik) throws Exception {
        System.out.println("Mail gönderildi. Alıcı: " + alici + " İçerik: " + UyeYonetimSistemi.icerik);
        JavaMail.sendMail(""+alici);
     }

    private void dosyayaYaz(Uye uye) {
        try {
            FileWriter writer = new FileWriter(dosyaAdi, true);
            writer.write(uye.toString() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Dosya yazma hatası: " + e.getMessage());
        }
    }
}


