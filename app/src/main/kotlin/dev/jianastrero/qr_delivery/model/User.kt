package dev.jianastrero.qr_delivery.model

open class User(
    open val id: String,
    override val name: String,
    open val email: String,
    override val phone: String,
    open val photo: String,
    open val deliveries: List<Delivery>,
) : Person(name, phone)
