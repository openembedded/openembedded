require bitbake.inc

PV = "1.9.0+svn${SRCDATE}"
PR = "r0"

# Don't use the tip of svn by default
DEFAULT_PREFERENCE = "-1"

SRC_URI = "svn://svn.berlios.de/bitbake/trunk;module=bitbake"

S = "${WORKDIR}/bitbake"
