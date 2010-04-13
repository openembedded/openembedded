SECTION = "unknown"
LICENSE = "http://creativecommons.org/licenses/by-sa/2.5/"
inherit autotools pkgconfig

SRC_URI = "http://tango-project.org/releases/${PN}-${PV}.tar.gz \
	   file://no-icon-naming-utils.patch;patch=1"
EXTRA_OECONF = "--disable-icon-framing"
FILES_${PN} += "${datadir}/icons"

SRC_URI[md5sum] = "caaceaec7b61f1cbda0db9842f9db281"
SRC_URI[sha256sum] = "b9252179ea2c546e6bb065281d51373f0ae06081e5a98d4255249af4fa8b33db"
