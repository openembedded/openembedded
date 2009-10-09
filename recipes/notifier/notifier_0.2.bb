DESCRIPTION = "A notifier for new calls and messages"
HOMEPAGE = "http://www.telefoninux.org"
AUTHOR = "Pietro Montorfano"
LICENSE = "GPLv3"
RDEPENDS = "python-elementary python python-edbus"
SECTION = "x11/application"
PR = "r2"

SRC_URI = "http://monto.homelinux.org/notifier \
http://monto.homelinux.org/89notifier"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/notifier ${D}${bindir}/
	install -d ${D}${sysconfdir}/X11/Xsession.d
	install -m 0755 ${S}/89notifier ${D}${sysconfdir}/X11/Xsession.d/
}


