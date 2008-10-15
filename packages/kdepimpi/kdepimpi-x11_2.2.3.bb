SRC_URI = "${SOURCEFORGE_MIRROR}/kdepimpi/kdepimpi-${PV}.tar.gz \
file://libkcal.patch;patch=1 \
file://kabc.patch;patch=1 \
file://kammu.patch;patch=1 \
file://korganizer.patch;patch=1 \
file://nomail.patch;patch=1 \
"

include kdepimpi-base.inc
include kdepimpi-x11.inc

PR = "r1"
