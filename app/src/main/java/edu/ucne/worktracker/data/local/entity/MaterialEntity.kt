package edu.ucne.worktracker.data.local.entity

import android.widget.DatePicker
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Materiales")
class MaterialEntity(
    @PrimaryKey(autoGenerate = true)
    val materialId: Int? =null,
    val duenoObra: String,
    val fecha: DatePicker,
    val descripcion: String,
    val catidad: Int?,
    val cantRetirada: Int?,
    val suplidor: String,
    val precioUd: Double?
)