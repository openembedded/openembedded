require xorg-lib-common.inc
DESCRIPTION = "X Resize and Rotate extension library."
LICENSE = "BSD-X"
DEPENDS += " virtual/libx11 randrproto libxext xextproto libxrender renderproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "962946952a01650bb43206043a3c0e12"
SRC_URI[archive.sha256sum] = "ba5adedc37da835a5c9e5a5d457dce13feead64fc364bc4719c41720ca0a3c50"

BBCLASSEXTEND = "nativesdk"

XORG_PN = "libXrandr"
