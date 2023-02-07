package com.example.pricecheck.data

import com.example.pricecheck.R
import com.example.pricecheck.data.model.Prospect

class Repository {

    fun loadProspects(): List<Prospect> {
        return listOf(
            Prospect(1,
                "Rewe",
                R.drawable.reweprospekt),
            Prospect(2,
                "Lidl",
                R.drawable.lidlprospekt),
            Prospect(3,
                "Netto",
                R.drawable.nettoprospekt),
            Prospect(4,
                "Aldi Süd",
                R.drawable.aldis_dprospekt),
            Prospect(5,
                "Kaufland",
                R.drawable.kauflandprospekt),
            Prospect(6,
                "Penny",
                R.drawable.pennyprospekt),
            Prospect(7,
                "Edeka",
                R.drawable.edekaprospekt),
            )





    }
}