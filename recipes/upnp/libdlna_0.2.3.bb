DESCRIPTION = "bdlna aims at being the reference open-source implementation of DLNA (Digital Living Network Alliance) standards."
LICENSE = "LGPLv2.1"

DEPENDS = "sqlite3 ffmpeg"

SRC_URI = "http://libdlna.geexbox.org/releases/libdlna-${PV}.tar.bz2 \
           file://dlna.diff;patch=1"

inherit autotools

PARALLEL_MAKE = ""

EXTRA_OECONF = " --cross-prefix=${TARGET_PREFIX} \
                 --cross-compile \
                 --disable-strip \
                 --enable-sqlite \
"


SRC_URI[md5sum] = "2c974f95b711e5fd07f78fc4ebfcca66"
SRC_URI[sha256sum] = "8eb7941cbae088026dd394fbe6f465cae6dd848edc430c6313f04cf57d1192b4"
