LICENSE = 	"LGPL"
PR = "r0"

DEPENDS = 	"libosso hildon-lgpl hildon-base-lib hildon-libs"
SRC_URI =	"http://repository.maemo.org/pool/maemo/ossw/source/libo/${PN}/libosso-help_${PV}.tar.gz \
                 file://no-Werror.patch;patch=1;pnum=0 \
                 file://help-header-pp.patch;patch=1;pnum=0"

inherit pkgconfig autotools

S = "${WORKDIR}/libosso-help-sdk-${PV}"

#FILES_${PN} += "${libdir}/dbus-1.0/services/ ${libdir}/outo/*.so ${libdir}/outo/*bin ${libdir}/outo/mimedummy.doc"

do_stage() {
	install -d ${STAGING_INCDIR}
	install -m 644 helplib/*.h ${STAGING_INCDIR}
	install -m644 helplib/.libs/libossohelp.so ${STAGING_LIBDIR}
	install -m644 helplib/.libs/libossohelp.so.0 ${STAGING_LIBDIR}
	install -m644 helplib/.libs/libossohelp.so.0.0.0 ${STAGING_LIBDIR}
}

SRC_URI[md5sum] = "dbc3c68809e39bd6681aab8ad16ffe3c"
SRC_URI[sha256sum] = "ef6f6fda31dfbf7b3186b6f1d0ffd12ee0675d9a057ad2994f81b5164213a693"
