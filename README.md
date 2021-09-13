# Tutorial APAP

## 

* **Bintang Samudro** - *1906399410* - *C*

#

---
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
