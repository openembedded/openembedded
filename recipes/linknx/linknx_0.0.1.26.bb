PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/linknx/linknx-${PV}.tar.gz \
           file://logger-initialisations.patch;patch=1 \
           "

require linknx.inc