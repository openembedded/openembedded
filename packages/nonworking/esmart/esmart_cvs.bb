DESCRIPTION = "A collection of smart Evas objects"
SECTION = "libs"
DEPENDS = "evas evas-x11 ecore imlib2 edje libtool"
PV = "${CVSDATE}"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/libs/esmart"
S = "${WORKDIR}/esmart"

inherit autotools pkgconfig binconfig

do_stage () {
	oe_libinstall -C src/lib libesmart ${STAGING_LIBDIR}/
	install -m 0644 ${S}/src/lib/Esmart.h ${STAGING_INCDIR}/
}
