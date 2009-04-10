DESCRIPTION = "Python applets manager"
SECTION = "x11"
LICENSE = "GPL"
DEPENDS += "python-pygame virtual/libsdl libsdl-image python-dbus python-pygobject"                                   
PV = "0.2+svnr${SRCREV}"
PR = "r1"

SRC_URI = "svn://tichy.googlecode.com/svn/;module=trunk;proto=http"
S = "${WORKDIR}/tichy"

inherit distutils

FILES_${PN} += "${datadir}"
RDEPENDS_${PN} += "python-pygame"
# This is because pkg-config --libs --cflags sdl doesn't return the correct path (bug in libsdl recipe ?)
CFLAGS += -I${STAGING_INCDIR}/SDL
