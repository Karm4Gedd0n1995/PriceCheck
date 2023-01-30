package com.example.pricecheck.data

import com.example.pricecheck.R
import com.example.pricecheck.data.model.Prospect

class Repository {

    fun loadProspects(): List<Prospect> {
        return listOf(
            Prospect(
                "Rewe",
                R.drawable.reweprospekt),
            Prospect(
                "Lidl",
                R.drawable.lidlprospekt),
            Prospect(
                "Netto",
                R.drawable.nettoprospekt),
            Prospect(
                "Aldi Süd",
                R.drawable.aldis_dprospekt),
            Prospect(
                "Kaufland",
                R.drawable.kauflandprospekt),
            Prospect(
                "Penny",
                R.drawable.pennyprospekt),
            Prospect(
                "Edeka",
                R.drawable.edekaprospekt),
            )





    }
}