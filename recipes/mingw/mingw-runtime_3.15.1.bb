require mingw-runtime.inc

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/mingw/mingwrt-${PV}-mingw32-src.tar.gz"

S = "${WORKDIR}/mingwrt-${PV}-mingw32"

SRC_URI[md5sum] = "0411b98fd5eeac0706e2abb7122526bb"
SRC_URI[sha256sum] = "4f4d19f3e15fdf00957932211be609b6bf4e689ad5938ce7bff666a638bde0e7"
