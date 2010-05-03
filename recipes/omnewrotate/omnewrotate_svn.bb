DESCRIPTION = "OpenMoko New Rotate is a screen rotation program"
HOMEPAGE = "http://code.google.com/p/omnewrotate/"
AUTHOR = "Rui Seabra"
LICENSE = "GPLv3"
SECTION = "console/network"
DEPENDS = "libframeworkd-glib xrandr"

SRCREV = "66"

PV = "0.5.8+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://omnewrotate.googlecode.com/svn;module=trunk;proto=http \
           file://xsession.script.patch;patch=1"

S = "${WORKDIR}/trunk"

CONFFILES_${PN} = "${sysconfdir}/default/omnewrotate.conf"

inherit autotools
