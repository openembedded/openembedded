DESCRIPTION = "A Framebuffer VNC Server for PDA"
AUTHOR = "Patrik Gfeller <gfellerpatrik@gmx.net>"
HOMEPAGE = "http://fbvncserver.sourceforge.net/"
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "libvncserver jpeg zlib gmp tslib"
RRECOMMENDS = "kernel-modules-uinput kernel-module-keybdev"
RCONFLICTS = "fbvncserver, fbvncserver-kmodule"
PV = "0.0.0+cvs${SRCDATE}"
PR = "r0"

SRC_URI = "cvs://anonymous@fbvncserver.cvs.sourceforge.net/cvsroot/fbvncserver;method=pserver;module=ipkg"
S = "${WORKDIR}/ipkg/src/"

inherit autotools

EXTRA_OECONF = "--enable-debug"

FILES_${PN} += "${datadir}"

