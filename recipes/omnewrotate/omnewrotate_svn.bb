DESCRIPTION = "OpenMoko New Rotate is a screen rotation program"
HOMEPAGE = "http://code.google.com/p/omnewrotate/"
AUTHOR = "Rui Seabra"
LICENSE = "GPLv3"
SECTION = "console/network"
DEPENDS = "libframeworkd-glib xrandr"

SRCREV = "61"

PV = "0.5.7+svnr${SRCPV}"
PR = "r0"

SRC_URI = "svn://omnewrotate.googlecode.com/svn;module=trunk;proto=http \
           file://correct-sysfs-bl-path.patch;patch=1;maxrev=55 \
"

S = "${WORKDIR}/trunk"

inherit autotools
