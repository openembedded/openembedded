DESCRIPTION = "Bluetooth-alsa headset tool"
HOMEPAGE = "http://bluetooth-alsa.sourceforge.net/"
LICENSE = "GPL"
DEPENDS = "alsa-lib bluez-libs"

inherit autotools pkgconfig

SRC_URI = "${SOURCEFORGE_MIRROR}/bluetooth-alsa/btsco-${PV}.tar.gz"

S = "${WORKDIR}/${PN}-${PV}"

CFLAGS += " -I${STAGING_INCDIR} "
