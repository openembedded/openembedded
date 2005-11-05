LICENSE =	"LGPL"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"

DEPENDS = 	"glib-2.0 openobex dbus libxml2 osso-gwconnect"

SRC_URI =	"http://repository.maemo.org/pool/maemo/ossw/source/o/osso-gwobex/osso-gwobex_${PV}.tar.gz"

inherit autotools pkgconfig


do_stage() {
	install -d ${STAGING_INCDIR}
	install -d ${STAGING_LIBDIR}
	install -m 644 src/*.h ${STAGING_INCDIR}
	install -m 755 src/.libs/*.so* ${STAGING_LIBDIR}
} 


