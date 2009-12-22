require coreutils-${PV}.inc
require coreutils-target.inc

PR = "r3"

SRC_URI += "\
  file://man.patch;patch=1 \
  file://oe-old-tools.patch;patch=1 \
"
