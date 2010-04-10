DESCRIPTION = "Openmoko extensionhandler"
LICENSE = "GPLv2"

DEPENDS = "dbus-glib"

SRC_URI = "http://www.devzero.net/openmoko/dist/omext-${PV}.tar.gz"

inherit autotools pkgconfig

S = "${WORKDIR}/openmoko-extensionhandler"

SRC_URI[md5sum] = "3c1fcd85f0a0cd3ccc4d7b4f26996b47"
SRC_URI[sha256sum] = "3d3cc3e4f92f7e0b6a352c3f68a337a599a90f4e4b6e6743adc0c70b570639f5"
