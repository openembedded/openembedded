SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "Low-level pixel manipulation library."
LICENSE = "X11"

PV = "0.15.8"
PR_append = "+gitr${SRCREV}"

SRCREV = "a673a898e1e119836c9c68eff71feaec49f97bf1"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://anongit.freedesktop.org/pixman;protocol=git"

S = "${WORKDIR}/git"

inherit autotools_stage

AUTOTOOLS_STAGE_PKGCONFIG = "1"

