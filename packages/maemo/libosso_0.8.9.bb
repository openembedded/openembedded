LICENSE = 	"LGPL"
MAINTAINER =	"Koen Kooi <koen@handhelds.org>"
PR = "r2"

DEPENDS = 	"glib-2.0 dbus outo"
SRC_URI =	"http://repository.maemo.org/pool/maemo/ossw/source/libo/libosso/libosso_${PV}-1.tar.gz"

inherit pkgconfig autotools

FILES_${PN} += "${libdir}/dbus-1.0/services/ ${libdir}/outo/*.so ${libdir}/outo/*bin ${libdir}/outo/mimedummy.doc"

do_stage() {
	install -d ${STAGING_INCDIR}
	install -m 644 src/*.h ${STAGING_INCDIR}
	install -m644 src/.libs/libosso.so ${STAGING_LIBDIR}
}
