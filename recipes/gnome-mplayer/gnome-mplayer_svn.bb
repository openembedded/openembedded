require gnome-mplayer.inc

SRCREV = "1652"
PV = "0.9.9+svnr${SRCPV}"
PR = "${INC_PR}.0"
S = "${WORKDIR}/trunk"

SRC_URI = "svn://gnome-mplayer.googlecode.com/svn/;module=trunk;proto=http \
           file://default.patch;patch=1 \
"

# Untested
DEFAULT_PREFERENCE = "-1"

#hack, should use CXX to link:
LDFLAGS_append = " -lstdc++ "
