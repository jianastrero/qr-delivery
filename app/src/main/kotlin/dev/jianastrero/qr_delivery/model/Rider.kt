package dev.jianastrero.qr_delivery.model

data class Rider(
    override val id: String,
    override val name: String,
    override val email: String,
    override val phone: String,
    override val photo: String,
    val rating: Float,
    override val deliveries: List<Delivery>,
) : User(id, name, email, phone, photo, deliveries)

