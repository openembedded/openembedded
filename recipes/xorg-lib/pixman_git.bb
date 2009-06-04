SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "Low-level pixel manipulation library."
LICENSE = "X11"

PV = "0.15.8"
PR = "r1"
PR_append = "+gitr${SRCREV}"

SRCREV = "3c570a815afb282df01f41acad385ff0e3e33899"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://anongit.freedesktop.org/pixman;protocol=git \
file://0041-Fix-filler-bug.patch;patch=1 \
file://0042-Really-fix-filler-bug.patch;patch=1 \
"

S = "${WORKDIR}/git"

inherit autotools_stage

AUTOTOOLS_STAGE_PKGCONFIG = "1"

