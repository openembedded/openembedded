DESCRIPTION =   "a dbus service that listens to desktop notification requests and displays them"
HOMEPAGE =      "http://www.galago-project.org/"
LICENSE =       "GPL"
DEPENDS =       "gettext dbus gtk+ libsexy gconf libwnck"

PACKAGES = "${PN}"
FILES_${PN} = "${libexecdir}/notification-daemon \
	${datadir}/dbus-1/services/notification-daemon.service \
	${libdir}/notification-daemon-1.0/engines/libstandard.so \
	${sysconfdir}/gconf/schemas/notification-daemon.schemas"

SRC_URI =       "http://www.galago-project.org/files/releases/source/${PN}/${P}.tar.gz"
EXTRA_OECONF =	"--disable-binreloc"

inherit autotools pkgconfig
