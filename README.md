# Timus Siber Güvenlik Şirketi Mülakatı İçin Hazırlanan Proje

Bu proje, Timus Siber Güvenlik şirketi tarafından gerçekleştirilen mülakat için hazırlanmıştır. Proje, Amazon Türkiye web sitesi üzerinde çeşitli otomasyon senaryolarını içerir ve Selenium WebDriver, Cucumber, Rest-Assured gibi popüler test otomasyon araçları kullanılarak geliştirilmiştir. Bu proje, hem UI test otomasyonu hem de API testlerini kapsar.

## Kullanılan Teknolojiler

- **Java 17**: Projenin ana programlama dili.
- **Maven**: Proje yönetimi ve bağımlılık yönetimi için kullanıldı.
- **Selenium WebDriver**: Web sayfalarını otomatikleştirilmiş testler ile doğrulamak için kullanıldı.
- **Cucumber**: BDD (Behavior-Driven Development) çerçevesi ile test senaryolarını yazmak için kullanıldı.
- **JUnit**: Testlerin yürütülmesi ve raporlanması için kullanıldı.
- **JavaFaker**: Test verilerini dinamik olarak üretmek için kullanıldı.

## Proje Yapısı

- **`src/test/java/`**: Test senaryolarını ve adım tanımlarını içerir.
- **`src/main/resources/`**: Test senaryolarında kullanılan konfigürasyon dosyalarını içerir.
- **`pom.xml`**: Projede kullanılan tüm bağımlılıkları yöneten Maven yapılandırma dosyası.

## Özellikler

- **Üyelik Senaryosu**: Amazon Türkiye web sitesine kullanıcı kaydı oluşturmayı otomatikleştirir.
- **Giriş Yapma Senaryosu**: Kayıtlı kullanıcıların Amazon Türkiye web sitesine giriş yapmalarını doğrular.
- **Ürün Filtreleme Senaryosu**: Windows 11 işletim sistemine sahip dizüstü bilgisayarları filtreler ve bu ürünlerin doğru sıralandığını kontrol eder.
- **Ücretsiz Kargo Doğrulama Senaryosu**: Her bir ürünün ücretsiz kargo olup olmadığını doğrular.
- **Negatif Senaryolar**: Yanlış giriş bilgileri ve hatalı kayıt işlemleri gibi durumları test eder.

## İki Faktörlü Doğrulama (2FA) Durumu

Proje kapsamında, Amazon Türkiye web sitesine üye olma sürecini otomatikleştirmek amacıyla bir test senaryosu oluşturmayı planladım. Ancak, Amazon'un üye kayıt sürecinde uyguladığı iki faktörlü doğrulama (2FA) mekanizması, bu işlemi otomasyonla tamamlama konusunda zorluk yarattı.

### Neden 2FA nedeniyle senaryoyu tamamlayamadım?

- **Test Ortamının Olmaması:** İki faktörlü doğrulama sürecini test etmek için özel bir test ortamı veya geçici bir çözüm (örneğin, geçici e-posta doğrulaması) mevcut değildi. Bu nedenle, canlı ortamda bu süreci otomasyon ile geçmek mümkün olmadı.
- **Otomasyonun Kısıtlamaları:** 2FA gibi ek güvenlik önlemleri, genellikle manuel müdahale gerektirir ve otomasyon araçlarıyla tamamen geçilemeyebilir. Bu, sürecin güvenlik amacıyla insan doğrulaması gerektirdiği durumlar için geçerlidir.

### Bu Durumu Nasıl Ele Aldım?

- **Alternatif Senaryolar:** 2FA nedeniyle üyelik senaryosunu tamamlayamadığım için, projenin diğer kısımlarına odaklandım. Örneğin, giriş yapma, ürün filtreleme ve fiyat sıralama senaryolarını başarıyla gerçekleştirdim ve doğruladım.
- **Manuel Test Önerisi:** Bu tür güvenlik önlemleri ile karşılaşıldığında, üyelik oluşturma sürecinin manuel olarak test edilmesi gerektiğini öneriyorum. Bu süreçte 2FA mekanizmasının etkinliği ve doğruluğu gözlemlenebilir.

### Sonuç

Bu zorluk, projenin amacına zarar vermemektedir, çünkü odak noktası Amazon Türkiye web sitesindeki diğer kritik fonksiyonların otomatik test edilmesiydi. İlgili diğer test senaryoları başarıyla tamamlanmış ve doğrulanmıştır.

## Raporlama

- **Cucumber HTML Raporlama:** Test sonuçları, Cucumber tarafından oluşturulan HTML raporları ile izlenebilir. Bu raporlar, testlerin detaylı bir şekilde incelenmesini sağlar ve `target/cucumber-reports/` dizininde HTML formatında saklanır.

  Maven komutu ile testleri çalıştırdığınızda raporlar otomatik olarak oluşturulur ve `target/cucumber-reports/cucumber-html-reports.html` dosyasında bulunur.

## Kurulum ve Çalıştırma

1. **Bağımlılıkları Yükleme**:
   - Maven aracılığıyla projenin bağımlılıklarını indirmek için `mvn clean install` komutunu çalıştırın.

2. **Testleri Çalıştırma**:
   - `src/test/java` altındaki test senaryolarını çalıştırmak için `mvn test` komutunu kullanın.
   - Test sonuçları JUnit veya Cucumber raporları ile görüntülenebilir.

3. **Konfigürasyon**:
   - `configuration.properties` dosyası, test ortamı ayarlarını ve diğer yapılandırma parametrelerini içerir.
   - URL, kullanıcı bilgileri ve diğer parametreler bu dosyada tanımlanmıştır.

## Kullanım Senaryoları

- **Pozitif Senaryolar**: Doğru kullanıcı bilgileri ile üyelik oluşturma, giriş yapma ve ürün filtreleme işlemlerinin doğruluğunu test eder.
- **Negatif Senaryolar**: Yanlış kullanıcı bilgileri ile yapılan işlemlerin uygun hata mesajları ile sonlandığını doğrular.

## Notlar

- Bu proje, Timus Siber Güvenlik şirketinin taleplerine yönelik hazırlanmış bir test otomasyon çözümüdür.
- Test senaryoları, Amazon Türkiye web sitesi üzerindeki üyelik, giriş ve ürün filtreleme işlemlerinin doğruluğunu kontrol etmek için tasarlanmıştır.
- Proje, UI test otomasyonunu kapsayacak şekilde yapılandırılmıştır.

## İletişim

Proje hakkında herhangi bir sorunuz varsa  lütfen aşağıdaki e-posta adresi aracılığıyla benimle iletişime geçin:

- **Email**: [anevzatcelik@gmail.com]
