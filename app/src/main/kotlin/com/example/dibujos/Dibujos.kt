package com.example.dibujos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
private fun Fila(content: @Composable RowScope.() -> Unit) =
    Row(modifier = Modifier.fillMaxWidth(), content = content)

@Composable
private fun RowScope.Cuadro(color: Color) =
    Box(modifier = Modifier.weight(1f).aspectRatio(1f).background(color))

// Celda vacía; opcionalmente admite contenido (se usa en el dibujo 3).
@Composable
private fun RowScope.Hueco(content: @Composable BoxScope.() -> Unit = {}) =
    Box(modifier = Modifier.weight(1f).aspectRatio(1f), content = content)

@Composable
private fun Lienzo(content: @Composable ColumnScope.() -> Unit) =
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content
    )

@Preview(showSystemUi = true)
@Composable
fun Dibujo1() = Lienzo {
    Fila { Cuadro(Color.Blue);   Hueco();            Cuadro(Color.Magenta) }
    Fila { Hueco();              Cuadro(Color.Red);  Hueco() }
    Fila { Cuadro(Color.Yellow); Hueco();            Cuadro(Color.Green) }
}

@Preview(showSystemUi = true)
@Composable
fun Dibujo2() = Lienzo {
    Fila { Hueco();               Cuadro(Color.Green); Hueco() }
    Fila { Cuadro(Color.Blue);    Hueco();             Cuadro(Color.Yellow) }
    Fila { Hueco();               Cuadro(Color.Red);   Hueco() }
    Fila { Cuadro(Color.Magenta); Hueco();             Cuadro(Color.Cyan) }
    Fila { Hueco();               Cuadro(Color.Black); Hueco() }
}

@Preview(showSystemUi = true)
@Composable
fun Dibujo3() = Lienzo {
    Fila { Cuadro(Color.Blue);   DiagonalHueco();   Cuadro(Color.Magenta) }
    Fila { Hueco();              Cuadro(Color.Red); Hueco() }
    Fila { Cuadro(Color.Yellow); Hueco();           Cuadro(Color.Green) }
}

// Tres cuadritos (1/3 de la celda) en diagonal usando Alignment.
@Composable
private fun RowScope.DiagonalHueco() = Hueco {
    val lado = Modifier.fillMaxSize(1f / 3f)
    Box(lado.align(Alignment.BottomStart).background(Color.Cyan))
    Box(lado.align(Alignment.Center).background(Color.Black))
    Box(lado.align(Alignment.TopEnd).background(Color.Black))
}
