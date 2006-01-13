PR = "r0"
#Remove the dash below when 2.0 changes in PV
PV = "2.0+cvs-${SRCDATE}"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/gaim;module=gaim \
	file://no-superimposed-version-on-logo.patch;patch=1 \
	file://desktop-name-cvs.patch;patch=1 \
	file://gtk-deprecated-2.0.0.patch;patch=1 \
	"

include gaim.inc

S = "${WORKDIR}/gaim"

CFLAGS += "-D_GNU_SOURCE"


DEPENDS += "startup-notification"

#include autopoint (gettext)
EXTRA_AUTORECONF = ""

#disable "X Session Management"... It is EVIL
EXTRA_OECONF += "--disable-sm --enable-startup-notification"
