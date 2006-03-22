PR = "r1"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>
HOMEPAGE = "http://tapioca-voip.sourceforge.net/wiki/index.php/Tapioca"
LICENSE = "LGPL"
DEPENDS = "glib-2.0 dbus libjingle openssl tapioca"
inherit autotools pkgconfig

SRC_URI = "${SOURCEFORGE_MIRROR}/tapioca-voip/${P}.tar.gz"

FILES_${PN} += "${datadir}/dbus* ${datadir}/tapioca* "

do_stage () {
        autotools_stage_all
}
