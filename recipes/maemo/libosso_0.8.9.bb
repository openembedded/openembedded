LICENSE = 	"LGPL"
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

SRC_URI[md5sum] = "f40c4c73f58cf62859129c3ff08d159d"
SRC_URI[sha256sum] = "d832126b22dec3a60ee6cdbd476c908f7715fc94d6f1ee11731b1b1ffaf41d47"
