DESCRIPTION = "Openmoko extensionhandler"
LICENSE = "GPLv2"

DEPENDS = "dbus-glib"

SRC_URI = "http://www.devzero.net/openmoko/dist/omext-${PV}.tar.gz"

inherit autotools pkgconfig

S = "{WORKDIR}/openmoko-extensionhandler"


