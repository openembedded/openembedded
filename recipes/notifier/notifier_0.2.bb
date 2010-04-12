DESCRIPTION = "A notifier for new calls and messages"
HOMEPAGE = "http://www.telefoninux.org"
AUTHOR = "Pietro Montorfano"
LICENSE = "GPLv3"
RDEPENDS = "python-elementary python python-edbus"
SECTION = "x11/application"
PR = "r2"

SRC_URI = "http://monto.homelinux.org/notifier;name=archive \
http://monto.homelinux.org/89notifier;name=init"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/notifier ${D}${bindir}/
	install -d ${D}${sysconfdir}/X11/Xsession.d
	install -m 0755 ${S}/89notifier ${D}${sysconfdir}/X11/Xsession.d/
}



SRC_URI[archive.md5sum] = "24d87301da8843e2dbc3330ece57677f"
SRC_URI[archive.sha256sum] = "896c6942a9a3b0b2d6846eab1de8c471c9fcf860ca182ce18e12f1ce255f42cc"
SRC_URI[init.md5sum] = "6a197a3216abfd21ce2ae37b2be8da38"
SRC_URI[init.sha256sum] = "7795a3c6339c35d172ced0e43785ff657c1430f9fab7e2e553411529e177e501"
