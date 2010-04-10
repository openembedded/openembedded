DESCRIPTION = "A daemon to manage CPUfreq states"
HOMEPAGE = "http://www.deater.net/john/powernowd.html"
LICENSE = "GPLv2"


SRC_URI = "http://www.deater.net/john/${P}.tar.gz \
		   file://fix-makefile.patch;patch=1"

do_install() {
	install -d ${D}${sbindir}
	install -m 755 powernowd ${D}${sbindir}/
}


SRC_URI[md5sum] = "9c7131bce36bbb3e8b688478e8dc34c7"
SRC_URI[sha256sum] = "44ea3e6777c471a514d1e0a53b60cd5a4e2e56802ba23ec67331b69f122ec3d7"
