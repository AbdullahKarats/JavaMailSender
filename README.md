# JavaMailSender#

######################################################################KURULUM#################################################################################
#                                                                                                                                                            #
# GitHubda bulunan activation.jar ve JavaMail.jar'ı indirdikten sonra görseldeki gibi projeye kurulumunu gerçekleştirin.//https://www.hizliresim.com/k9hsf5v #
# Program çalıştırılırken hata alınması ve ya hata alınmasa da mail göndermemesi durumunda Uyeler.txt dosyasını temizleyin.                                   #
#                                                                                                                                                            #
##############################################################################################################################################################



DİKKAT EDİLMESİ GEREKENLER.

ElitUye ve GenelUye ekleme menüsünde İsim Soyisim ve Email inputları formata uygun şekilde girilmelidir.
Email uzantısı gmail olmak zorundadır.
Kazara yanlış input verilmesi durumunda Uyeler.txt dosyasının içi 'tamamen' silinmelidir.
Uyeler.txt dosyası içerisinde kategorilendirme yapılmamıştır. Program içinde elitUye ve genelUye olarak farklı ArrayListler oluşturulmuştur.

**30 Mayıs güncellemesiyle Gmail Less Secure App özelliğini kapatmıştır. Program içerisinde sadece bu program için kullanıma açık şifrem kayıtlı olduğu için benim mailimle sorunsuz test yapabilirsiniz. Ancak kendi hesabınızdan mail göndermek isterseniz aşağıdaki adımları takip edebilirsiniz.

1-Gmail hesabınızda iki adımlı doğrulamanın açık olduğundan emin olun.

2-Gmail Hesabınızın ayarlarından 'Uygulama Şifreleri' bölümüne giriş yapın.

3-Diğer seçeneğiyle Uygulama şifresi oluşturun. //https://prnt.sc/wbYiL5ooTuYl

4-16 rakamlı uygulama şifrenizi kopyalayın.//https://prnt.sc/ZRKtdBpv49eS

5-Java Mail API kod bloğunda bulunan 'password' Stringine tek kullanımlık şifreyi yapıştırın.//https://prnt.sc/Y4hmR2wuP0a8
