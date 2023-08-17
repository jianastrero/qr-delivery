package dev.jianastrero.qr_delivery.model

import dev.jianastrero.qr_delivery.enumeration.DeliveryStatus

data class DeliveryStatusHistory(
    val id: String,
    val status: DeliveryStatus,
    val createdAt: Long,
)
