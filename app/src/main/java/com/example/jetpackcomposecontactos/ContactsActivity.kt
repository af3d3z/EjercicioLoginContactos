package com.example.jetpackcomposecontactos

import android.os.Bundle
import android.widget.Space
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.ui.AppBarConfiguration
import com.example.jetpackcomposecontactos.databinding.ActivityContactsBinding
import com.example.jetpackcomposecontactos.ui.theme.JetpackComposeContactosTheme
import java.time.format.TextStyle

class ContactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var listaContactos = listOf(
            Contacto("Manolo Morilla", "999731375", 0),
            Contacto("Rigoberta Martínez", "333874314", 1),
            Contacto("Laura Pérez", "555123456", 1),
            Contacto("Carlos Sánchez", "777987654", 0),
            Contacto("Ana Gómez", "888765432", 1),
            Contacto("Javier Ruiz", "444321987", 1),
            Contacto("Sofía López", "222654789", 1),
            Contacto("Luis Fernández", "111234567", 0),
            Contacto("Marta Díaz", "666543210", 1),
            Contacto("David Martín", "333456789", 0),
            Contacto("Carmen Torres", "999888777", 1)
        )

        setContent {
            JetpackComposeContactosTheme {
                Scaffold (content = { p ->
                    ItemList(listaContactos, Modifier.padding(p))
                })
            }
        }
    }

    @Composable
    fun ItemList(itemContacto: List<Contacto>, modifier: Modifier) {
        LazyVerticalGrid (
            columns = GridCells.Fixed(2),
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(itemContacto.size) { index ->
                Contactos(contacto = itemContacto[index])
            }
          }
    }

    /*
    * @Composable
    fun ItemList(itemContacto: List<Contacto>, modifier: Modifier) {
        LazyColumn (modifier.fillMaxWidth()) {	// produce una lista de desplazamiento vertical,
            /*items(itemContacto.size) { index ->
                Contactos(contacto = itemContacto[index])
            }}*/
            items(itemContacto.chunked(2)) { chunk ->
                Row(modifier = Modifier.fillMaxWidth()){
                    chunk.forEach{ contacto ->
                        Contactos(contacto)
                    }
                }

            }
          }
    }*/


    @Composable
    fun Contactos(contacto: Contacto) {
        var foto = R.drawable.ic_launcher_foreground
        var txtContacto = AnnotatedString(contacto.GetInitials())
        var showPhone by remember {
            mutableStateOf(false)
        }
        when (contacto.imagen){
            0-> foto = R.drawable.male_icon
            1-> foto = R.drawable.female_icon
            2-> foto = R.drawable.nb_icon
        }
        Card(
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                AnimatedVisibility(visible = !showPhone) {
                    Image(
                        painter = painterResource(foto), // Load the image
                        contentDescription = null,
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .weight(1f)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ClickableText(
                        modifier = Modifier.weight(2f),
                        text = txtContacto,
                        onClick = {
                            showPhone = !showPhone
                        }
                    )
                }
                AnimatedVisibility(visible = showPhone) {
                    Text(contacto.nombre, modifier = Modifier.fillMaxSize().padding(20.dp).padding(10.dp))
                    ClickableText(
                        text = AnnotatedString(contacto.tfno),
                        onClick = { showPhone = !showPhone },
                        style = androidx.compose.ui.text.TextStyle(
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.fillMaxSize().padding(10.dp)
                    )

                }

            }
        }
    }
}