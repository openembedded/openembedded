require opie-image.bb

DEPENDS += "kdepimpi"

export IMAGE_BASENAME = "opie-kdepim-image"

IMAGE_INSTALL += "kopi kapi kammu kopi-applet"
