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

