DESCRIPTION = "Python applets manager"
SECTION = "x11"
LICENSE = "GPL"
DEPENDS += "python-pygame virtual/libsdl libsdl-image python-dbus python-pygobject"                                   
PV = "0.1+svnr${SRCREV}"
PR = "r0.01"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot;module=tichy;proto=http"
S = "${WORKDIR}/tichy"

inherit distutils

FILES_${PN} += "${datadir}"
RDEPENDS_${PN} += "python-pygame"
# This is because pkg-config --libs --cflags sdl doesn't return the correct path (bug in libsdl recipe ?)
CFLAGS += -I${STAGING_INCDIR}/SDL
