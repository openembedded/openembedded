require libgee.inc

SRCREV = "3c3af3ecc99bc130643c2b372164e987a5a261a9"
PV = "0.5.1+gitr${SRCPV}"
PE = "1"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "\
  git://git.gnome.org/libgee;protocol=git;branch=master \
"
S = "${WORKDIR}/git"
