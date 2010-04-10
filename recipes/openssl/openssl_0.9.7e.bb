require openssl.inc

PR = "${INC_PR}.0"

SRC_URI += "file://debian.patch;patch=1 \
            file://armeb.patch;patch=1 \
            file://gnueabi-arm.patch;patch=1"

SRC_URI[src.md5sum] = "a8777164bca38d84e5eb2b1535223474"
SRC_URI[src.sha256sum] = "25121b5dbd2b830929519325e033086ce45861cff2d0000d928f48261b1e0b7c"
