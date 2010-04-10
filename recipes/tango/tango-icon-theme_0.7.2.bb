SECTION = "unknown"
LICENSE = "http://creativecommons.org/licenses/by-sa/2.5/"
inherit autotools pkgconfig

SRC_URI = "http://tango.freedesktop.org/releases/${PN}-${PV}.tar.gz \
	   file://no-icon-naming-utils.patch;patch=1"
EXTRA_OECONF = "--disable-icon-framing"

PACKAGE_ARCH = "all"
FILES_${PN} += "${datadir}/icons"

SRC_URI[md5sum] = "eace48f8340a95d7134632bad6287100"
SRC_URI[sha256sum] = "6b368373f9a01f3f33f77ac25c170cbd052b29d6910f72308e55dc0a39af7722"
