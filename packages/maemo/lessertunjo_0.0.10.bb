LICENSE =	"LGPL"
MAINTAINER =	"Koen Kooi <koen@handhelds.org>"

DEPENDS =	"gconf-osso hildon-libs dbus libosso"
SRC_URI =	"http://repository.maemo.org/pool/maemo/ossw/source/l/lessertunjo/lessertunjo_${PV}-3.tar.gz"

inherit  pkgconfig

S = "${WORKDIR}/lessertunjo"
LDFLAGS += " -losso -L${STAGING_LIBDIR} -I${STAGING_INCDIR}  -I${STAGING_LIBDIR}/dbus-1.0/include -I${STAGING_INCDIR}/dbus-1.0 -I${STAGING_INCDIR}/glib-2.0  -I${STAGING_INCDIR}/gconf/2"


do_install() {
	install -d ${D}${libdir}        
	install -m 755 *so.0.0.10  ${D}${libdir}
}

do_stage() {
	oe_libinstall -so libshadowapp libshadowappd  ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}
	install -m 644 *.h ${STAGING_INCDIR}

}
