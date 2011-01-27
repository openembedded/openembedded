require file.inc
DEPENDS_virtclass-native += "zlib-native"
PR = "${INCPR}.2"

SRC_URI += "file://reloc.patch"
SRC_URI[md5sum] = "accade81ff1cc774904b47c72c8aeea0"
SRC_URI[sha256sum] = "4c9e6e7994e74cb3386374ae91b055d26ac96b9d3e82fd157ae2d62e87a4260c"
