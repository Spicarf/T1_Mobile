/**
 * Tugas 3 - Sistem Penilaian Mahasiswa
 * Mata Kuliah : Pemrograman Bergerak
 *
 * Program ini digunakan untuk menghitung nilai akhir mahasiswa
 * berdasarkan nilai UTS, UAS, dan Tugas dengan bobot masing-masing,
 * kemudian mengkonversi ke grade huruf dan menentukan status kelulusan.
 */

// Batas nilai minimum untuk dinyatakan lulus
const val NILAI_LULUS = 60

fun main() {
    println("===== SISTEM PENILAIAN =====\n")

    // Meminta input nama mahasiswa
    print("Masukkan Nama Mahasiswa: ")
    val nama = readLine() ?: ""

    // Meminta dan memvalidasi input nilai UTS (harus dalam rentang 0-100)
    print("Masukkan Nilai UTS (0-100): ")
    val uts = bacaNilai("UTS")

    // Meminta dan memvalidasi input nilai UAS (harus dalam rentang 0-100)
    print("Masukkan Nilai UAS (0-100): ")
    val uas = bacaNilai("UAS")

    // Meminta dan memvalidasi input nilai Tugas (harus dalam rentang 0-100)
    print("Masukkan Nilai Tugas (0-100): ")
    val tugas = bacaNilai("Tugas")

    // Menghitung nilai akhir dengan bobot: UTS 30%, UAS 40%, Tugas 30%
    val nilaiAkhir = (uts * 0.3) + (uas * 0.4) + (tugas * 0.3)

    // Menentukan grade berdasarkan nilai akhir menggunakan when dengan range
    val grade = when (nilaiAkhir.toInt()) {
        in 85..100 -> "A"
        in 75..84  -> "B"
        in 65..74  -> "C"
        in 55..64  -> "D"
        else       -> "E"
    }

    // Menentukan keterangan berdasarkan grade
    val keterangan = when (grade) {
        "A" -> "Sangat Baik"
        "B" -> "Baik"
        "C" -> "Cukup"
        "D" -> "Kurang"
        else -> "Sangat Kurang"
    }

    // Menentukan status kelulusan: Lulus jika nilai akhir >= NILAI_LULUS
    val status = if (nilaiAkhir >= NILAI_LULUS) "LULUS" else "TIDAK LULUS"

    // Menampilkan hasil penilaian
    println()
    println("===== HASIL PENILAIAN =====")
    println("Nama        : $nama")
    println("Nilai UTS   : $uts (Bobot 30%)")
    println("Nilai UAS   : $uas (Bobot 40%)")
    println("Nilai Tugas : $tugas (Bobot 30%)")
    println("-----------------------------")
    println("Nilai Akhir : $nilaiAkhir")
    println("Grade       : $grade")
    println("Keterangan  : $keterangan")
    println("Status      : $status")
    println()

    // Menampilkan pesan berdasarkan status kelulusan
    if (nilaiAkhir >= NILAI_LULUS) {
        println("Selamat! Anda dinyatakan LULUS.")
    } else {
        println("Maaf, Anda dinyatakan TIDAK LULUS. Semangat untuk terus belajar!")
    }
}

/**
 * Fungsi untuk membaca dan memvalidasi nilai mahasiswa.
 * Nilai harus berupa angka dalam rentang 0-100.
 * Jika input tidak valid, program akan meminta input ulang.
 *
 * @param namaKomponen nama komponen nilai (UTS/UAS/Tugas) untuk pesan error
 * @return nilai yang valid dalam rentang 0-100
 */
fun bacaNilai(namaKomponen: String): Int {
    while (true) {
        val input = readLine()
        val nilai = input?.toIntOrNull()
        if (nilai != null && nilai in 0..100) {
            return nilai
        }
        print("Input tidak valid! Masukkan Nilai $namaKomponen (0-100): ")
    }
}
