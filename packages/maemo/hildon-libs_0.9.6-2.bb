PR 	= 	"r1"
LICENSE = 	"LGPL"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"

DEPENDS =	"dbus hildon-lgpl hildon-fm outo gtk+-2.6.4-1.osso7"
SRC_URI =	"http://repository.maemo.org/pool/maemo/ossw/source/h/${PN}/${PN}_${PV}.tar.gz \
			file://hildon-libs-no-werror.patch;patch=1"

S = "${WORKDIR}/hildon-libs-0.9.6"

inherit autotools pkgconfig

EXTRA_OECONF =	"--disable-gtk-doc"


FILES_${PN} += "${libdir}/outo/*.so"

do_stage() {
  install -d ${STAGING_LIBDIR}/outo
  install -m755 ${S}/ut/.libs/libhildonwidgets_unittests.so  ${STAGING_LIBDIR}/outo
  install -m755 ${S}/ut/.libs/libhildonwidgets_clock_unittests.so  ${STAGING_LIBDIR}/outo
  install -m755 ${S}/hildon-widgets/.libs/libhildonwidgets.so* ${STAGING_LIBDIR}
  install -d ${STAGING_INCDIR}/hildon-widgets
  install -m 644 hildon-widgets/*.h ${STAGING_INCDIR}/hildon-widgets
}
