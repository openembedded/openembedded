require coreutils-${PV}.inc
require coreutils-target.inc

PR = "r0.1"

SRC_URI += "file://automake-version.patch;patch=1 \
            file://man.patch;patch=1"

SRC_URI[md5sum] = "cbb2b3d1718ee1237b808e00b5c11b1e"
SRC_URI[sha256sum] = "813cb19fa19a885f342664109c7c5810f0081b624ff317bba8d1b6ccd83c2a05"
