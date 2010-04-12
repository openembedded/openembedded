require coreutils-${PV}.inc
require coreutils-target.inc

PR = "r0"

SRC_URI += "file://automake-version.patch;patch=1 \
            file://man.patch;patch=1"

SRC_URI[md5sum] = "427c2914d3eab956f317c9ec6a45e62a"
SRC_URI[sha256sum] = "dd77bfec92e5a3ad48abd8a5bda3f8d40149c4e24744e4173abc3cc6a731fdb2"
