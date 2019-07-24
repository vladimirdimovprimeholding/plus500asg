package com.vlado.plus500asg.list.dummy

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<DummyItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    private val COUNT = 25

    val somePairs = arrayOf("EUR/GBP", "USD/CAD", "EUR/USD", "BTC/USD(Kraken)", "Gold", "Silver", "CAD/USD")

    val someDigits = arrayOf(
        "9084503280",
        "74.53647434",
        "6.7705854",
        "0.869701",
        "40.360352",
        "5.626102279",
        "0.97655754",
        "248.65409",
        "84.9209681",
        "98.7143725",
        "6.1092235",
        "0.76232",
        "16.0088410",
        "96.2872",
        "28.474040")

    val somePrecentages = arrayOf(
        "0.07",
        "-7.77",
        "6.07",
        "6.38",
        "-4.9",
        "0.34",
        "-9.91",
        "-2.74",
        "8.89",
        "-3.05"
    )

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(
                createDummyItem(
                    i
                )
            )
        }
    }

    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
//        ITEM_MAP.put(item.id, item)
    }

    private fun createDummyItem(position: Int): DummyItem {
        return DummyItem(
            somePairs.random(),
            someDigits.random(),
            somePrecentages.random(),
            someDigits.random()
        )
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class DummyItem(val pair: String, val firstDigits: String, val precentage: String, val secondDigits: String) {

    }
}
