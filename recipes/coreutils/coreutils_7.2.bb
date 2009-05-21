require coreutils-${PV}.inc
require coreutils-target.inc

PR = "r0"

SRC_URI += "file://automake-version.patch;patch=1 \
            file://man.patch;patch=1"
