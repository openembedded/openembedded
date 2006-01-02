DESCRIPTION = "A daemon to manage CPUfreq states"
HOMEPAGE = "http://www.deater.net/john/powernowd.html"
LICENSE = "GPLv2"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"


SRC_URI = "http://www.deater.net/john/${P}.tar.gz \
		   file://fix-makefile.patch;patch=1"

do_install() {
	install -d ${D}${sbindir}
	install -m 755 powernowd ${D}${sbindir}/
}

