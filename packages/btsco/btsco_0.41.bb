DESCRIPTION = "Bluetooth-alsa headset tool"
HOMEPAGE = "http://bluetooth-alsa.sourceforge.net/"
LICENSE = "GPL"
DEPENDS = "alsa-lib bluez-libs"
PR = "r2"

inherit autotools pkgconfig

SRC_URI = "${SOURCEFORGE_MIRROR}/bluetooth-alsa/btsco-0.41.tar.gz"

S = "${WORKDIR}/${PN}-${PV}"
