DESCRIPTION = "OpenMoko New Rotate is a screen rotation program"
HOMEPAGE = "http://code.google.com/p/omnewrotate/"
AUTHOR = "Rui Seabra"
LICENSE = "GPLv3"
SECTION = "console/network"
DEPENDS = "libframeworkd-glib xrandr"

SRCREV = "69"

PV = "0.5.9+svnr${SRCPV}"

SRC_URI = "svn://omnewrotate.googlecode.com/svn;module=trunk;proto=http"

S = "${WORKDIR}/trunk"

CONFFILES_${PN} = "${sysconfdir}/default/omnewrotate.conf"

inherit autotools
