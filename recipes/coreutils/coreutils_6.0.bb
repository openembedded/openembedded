require coreutils-${PV}.inc
require coreutils-target.inc

PR = "r3"

SRC_URI += "\
  file://man.patch;patch=1 \
  file://oe-old-tools.patch;patch=1 \
"

SRC_URI[md5sum] = "c15219721e6590fa13bf50af49e712c2"
SRC_URI[sha256sum] = "efa27532ec6dc12a21f703ad4a0f612e613e9cc2575147685db81cc701952ac9"
