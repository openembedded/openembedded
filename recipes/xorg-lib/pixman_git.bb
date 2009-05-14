SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "Low-level pixel manipulation library."
LICENSE = "X11"

PV = "0.15.2"
PR_append = "+gitr${SRCREV}"

SRCREV = "e74a2847ddcb3b4c1675efaaa923e78556277dff"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://anongit.freedesktop.org/pixman;protocol=git"

S = "${WORKDIR}/git"

inherit autotools_stage

AUTOTOOLS_STAGE_PKGCONFIG = "1"

