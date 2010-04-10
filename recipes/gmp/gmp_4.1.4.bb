require gmp.inc

PR = "r1"

SRC_URI += "file://sh4-asmfix.patch;patch=1"
SRC_URI[gmp.md5sum] = "0aa7d3b3f5b5ec5951e7dddd6f65e891"
SRC_URI[gmp.sha256sum] = "1a6ed0ea17b24ea8864c4df516d20c41fac97a448559ddee5a8477aeeecca1a3"
