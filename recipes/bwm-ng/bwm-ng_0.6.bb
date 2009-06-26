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
