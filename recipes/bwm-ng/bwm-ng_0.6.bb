DESCRIPTION = "Lightweight console network and disk bandwidth monitor"
LICENSE = "GPLv2"
DEPENDS = "ncurses"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/bwmng/bwm-ng-${PV}.tar.gz"

inherit autotools

# Use /proc/net/dev and /proc/diskstats rather than full libstatgrab.
# Disable netstat -i parser as it's not compatible with busybox netstat.
EXTRA_OECONF = " \
    --with-procnetdev --with-diskstats \
    --with-libstatgrab=no \
    --with-netstatlinux=no \
"

SRC_URI[md5sum] = "d3a02484fb7946371bfb4e10927cebfb"
SRC_URI[sha256sum] = "c1134358e268329d438b0996399003b0f0b966034fb4b5b138761c2f3c62ffdd"
