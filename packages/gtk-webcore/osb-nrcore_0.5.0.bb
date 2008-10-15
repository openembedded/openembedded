require osb-nrcore.inc

FILE_PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/gtk-webcore/osb-nrcore-${PV}.tar.gz \
           file://KWQDictImpl.patch;patch=1"
