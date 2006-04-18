inherit gpe

DESCRIPTION = "Touchscreen detection utility - without X support"
LICENSE = "GPL"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "base"

RCONFLICTS = "detect-stylus"

SRC_URI = "${GPE_MIRROR}/detect-stylus-${PV}.tar.gz \
           file://access.patch;patch=1;pnum=0 \
           file://extra-device-check.patch;patch=1 \
           file://correct-theme-name.patch;patch=1 \
           file://nox.patch;patch=1"
S = "${WORKDIR}/detect-stylus-${PV}"

export CVSBUILD = "no"
export NOX = "yes"
