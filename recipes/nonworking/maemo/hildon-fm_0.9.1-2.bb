PR 	= 	"r1"
LICENSE =	"GPL LGPL"

DEPENDS =	"gtk+-2.6.4-1.osso7 outo libxi libxt libpng gconf hildon-lgpl osso-thumbnail osso-gwconnect"
SRC_URI = 	"http://repository.maemo.org/pool/maemo/ossw/source/h/hildon-fm/hildon-fm_${PV}.tar.gz"

S = 	"${WORKDIR}/hildon-fm-0.9.1"
FILES_${PN} += "${libdir}/outo/*.so"

inherit pkgconfig autotools

EXTRA_OECONF =	"--disable-gtk-doc"

do_stage() {
	install -d ${STAGING_INCDIR}/hildon-fm/hildon-widgets
	install -d ${STAGING_LIBDIR}
	install -m 644 hildon-fm/*.h ${STAGING_INCDIR}/hildon-fm/hildon-widgets
	install -m 755 hildon-fm/.libs/*.so* ${STAGING_LIBDIR}
}

SRC_URI[md5sum] = "6d2646bf0ef3da795a34245b870f7983"
SRC_URI[sha256sum] = "9305aff5ec4eefe462e94b49c0e1ec3037e9d3ae5a6fa47c8cb7136dadcb1e8c"
