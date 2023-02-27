package id.kawahedukasi.KotlinJava

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


    fun main() {
        //outputKalimat();
        //duaVariable();
        //tigaString();
        //castingVariable();
        //hariLibur();
        //loopingAngka();
        //reformatTanggal();
        tanggalKadaluarsa()
    }

    fun reformatTanggal() {
        val time = LocalDateTime.of(2022, 11, 12, 9, 11, 12)
        println(time.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")))
        println(time.format(DateTimeFormatter.ofPattern("yyyyMMdd_hhmmss")))
    }

    fun tanggalKadaluarsa() {
        val currentTime = LocalDateTime.now()
        val expTime = currentTime.plusYears(1).plusMonths(6).plusDays(12).plusHours(3).plusMinutes(12).plusSeconds(20)
        println("Tanggal Sekarang : " +
                currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
        println("Tanggal Kadaluarsa : " +
                expTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
    }

    fun outputKalimat() {
        val scanner = Scanner(System.`in`)
        val nama = scanner.nextLine()
        println("Selamat datang di bootcamp Kawah Edukasi, $nama")
    }

    fun duaVariable() {
        val short1: Short = 1
        val short2: Short = 2
        val double1 = 0.1
        val double2 = 0.2
        val char1 = 'A'
        val char2 = 'B'
        val boolean1 = true
        val boolean2 = false
    }

    fun tigaString() {
        val a: String = "Saya senang"
        val b: String = "belajar"
        val c: String = "Java Language"
        println("$a $b $c")
        println("$a $b $c")
    }

    fun castingVariable() {
        val myDouble = 999.99

        //double to integer
        val myInt = myDouble.toInt()
        println(myInt)

        //integer to float
        val myFloat = myInt.toFloat()
        println(myFloat)
        val myShort = myFloat.toInt().toShort()
        println(myShort)
    }

    const val HARI_LIBUR = "Hari Libur"
    const val HARI_KERJA = "Hari Kerja"
    fun hariLibur() {
        val scanner = Scanner(System.`in`)
        val hari = scanner.nextLine()
        if (hari.equals("sabtu", ignoreCase = true) || hari.equals("minggu", ignoreCase = true)) {
            println("$hari merupakan $HARI_LIBUR")
        } else {
            println("Apakah Hari Libur? (true/false)")
            val isLibur = scanner.nextBoolean()
            if (isLibur) {
                println("$hari merupakan $HARI_LIBUR")
            } else {
                println("$hari merupakan $HARI_KERJA")
            }
        }
    }

    fun loopingAngka() {
        for (i in 1..100) {
            if (i % 3 == 0 && i % 5 == 0) {
                print("KawahEdukasi,")
            } else if (i % 3 == 0) {
                print("Kawah,")
            } else if (i % 5 == 0) {
                print("Edukasi,")
            } else {
                print("$i,")
            }
        }
    }