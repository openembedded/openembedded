SRC_URI = "${SOURCEFORGE_MIRROR}/kdepimpi/kdepimpi-${PV}.tar.gz "
SRC_URI_append = "file://opie-fontselector-copy.patch;patch=1"

include pwmpi.inc
