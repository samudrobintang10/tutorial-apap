# Tutorial APAP

## 

* **Bintang Samudro** - *1906399410* - *C*

#

---

## Tutorial 7
1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot
sebagai ilustrasi dari apa yang Anda jelaskan.

Pada nomor 1, Saya menambahkan fungsi baru yakni bernama delete handleDeleteItemFromCart. Hal yang pertama kali saya lakukan adalah menerima dalam variabel array Cart yang ada kemudian item yang ingin dihapus. Lalu kemudian saya memanggil fungsi yang akan mencari index dari item pada array Cart. Setelah diambil indexnya, maka akan dicek terlebih dahulu untuk memastikan bisa dihapus dengan > -1. Kemudian, saya menset dan menyatakan false bahwa selectedItem sudah tidak ada dicart. Barulah disini saya menghapus selectedItem dari cart dengan cara splice berdasarkan indexnya. Lalu saya update shop item agar tombol untuk menambahkan ke keranjang tersedia kembali. Terakhir, saya update state untuk mengumumkannya secara global untuk cartItemsnya

![1 1](https://user-images.githubusercontent.com/82602190/143254898-f9ac4566-52c2-41ea-85ae-0cce817b97da.jpg)

Pada nomor 2, saya menambahkan implementasi baru pada bagian add item dan juga delete item dimana apabila di add saldo akan berkurang dengan cara mengambil balance dari state kemudian dikurangi dengan price pada item. Lalu diset menjadi global kembali. Selanjutnya untuk delete, caranya hampir sama namun perbedaannya disini adalah ditambah antara state balance dan price.

![Inked1 2 1](https://user-images.githubusercontent.com/82602190/143255533-27b27699-fdc5-4358-91a6-161ac4c3f398.jpg)

![Inked1 2 2](https://user-images.githubusercontent.com/82602190/143255522-8f4c0306-1d1c-41f8-a2d8-2922dbd861c4.jpg)

(Perubahan ditandai dengan warna putih)

Pada nomor 3, saya akan melakukan pengecekkan pada add item ke cart yakni dengan memberikan if untuk mengecek apabila balancenya sudah kurang dari 0 maka tidak dapat membeli barang dengan memberikan alert dan item tidak akan dimasukkan kedalam keranjang

![Inked1 3](https://user-images.githubusercontent.com/82602190/143255529-ee64f48c-a44e-4723-926b-223babb84f6f.jpg)

(Perubahan ditandai dengan warna putih)

2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan
props?

Menurut pemahaman saya state merupakan istilahnya penggunaan deklarasi dalam class untuk penggunaan variabel yang nantinya dapat berupa boolean, Array, string, ataupun integer. Sedangkan props istilahnya seperti parameter yang nantinya dapat digunakan pada suatu fungsi/class yang ada untuk menuju ke fungsi/class lainnya. Props juga diakses oleh child components sedangkan state tidak dapat diakses pada class lain. State hanya dapat dimodifikasi dengan setState atau membuat set pada Functional-based.

Sumber : https://www.javatpoint.com/react-state-vs-props, https://www.geeksforgeeks.org/reactjs-state-vs-props/

3. Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam
React? sebutkan alasannya.

Ya betul menurut saya sebaiknya kita menggunakannya karena akan sangat membantu dalam pembuatan aplikasi sehingga kodenya menjadi reusable dan kita tinggal memasangkan probs atau parameter yang sesuai untuk menggunakannya pada bagian lain. Justru inilah kemampuan utama dari react yang membaginya menjadi beberapa komponen dan menyatukannya kembali menjad satu kesatuan 

4. Apa perbedaan class component dan functional component?

Class Component menyerupai konsep OOP dan merupakan metode yang awal digunakan sedangkan Functional Component menggunakan react hook untuk meminimalisir this.state agar lebih efisien (set). Secara code hampir sama namun yang membedakan adalah set'variable state' dan this.state.'variable state'. Selain itu, pada functional semua fungsinya dijadikan function 

5. Dalam react, apakah perbedaan component dan element?

Elemen adalah objek kecil DOM yang terdiri dari html seperti div, img, dan button. Elemen-elemen ini akan digabung dan barulah disebut sebagai Component. Elemen dapat mengandung elemen lain dalam propsnya. Component dapat definisikan sebagai fungsi yang akan menerima props sebagai input dan JSX sebagai outputnya. Component dimulai dengan huruf besar diawal

Sumber : https://www.freetimelearning.com/view-blog.php What-is-the-difference-between-React-Element-and-React-Component?&&id=9


## Tutorial 6
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode
yang telah anda buat) konsep tersebut diimplementasi?
Otentikasi adalah ketika proses verifikasi atau identifikasi pengguna apakah 
sudah terdaftar dalam sistem atau belum. Hal ini dilakukan pada proses login dengan 
memasukkan username dan password yang telah didaftarkan. Kode ini diimplementasi 
pada bagian websecurityconfig yang akan melakukan proses autentikasi. Sedangkan, Otorisasi
adalah proses ketika menentukan apakah user dapat melakukan atau mengakses fitur tertentu atau tidak.
Kode ini diimplementasi pada dengan memberikan arahan pada html yang memiliki fitur khusus untuk suatu role maka
akan di cek rolenya terlebih dahulu yang dibawa dari controller.

Sumber: https://www.akakom.ac.id/site/news/124/autentikasi-dan-otorisasi-user-menggunakan-framework-yii

2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.
BCryptPasswordEncoder adalah sebuah class yang dapat digunakan untuk menencode dan decode password dengan cara tersendiri. Cara kerjanya adalah
dengan user memasukkan sebuah password yang kemudian akan di encode dan dikembalikan dalam bentuk yang telah terencode.
ini bertujuan agar data aman meskipun ada pada database. Lalu pada tutorial ini, password tersebut dapat dicocokkan 
dengan fungsi matches dari BCryptPasswordEncoder yang akan mengcocokkan password 
yang diinput dengan password yang ada meski sudah diencode

Sumber : http://www.masterspringboot.com/security/authentication/using-bcryptpasswordencoder-to-encrypt-your-passwords/

3. Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa
demikian?
Lebih baik menggunakan hashing karena bersifat satu arah dan password yang telah dienkripsi tidak akan dapat dilakukan dekripsi untuk membuat data lebih aman
. Berbeda dengan enycription karena dua arah yang memiliki dekripsi untuk membaca password dan kemungkinan pencurian data dapat terjadi. Hashing akan melakukan
random teks untuk menghasilkan teks baru yang tidak bisa dibalikan. Tapi hal itu dapat dilakukan ketika otentikasi menggunakan pencarian inti pesan yang tepat dengan
cara tersendiri dan cocok maka akan berhasil terotentikasi

Sumber : https://www.clickssl.net/blog/difference-between-hashing-vs-encryption

4. Jelaskan secara singkat apa itu UUID beserta penggunaannya!
UUID adalah sekumpulan 32 karakter yang berbentuk string dan unik dan dibuat 
secara random bagi setiap data. UUID ini sangat cocok digunakan sebagai 
identifier atau primary key. Penggunaannya pada tutorial ini adalah pada UserModel

@Id
@GeneratedValue(generator="system-uuid")
@GenericGenerator(name="system-uuid", strategy = "uuid")
private String id;

dimasukkan kedalam generator dan gua namenya maka ketika dibuat user baru akan tergenerate user id baru yang unik

Sumber : https://stackoverflow.com/questions/292965/what-is-a-uuid

5. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut
Class ini digunakan untuk pembuatan otentikasi dari user. Class ini digunakan utnuk mencari nama dari pengguna, password, grantedAuthorities dari setiap
pengguna. Class ini kemudian akan menyimpan informasi penting yang akan digunakan untuk proses otentikasi

Sumber : https://www.baeldung.com/spring-security-authentication-with-a-database

## Tutorial 5
1. Apa itu Postman? Apa kegunaannya?
Postman adalah sebuah aplikasi yang berfungsi sebagai REST Client untuk menguji coba REST API.
Tool ini merupakan salah satu tool yang harus digunakan oleh para web developer yang bekerja dalam pengaturan API.
Postman mengetes web API dengan membuat HTTP requests dari luaran service

Sumber : https://www.baeldung.com/postman-testing-collections#:~:text=Postman%20is%20a%20standalone%20tool,Postman%20interact%20with%20our%20API.

2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
@JsonIgnoreProperties digunakan untuk pada suatu class untuk menandai properti yang akan diignore
@JsonProperty akan digunakan untuk memetakan nama properti dengan kunci JSON selama serialisasi dan deserialisasi. 

Sumber : https://www.tutorialspoint.com/jackson_annotations/jackson_annotations_jsonignoreproperties.htm

3. Apa kegunaan atribut WebClient?
Kegunaan WebClient dilakukan untuk melakukan pengiriman data sekaligus penerimaan data sesuai hal yang diindentifikasi oleh URI

Sumber : https://www.baeldung.com/webflux-webclient-parameters

4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
ResponseEntity digunakan untuk mengkonfigurasi HTTP Response dan menjadi satu entitas untuk pengembalian HTTP Response
BindingResult berisi terkait informasi yang ada mulai dari kesalahan ataupun field yang diperlukan. Selain itu, ini juga menginformasikan adanya kesalahan dalam pemanggilan method

Sumber : 
https://www.baeldung.com/spring-response-entity
https://zetcode.com/spring/bindingresult/

## Tutorial 4
1. Jelaskan perbedaan th:include dan th:replace!
th:include dilakukan untuk memasukkan kedalam tag yang ditunjuk dibandingkan dengan
th:replace yang akan mengantikan tag yang ditunjuk tersebut 

Sumber: https://stackoverflow.com/questions/37103958/difference-between-thymeleaf-include-and-replace

2. Jelaskan apa fungsi dari th:object!
Dengan menggunakan th:object maka kita dapat mempengaruhi object sesuai dengan apa yang kita isikan.
Selain itu, kita bisa mendapatkan layanan getter dan setter method sehingga input dapat mempengaruhi object
yang sesuai pada th:object

Sumber: https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html

3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
${...} : Variable expressions.
*{...} : Selection expressions.
${...} digunakan untuk mengisi value yang dikirimkan dari controller dan bisa langsung untuk mengambil apa saja yang terdefinisi sedangkan 
*{...} digunakan apabila telah ada object yang telah terdefinisi dengan ${...} dan digunakan untuk mengambil atribute yang diinginkan

Contoh penggunaan nomor 3:
```
<span th:text="${book.author.name}">
```

```*{...} :
<div th:object="${book}">
  ...
  <span th:text="*{title}">...</span>
  ...
</div>
```

Sumber : https://www.thymeleaf.org/doc/articles/standarddialect5minutes.html

## Tutorial 3
1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model
(@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)
@AllArgsConstructor digunakan untuk membuat secara otomatis Constructor dan menggunakan parameter dari setiap fields yang ada dikelas tersebut
@NoArgsConstructor digunakan untuk membuat secara otomatis Constructor tanpa parameter
@Setter digunakan untuk membuat method setter secara otomatis untuk semua fields atau attribute yang ada pada class
@Getter digunakan untuk membuat method getter secara otomatis untuk semua fields atau attribute yang ada pada class
@Entity digunakan sebagai penanda untuk class adalah entity dalam Java Persistence API (JPA)
@Table digunakan untuk membuat table SQL dengan nama yang bisa diatur

Sumber : 
http://www.javabyexamples.com/delombok-allargsconstructor-noargsconstructor-and-requiredargsconstructor
https://projectlombok.org/features/GetterSetter

2. Pada class BioskopDB, terdapat method findByNoBioskop, apakah kegunaan dari method
tersebut?
digunakan untuk mencari suatu BioskopModel berdasarkan nomor bioskopnya dan akan mereturn sebuah Object BioskopModel

3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn?
@JoinTable akan membentuk table baru yang akan menggabungkan kedua table berdasarkan atribut-atribut yang ada pada kedua table tersebut
@JoinColumn akan mengambil kolom sesuai dengan atribut yang dipilih pada table yang dipilih dan dimasukkan ke dalam table tersebut

4. Pada class PenjagaModel, digunakan anotasi @JoinColumn pada atribut bioskop, apa
kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa
perbedaan nullable dan penggunaan anotasi @NotNull
name digunakan untuk membuat attribut baru yang nanti akan dihubungkan dengan refrencedColumnName sebagai foreign key yang dihubungkan ke "noBioskop"
pada table BioskopModel. Kemudian, nullable digunakan untuk memberikan pernyataan apakah boleh tidaknya attribute dari table lain bernilai null atau tidak.
Berbeda dengan @NotNull, yakni @NotNull melakukan pengecekkan diawal sebelum mengeksekusi SQL-nya. @NotNull tidak mengeksekusi apabila dilanggar.
Sementara itu, nullable akan tetap berjalan dan gagal ketika constraintnya dilanggar

Sumber : https://www.baeldung.com/hibernate-notnull-vs-nullable

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER?
FetchType.LAZY digunakan untuk men-load data yang akan digunakan tetapi hanya yang diperlukan saja dan dilakukan ketika ada pemanggilan secara explisit
FetchType.EAGER digunakan untuk men-load semua data secara langsung meskipun ketika tidak diperlukan
CascadeType.ALL digunakan untuk membuat entitas tersebut dapat melakukan semua operasi yang ada yang mempengaruhi entity yang berhubungan berdasarkan attribute dari foreign keynya. 
Operasi yang dapat dilakukan adalah seperti (PERSIST, REMOVE, REFRESH, MERGE, DETACH)

Sumber : https://www.baeldung.com/hibernate-lazy-eager-loading


## Tutorial 2
Pertanyaan 1: Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut:
http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20
APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10 Apa yang
terjadi? Jelaskan mengapa hal tersebut dapat terjadi?

Hal yang terjadi adalah Whitelabel error page dikarenakan belum dipersiapkan 
file HTML dan Thymeleaf. Selain itu, masalah ini terjadi karena view yang telah kamu 
cantumkan pada Controller (contoh: “add-bioskop”) belum dibuat.

Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut
merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja
@Autowired tersebut dalam konteks service dan controller yang telah kamu buat?

@Autowired digunakan untuk memberikan kontrol yang untuk dimana dan bagaimana autowiring harusnya 
terlaksana. Dengan adanya notasi ini maka melakukan injeksi pada interface BioskopService untuk controller.
Kemudian, disini service berguna untuk menyimpan data objek yang dibuat dari model. Controller akan menggunakan
data pada method yang telah dibuat. @Autowired akan melakukan integrasi dengan interface yang sesuai. Disini
yang terintegrasi adalah BioskopService. 

Sumber : https://www.baeldung.com/spring-autowire

Pertanyaan 3: Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link
berikut:
http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20
APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan
mengapa hal tersebut dapat terjadi.

Karena parameter disini tidak lengkap yang mana disini wajib menuliskan value untuk jumlahStudio
karena pada saat membuat controller bertuliskan required = true yang artinya tidak boleh tidak
diisi

Pertanyaan 4: Jika Papa APAP ingin melihat Bioskop dengan nama Bioskop Maung,
link apa yang harus diakses?

Mengakses halaman http://localhost:8080/bioskop/view?namaBioskop=Bioskop%20Maung
karena menggunakan @RequestParam dan dengan asumsi nama bioskop dengan nama bioskop maung sudah ada

Pertanyaan 5: Tambahkan 1 contoh Bioskop lainnya sesukamu. Lalu cobalah untuk
mengakses http://localhost:8080/bioskop/viewall , apa yang akan ditampilkan? Sertakan
juga bukti screenshotmu.

Yang ditampilkan adalah seluruh bioskop yang terdaftar karena baru hanya 1 yang 
terdaftar maka hanya satu yang dikeluarkan yakni Bioskop PAPA APAP dengan ID 1
[Screenshoot Via Google Drive](https://drive.google.com/file/d/1HZhcVeKJfMBAKPg-lDPBNGHSjL5_Jr6h/view?usp=sharing)

## Tutorial 1
### What I have learned today
(Masukkan pertanyaan yang diikuti jawaban di setiap nomor, contoh seperti dibawah. Anda
juga boleh menambahkan catatan apapun di bagian ini)
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
(Tuliskan jawabanmu)
Issue Tracker memberikan kemudahan untuk pekerjaan dari Github. Ketika ada suatu masalah
yang ada pada projek maka masalah tersebut dapat ditandai oleh developer. Selain itu, mereka juga bisa 
menjadi alat untuk diskusi sesama developer terkait suatu permasalahan yang ada. Penandaan tersebut dapat
dilakukan dengan memberikan label terkait bug, enhancement, duplicate, help wanted, question, dan lainnya.
Inti dari Issue Tracker ini adalah meminimalisir isu bug yang ada pada program sehingga para developer tahu
dan bisa berkomunikasi untuk menyelesaikan bug. 


2. Apa perbedaan dari git merge dan git merge --squash?
Perbedaannya terletak pada saat commitnya dimana dengan menggunakan squash maka akan terproduce merge commit
dengan hanya satu parent saja. Jika menggunakan merge maka akan menunjukan dari branch atau beberapa parent mana 
saja yang melakukan merge tersebut. Filenya akan terhasilkan dengan cara manapun akan sama seperti normal merge pada umumnya. 
Namun, metadata dari commit akan berubah dengan hanya menunjukkan satu parent dari commit. Hasilnya akan terjadi single commit pada
target branch. Squash merge akan menghasilkan history commit yang lebih bersih. Meskipun dalam cabang terlihat tidak menyatu. Namun,
yang di merge menggunakan squash akan menghasilkan data yang telah di merge. 
Sumber: https://devblogs.microsoft.com/devops/squash-a-whole-new-way-to-merge-pull-requests/

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
suatu aplikasi?
git adalah komponen penting dalam pengembangan suatu website. Git adalah system kendali kode yang
digunakan oleh developer untuk menghandle projek baik dalam skala besar dan kecil yang terkenal
dengan kecepatan dan efisiensinya. Git sendiri memiliki desain yang sederhana dan dapat mendukung
perkembangan secara paralel. Sistem yang digunakan juga terdistribusi (peer to peer) Git juga mampu
digunakan dalam proyek besar seperti Kernel Linux. Penyimpanannya juga murni berbasis file tanpa menggunakan
database. Git dapat diakses melalui command line interface.
Sumber: https://edusoftcenter.com/apasaja-kelebihan-dan-kekurangan-git/

### Spring
4. Apa itu library & dependency?
Library adalah sebuah sekumpulan kode-kode yang bisa digunakan kembali atau dikenal sebagai reusable oleh
developer dalam pengembangan aplikasi suatu projek. Library ini bersifat independen atau tidak bergantung
satu sama lain. Lain halnya dengan dependency yakni program-program yang membutuhkan program lain agar
dapat digunakan untuk menjalankan program.  

5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
Maven adalah sebuah software manajemen projek dan comprehension tool. Maven bisa digunakan untuk memanage
pembuatan projek, pelaporan dan dokumentasi dari informasi utama yang ada. Kita menggunakan maven agar
memungkinkan kita untuk memahami keadaan pengembangan projek dalam waktu singkat. Maven juga membuat proses
build menjadi lebih mudah. Selain itu, maven juga menyediakan sistem build yang seragam sehingga memberikan
informasi projek yang berkualitas. Hal ini sangat membantu agar pengembangan lebih baik. Alternatif dari
Maven adalah Circle CI dan Gradle.
Sumber: https://maven.apache.org/

6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
framework?
Dapat digunakan untuk membangun sebuah aplikasi, integrasi terkait database juga dapat dilakukan disini, Pembuatan
remote access, dan Dependency Injection.

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
menggunakan @RequestParam atau @PathVariable?
Perbedaannya adalah terletak pada format untuk akses valuenya dimana @RequestParam digunakan untuk akses value
dari query parameter yang ada. 

Contoh penggunaan untuk @RequestParam

```
http://localhost:8080/is-palindrome?kalimat=((kata anda))


http://localhost:8080/is-palindrome?kalimat=tamat
```

sedangkan untuk @PathVariable digunakan untuk akses value dari URI template. 

Contoh penggunaan untuk @PathVariable

```
http://localhost:8080/is-palindrome/((kata anda))

http://localhost:8080/is-palindrome/tamat

```

Tergantung dari kebutuhannya untuk dapat menentukan mana yang lebih baik untuk digunakan.
Sumber:
https://www.dineshonjava.com/requestparam-vs-pathvariable-annotations-in-spring-mvc/#:~:text=The%20key%20difference%20between%20%40RequestParam,values%20from%20the%20URI%20template



### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda
sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Kenapa saya harus belajar APAP?
- [x] Kenapa?
Karena merupakan suatu langkah yang penting dalam pembuatan aplikasi perusahaan. Kita diajarkan tidak
hanya cara untuk menyelesaikan masalah tapi kerapihan kode dan efisienan juga diperlukan agar memaksimalkan
kemampuan sistem

- [ ] Menurut saya materi di PPT masih terlalu abstrak
- [ ] Belum terlalu familiar dengan spring boot meskipun sudah pernah memakai pada saat DDP 2

(Anda dapat membuat tampilan code dalam README.md menjadi lebih baik. Cari tahu
lebih dalam tentang penulisan README.md di GitHub pada link
[berikut](https://help.github.com/en/articles/basic-writing-and-formatting-syntax))
