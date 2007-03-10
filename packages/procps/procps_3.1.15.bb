require procps.inc

SRC_URI += "file://procps_${PV}-2.diff;patch=1"

EXTRA_OEMAKE = "CFLAGS=-I${STAGING_INCDIR} \
                LDFLAGS=-L${STAGING_LIBDIR} -Wl,--rpath-link,${STAGING_LIBDIR} \
                CURSES=-lncurses \
                install='install -D' \
                ldconfig=echo"
