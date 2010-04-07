DESCRIPTION = "Python applets manager"
SECTION = "x11"
LICENSE = "GPL"
DEPENDS += "python-pygame virtual/libsdl libsdl-image python-dbus python-pygobject"                                   
SRCREV = "ab68d849502009cf3214df48ffa8075a10cc2177"
PV = "0.2+gitr${SRCREV}"
PR = "r0"

SRC_URI = "git://git.openmoko.org/git/tichy.git;protocol=git"
S = "${WORKDIR}/git"

inherit distutils

FILES_${PN} += "${datadir}"
RDEPENDS_${PN} += "python-pygame"
# This is because pkg-config --libs --cflags sdl doesn't return the correct path (bug in libsdl recipe ?)
CFLAGS += -I${STAGING_INCDIR}/SDL
