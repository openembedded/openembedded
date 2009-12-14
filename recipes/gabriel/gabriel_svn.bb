DESCRIPTION = "Gabriel is a small utility to enable D-Bus clients to connect to a D-Bus \
daemon running on a remote machine, through SSH. In simple words, gabriel is a proxy for \
a dbus daemon running on a remote machine."
LICENSE = "GPL"
DEPENDS = "libssh glib-2.0 dbus dbus-glib"
SECTION = "console/network"
PV = "0.0.0+svnr${SRCPV}"

SRC_URI = "svn://gabriel.svn.sourceforge.net/svnroot/gabriel;module=gabriel;proto=https"
S = "${WORKDIR}/gabriel"

inherit autotools_stage

RDEPENDS = "socat"
