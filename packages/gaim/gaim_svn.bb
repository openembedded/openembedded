PR = "r0"
#Remove the dash below when 2.0 changes in PV
DEFAULT_PREFERENCE = "-100000"
PV = "1.9+2.0beta3cvs-${SRCDATE}"

SRC_URI = "svn://svn.sourceforge.net/svnroot/gaim;module=trunk;proto=https \
	file://no-superimposed-version-on-logo.patch;patch=1 \
	file://gtk-deprecated-2.0.0.patch;patch=1 \
	file://gevolution-eds-dbus.patch;patch=1 \
	"

include gaim.inc

S = "${WORKDIR}/trunk"

CFLAGS += "-D_GNU_SOURCE"


DEPENDS += "startup-notification"

#include autopoint (gettext)
EXTRA_AUTORECONF = ""

#disable "X Session Management"... It is EVIL
EXTRA_OECONF += "--disable-sm --enable-startup-notification"
