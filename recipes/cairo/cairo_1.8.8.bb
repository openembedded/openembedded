PR = "r1"

require cairo.inc

SRC_URI = "http://cairographics.org/releases/cairo-${PV}.tar.gz \
           file://dolt-fix.patch;patch=1 \
          "



SRC_URI[md5sum] = "d3e1a1035ae563812d4dd44a74fb0dd0"
SRC_URI[sha256sum] = "3c51d3de5dc4596e01a6675acd3c86c2c99c00f02e8fad5493758a29fe451c90"
