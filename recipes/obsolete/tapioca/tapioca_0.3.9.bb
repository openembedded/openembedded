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

SRC_URI[md5sum] = "e88c400394c092c2688bb2d490c80ccb"
SRC_URI[sha256sum] = "fb89ac4e8578adc140e19cb4929b200d2898e5a8373230f500c16e59c803cba1"
