package com.example.lab14widgets

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.Image
import androidx.glance.action.actionStartActivity
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.ImageProvider
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.layout.size
import androidx.glance.text.Text

class SimpleWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                MyContent()
            }
        }
    }

    @Composable
    private fun MyContent() {
        Column(
            modifier = GlanceModifier.fillMaxSize()
                .background(GlanceTheme.colors.background),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "¿A dónde quieres dirigirte?",
                modifier = GlanceModifier.padding(12.dp)
            )
            Row(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    provider = androidx.glance.ImageProvider(R.drawable.ic_home),
                    contentDescription = "Home Icon",
                    modifier = GlanceModifier.size(50.dp)
                )
                Text(
                    text = "Página Principal",
                    modifier = GlanceModifier.padding(8.dp)
                        .clickable(onClick = actionStartActivity<MainActivity>())
                )

            }
            Row(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    provider = androidx.glance.ImageProvider(R.drawable.ic_settings),
                    contentDescription = "Settings Icon",
                    modifier = GlanceModifier.size(50.dp)
                )
                Text(
                    text = "Configuraciones",
                    modifier = GlanceModifier.padding(8.dp)
                        .clickable(onClick = actionStartActivity<SettingsActivity>())
                )
            }
        }
    }
}


