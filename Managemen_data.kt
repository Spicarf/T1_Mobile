// Objek Mahasiswa dengan atribut-atribut-nya
data class Mahasiswa(
    val nim: String,
    val nama: String,
    val mataKuliah: String,
    val nilai: Int
)

// Fungsi getGrade untuk mmendefinisikan nilai yang di-input dari angka ke huruf
fun getGrade(nilai: Int): String {
    return when (nilai) {
        in 85..100 -> "A"
        in 70..84 -> "B"
        in 60..69 -> "C"
        in 50..59 -> "D"
        else -> "E"
    }
}

// Fungsi Utama
fun main() {
    // Inisialisasi variabel menghitung jumlah data mahasiswa
    var no = 1
    var total = 0

    // Membuat list yang berisi data-data mahasiswa berupa (NIM, Nama, Matakuliah dan nilai)
    val DataMahasiswa = listOf(
        Mahasiswa("F1D026001", "Budi Santoso", "Database", 85),
        Mahasiswa("F1D026002", "Ani Wijaya", "Jaringan", 92),
        Mahasiswa("F1D026003", "Citra Dewi", "Database", 68),
        Mahasiswa("F1D026004", "Dani Pratama", "AI", 45),
        Mahasiswa("F1D026005", "Eka Putri", "Security", 74),
        Mahasiswa("F1D026006", "Fajar Hadi", "jaringan", 88),
        Mahasiswa("F1D026007", "Gina Lestari", "Database", 55),
        Mahasiswa("F1D026008", "Hadi Saputra", "AI", 63),
        Mahasiswa("F1D02^009", "Indra Kurnia", "AI", 90),
        Mahasiswa("F1D026010", "Joko Susilo", "Security", 72)
    )

    // inisialisasi untuk nilai tertinggi dan terendah
    var tertinggi = DataMahasiswa[0]
    var terendah = DataMahasiswa[0]

    // Membuat list yang bisa diedit
    val lulus = mutableListOf<Mahasiswa>()
    val tidakLulus = mutableListOf<Mahasiswa>()

    // mengitung nilai rata-rata
    val rataRata = total.toDouble() / DataMahasiswa.size

    // List yang yang sudah diurutkan
    val ascending = DataMahasiswa.sortedBy { it.nilai }
    val descending = DataMahasiswa.sortedByDescending { it.nilai }
    val groupGrade = DataMahasiswa.groupBy { getGrade(it.nilai) }

    // Menampilkan data mahasiswa
    println("===== DATA NILAI DataMahasiswa =====")
    for (m in DataMahasiswa) {
        println("$no. ${m.nim} - ${m.nama} - ${m.mataKuliah} - ${m.nilai}")
        no++
    }

    // mencari mahasiswa dengan nilai tertinggi dan terendah, juga memisahkan mahasiswa yang lulus dan tidak lulus berdasarkan nilai
    for (m in DataMahasiswa) {
        total += m.nilai

        if (m.nilai > tertinggi.nilai) { tertinggi = m }

        if (m.nilai < terendah.nilai) { terendah = m }

        if (m.nilai >= 70) { lulus.add(m) }
        else { tidakLulus.add(m) }
    }

    // menampilkan statistik data mahasiswa saat ini
    println("\n===== STATISTIK =====")
    println("Total Mahasiswa : ${DataMahasiswa.size}")
    println("Rata-rata Nilai : $rataRata")
    println("Nilai Tertinggi : ${tertinggi.nilai} (${tertinggi.nama})")
    println("Nilai Terendah  : ${terendah.nilai} (${terendah.nama})")

    println("\n===== DataMahasiswa LULUS =====")
    no = 1
    for (m in lulus) {
        println("$no. ${m.nama} - ${m.nilai} (${getGrade(m.nilai)})")
        no++
    }

    println("\n===== DataMahasiswa TIDAK LULUS =====")
    no = 1
    for (m in tidakLulus) {
        println("$no. ${m.nama} - ${m.nilai} (${getGrade(m.nilai)})")
        no++
    }

    println("\n===== URUT NILAI ASCENDING =====")
    for (m in ascending) {
        println("${m.nama} - ${m.nilai}")
    }

    println("\n===== URUT NILAI DESCENDING =====")
    for (m in descending) {
        println("${m.nama} - ${m.nilai}")
    }

    println("\n===== JUMLAH PER GRADE =====")

    for (g in groupGrade.keys) {
        println("Grade $g: ${groupGrade[g]?.size} DataMahasiswa")
    }

    // mencari mahasiswa didata
    println("\n======== PENCARIAN ========")
    print("Nama DataMahasiswa: ")
    val cari = readLine()

    println("\n===== HASIL PENCARIAN =====")

    for (m in DataMahasiswa) {
        if (m.nama == cari) {
            println("${m.nama} - ${m.nilai}")
        }
    }
}