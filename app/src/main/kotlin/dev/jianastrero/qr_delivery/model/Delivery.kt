package dev.jianastrero.qr_delivery.model

data class Delivery(
    val id: String,
    val rider: Rider,
    val note: String,
    val sender: Person,
    val recipient: Person,
    val statusHistory: List<DeliveryStatusHistory>,
)
