PR 	= 	"r1"
LICENSE =	"GPL/LGPL"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"

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
