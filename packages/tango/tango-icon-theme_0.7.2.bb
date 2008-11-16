SECTION = "unknown"
LICENSE = "http://creativecommons.org/licenses/by-sa/2.5/"
inherit autotools pkgconfig

SRC_URI = "http://tango.freedesktop.org/releases/${PN}-${PV}.tar.gz \
	   file://no-icon-naming-utils.patch;patch=1"
EXTRA_OECONF = "--disable-icon-framing"

PACKAGE_ARCH = "all"
FILES_${PN} += "${datadir}/icons"
