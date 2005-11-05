LICENSE = "GPL"
DESCRIPTION = "Procps is the package that has a bunch \
of small useful utilities that give information \
about processes using the /proc filesystem. The package \
includes the programs ps, top, vmstat, w, kill, and skill."
SECTION = "base"
PRIORITY = "optional"
DEPENDS = "ncurses"

SRC_URI = "http://procps.sourceforge.net/procps-${PV}.tar.gz \
           file://procps_${PV}-2.diff;patch=1 \
           file://install.patch;patch=1"

inherit autotools

EXTRA_OEMAKE = "CFLAGS=-I${STAGING_INCDIR} \
                LDFLAGS=-L${STAGING_LIBDIR} -Wl,--rpath-link,${STAGING_LIBDIR} \
                CURSES=-lncurses \
                install='install -D' \
                ldconfig=echo"
