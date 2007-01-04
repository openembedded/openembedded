require opie-image.bb

DEPENDS += "kdepimpi"
PR = "r1"

export IMAGE_BASENAME = "opie-kdepim-image"

INSTALL_PACKAGES += "kopi kapi kammu kopi-applet"

export PACKAGE_INSTALL = "${INSTALL_PACKAGES}"
