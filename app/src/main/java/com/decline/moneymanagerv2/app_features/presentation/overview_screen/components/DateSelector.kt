package com.decline.moneymanagerv2.app_features.presentation.overview_screen.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.decline.moneymanagerv2.R
import com.decline.moneymanagerv2.ui.theme.LocalSpacing
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateSelector(
    date: String,
    onPreviousDateClick: () -> Unit,
    onNextDateClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onPreviousDateClick) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = stringResource(id = R.string.previous_date),
                modifier = Modifier.size(spacing.spaceLarge)
            )
        }
        Text(
            text = date,
        )
        IconButton(onClick = onNextDateClick) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.next_date),
                modifier = Modifier.size(spacing.spaceLarge)
            )
        }
    }

}