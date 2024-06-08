package com.example.stockmanagement.db



import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase









@Database(entities = [Product::class, History::class, Dashboard::class], version = 2, exportSchema = false)
abstract class DataBase : RoomDatabase() {

    companion object {
        const val NAME = "Stock_DB"
    }

    abstract fun getProductDao(): ProductDao
    abstract fun getHistoryDao(): HistoryDao
    abstract fun getDashboardDao(): DashboardDao

    // Use fallbackToDestructiveMigration in case of version mismatch
    val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Since we're using destructive migration, no need to define a migration path
            database.execSQL("DROP TABLE IF EXISTS dashboard")
            database.execSQL("CREATE TABLE IF NOT EXISTS `dashboard` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `productName` TEXT NOT NULL, `reference` TEXT NOT NULL, `quantity` INTEGER NOT NULL)")
        }
    }
}




