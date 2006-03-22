PR = "r1"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>
HOMEPAGE = "http://tapioca-voip.sourceforge.net/wiki/index.php/Tapioca"
LICENSE = "LGPL"
DEPENDS = "glib-2.0 dbus"

inherit autotools pkgconfig

SRC_URI = "${SOURCEFORGE_MIRROR}/tapioca-voip/${P}.tar.gz"
FILES_${PN} += "${datadir}/dbus*"

do_stage () {
	autotools_stage_all
	install -d ${STAGING_INCDIR}/tapioca/core/
	install -d ${STAGING_INCDIR}/tapioca/client/

	install -m 644 tapioca/core/*.h ${STAGING_INCDIR}/tapioca/core/
	install -m 644 tapioca/client/*.h ${STAGING_INCDIR}/tapioca/client/
}
