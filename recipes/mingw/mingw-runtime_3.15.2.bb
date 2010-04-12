require mingw-runtime.inc

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/mingw/mingwrt-${PV}-mingw32-src.tar.gz"

S = "${WORKDIR}/mingwrt-${PV}-mingw32"

SRC_URI[md5sum] = "7bf0525f158213f3ac990ea68a5ec34d"
SRC_URI[sha256sum] = "64d7c31354d318ec2085e39e724287c78742a66302fd0b27dab7a3f705d5c54d"
