require flex.inc
PR = "r5"

SRC_URI = "${SOURCEFORGE_MIRROR}/flex/flex-${PV}.tar.bz2 \
           file://flex-lvalue.diff;patch=1 \
           file://fix-gen.patch;patch=1 \
           file://include.patch;patch=1"


BBCLASSEXTEND = "native"

SRC_URI[md5sum] = "363dcc4afc917dc51306eb9d3de0152f"
SRC_URI[sha256sum] = "701353279a17655d78e3b3678ad78d0375f5bf45877ad8b3507d589c42427f26"
