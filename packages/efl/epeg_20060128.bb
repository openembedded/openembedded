DESCRIPTION = "Epeg is a small library for handling thumbnails."
LICENSE = "MIT"
DEPENDS = "jpeg"

inherit efl

SRC_URI = "cvs://anonymous@thinktux.net/root;module=e17/libs/epeg;date=${PV}"
S = "${WORKDIR}/epeg"
