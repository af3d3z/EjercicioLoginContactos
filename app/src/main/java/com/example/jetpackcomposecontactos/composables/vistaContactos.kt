package com.example.jetpackcomposecontactos.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecontactos.Contacto
import com.example.jetpackcomposecontactos.R

class vistaContactos {

    @Composable
    fun ItemList(itemContacto: List<Contacto>) {
        LazyColumn {	// produce una lista de desplazamiento vertical,
            items(itemContacto.size) { index ->
                ContactoView(contacto = itemContacto[index])
            }}
    }


    @Composable
    fun ContactoView(contacto: Contacto) {
        var foto = R.drawable.ic_launcher_foreground
        when (contacto.imagen){
            0-> foto = R.drawable.vincenta
            1-> foto = R.drawable.marisa
            2-> foto = R.drawable.juan_cuesta
            3-> foto = R.drawable.lahierbas
            4-> foto = R.drawable.mariano_delgado
            5-> foto = R.drawable.emilio_delgado
            6-> foto = R.drawable.belen_lopez
            7-> foto = R.drawable.la_pija
            8-> foto = R.drawable.roberto
            9-> foto = R.drawable.carlos
        }
        Card(Modifier.fillMaxWidth()) {
            Row(Modifier.padding(PaddingValues(8.dp))) {
                Column {
                    Image(
                        painter = painterResource(id = foto),
                        contentDescription = "Foto contacto",
                        Modifier.height(100.dp).width(100.dp).clip(RoundedCornerShape(10.dp))
                    )
                }
                Column {
                    Text(
                        text = contacto.nombre,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = contacto.tfno,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }

}