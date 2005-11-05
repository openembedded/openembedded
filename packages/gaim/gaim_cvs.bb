PR = "r0"
PV = "2.0+cvs-${CVSDATE}"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/gaim;module=gaim \
	file://no-superimposed-version-on-logo.patch;patch=1 \
	file://desktop-name-2.0.0.patch;patch=1 \
	"

include gaim.inc

S = "${WORKDIR}/gaim"

CFLAGS += "-D_GNU_SOURCE"


DEPENDS += "startup-notification"

#include autopoint (gettext)
EXTRA_AUTORECONF = ""

#disable "X Session Management"... It is EVIL
EXTRA_OECONF += "--disable-sm --enable-startup-notification"
