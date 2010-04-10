require kanatest.inc

PR = "r1"
SRC_URI = "${DEBIAN_MIRROR}/main/k/kanatest/${PN}_${PV}.orig.tar.gz \
        file://${PN}.desktop"

SRC_URI[md5sum] = "cd1eb1ce62a52cf69f4df9041a886794"
SRC_URI[sha256sum] = "559c3d5e9336a56c9f83fcece75ab5211e62a1a868b3a6f539e9b7bd15f46576"
