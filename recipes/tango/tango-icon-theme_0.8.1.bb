SECTION = "unknown"
LICENSE = "http://creativecommons.org/licenses/by-sa/2.5/"
inherit autotools pkgconfig

SRC_URI = "http://tango.freedesktop.org/releases/${PN}-${PV}.tar.gz \
	   file://no-icon-naming-utils.patch;patch=1"
EXTRA_OECONF = "--disable-icon-framing"

PACKAGE_ARCH = "all"
FILES_${PN} += "${datadir}/icons"

SRC_URI[md5sum] = "32d5258f448b5982af9cfa4364f31d41"
SRC_URI[sha256sum] = "17e64f2f5d7d8a358136a7003604cb60acaef47b083123956b12eb0ed9293055"
