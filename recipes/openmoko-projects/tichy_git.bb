DESCRIPTION = "Python applets manager"
SECTION = "x11"
LICENSE = "GPL"
DEPENDS += "python-pygame virtual/libsdl libsdl-image python-dbus python-pygobject"                                   
PV = "0.2+gitr${SRCREV}"
PR = "r0"

SRC_URI = "git://git.openmoko.org/git/tichy.git;protocol=git"
S = "${WORKDIR}/git"

inherit distutils

FILES_${PN} += "${datadir}"
RDEPENDS_${PN} += "python-pygame"
# This is because pkg-config --libs --cflags sdl doesn't return the correct path (bug in libsdl recipe ?)
CFLAGS += -I${STAGING_INCDIR}/SDL
