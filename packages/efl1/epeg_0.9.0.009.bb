DESCRIPTION = "Epeg is a small library for handling thumbnails."
LICENSE = "MIT"
DEPENDS = "jpeg"

inherit efl1

FILES_${PN} = "${libdir}/lib*.so*"
FILES_${PN}-dev += "${bindir}/*-config"
