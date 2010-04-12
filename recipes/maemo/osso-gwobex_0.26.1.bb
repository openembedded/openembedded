LICENSE =	"LGPL"

DEPENDS = 	"glib-2.0 openobex dbus libxml2 osso-gwconnect"

SRC_URI =	"http://repository.maemo.org/pool/maemo/ossw/source/o/osso-gwobex/osso-gwobex_${PV}.tar.gz"

inherit autotools pkgconfig


do_stage() {
	install -d ${STAGING_INCDIR}
	install -d ${STAGING_LIBDIR}
	install -m 644 src/*.h ${STAGING_INCDIR}
	install -m 755 src/.libs/*.so* ${STAGING_LIBDIR}
}



SRC_URI[md5sum] = "804ad2ed142c9ef31bee42a68704315c"
SRC_URI[sha256sum] = "f5e784be11151f927c68f09ba4e2881a95b67c99de9ba597b8155a6d5421598f"
