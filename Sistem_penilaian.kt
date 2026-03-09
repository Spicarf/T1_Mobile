fun main() {
    // inisialisasi variabel hasil/nilaiakhir dalam bentuk text bukan angka agar lebih mudah di baca
    var grade = ""
    var keterangan = ""

    // menampilkan dan meng-input informasi dan juga konversi ke-integer untuk selain nama
    println("===== SISTEM PENILAIAN =====")
    print("Masukkan Nama Mahasiswa: ")
    val nama = readLine()!!

    print("Masukkan Nilai UTS: ")
    val uts = readLine()!!.toInt()

    print("Masukkan Nilai UAS: ")
    val uas = readLine()!!.toInt()

    print("Masukkan Nilai Tugas: ")
    val tugas = readLine()!!.toInt()

    // hitung nilai akhir bedasarkan input yang didapat kemudian diberikan status yang sesuai dengan nilai yang dihasilkan
    val nilaiAkhir = (uts * 0.3) + (uas * 0.4) + (tugas * 0.3)
    val status = if (nilaiAkhir >= 60) "LULUS" else "TIDAK LULUS"

    // menentukan grade dan keterangan berdasarkan hasil nilai akhir tadi
    when (nilaiAkhir.toInt()) {
        in 85..100 -> {
            grade = "A"
            keterangan = "Sangat Baik"
        }
        in 70..84 -> {
            grade = "B"
            keterangan = "Baik"
        }
        in 60..69 -> {
            grade = "C"
            keterangan = "Cukup"
        }
        in 50..59 -> {
            grade = "D"
            keterangan = "Kurang"
        }
        else -> {
            grade = "E"
            keterangan = "Sangat Kurang"
        }
    }

    // menampilkan hasil penilaian nilai mahasiswa dari semua input-an tadi
    println("===== HASIL PENILAIAN =====")
    println("Nama        : $nama")
    println("Nilai UTS   : $uts")
    println("Nilai UAS   : $uas")
    println("Nilai Tugas : $tugas")
    println("-------------------------")
    println("Nilai Akhir : $nilaiAkhir")
    println("Grade       : $grade")
    println("Keterangan  : $keterangan")
    println("Status      : $status")
}