require procps.inc

PR = "r1"

SRC_URI += "file://pagesz-not-constant.patch;patch=1"

EXTRA_OEMAKE = "CFLAGS=-I${STAGING_INCDIR} \
                LDFLAGS=-L${STAGING_LIBDIR} -Wl,--rpath-link,${STAGING_LIBDIR} \
                CURSES=-lncurses \
                install='install -D' \
                ldconfig=echo"
