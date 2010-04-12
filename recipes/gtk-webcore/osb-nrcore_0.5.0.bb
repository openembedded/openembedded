require osb-nrcore.inc

PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/gtk-webcore/osb-nrcore-${PV}.tar.gz \
           file://KWQDictImpl.patch;patch=1"

SRC_URI[md5sum] = "16d9a9a322025cae1a7fe8225690695a"
SRC_URI[sha256sum] = "39123e386671e18873392fe221616bbfc2be5ca6ddc3660d6cc001a6aa1f59a8"
