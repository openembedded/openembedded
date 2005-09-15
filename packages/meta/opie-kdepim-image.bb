include opie-image.bb

DEPENDS += "kdepimpi"
PR = "r1"

export IMAGE_BASENAME = "opie-kdepim-image"

INSTALL_PACKAGES += "kopi kapi kammu kopi-applet"

export IPKG_INSTALL = "${INSTALL_PACKAGES}"
