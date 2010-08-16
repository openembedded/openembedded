require xorg-lib-common.inc
DESCRIPTION = "X11 Resize and Rotate extension library"
LICENSE = "BSD-X"
DEPENDS += "randrproto libxrender libxext"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "1b244b5d19f0ccab01d7083436cd3558"
SRC_URI[archive.sha256sum] = "206f8dc850f12b1213fb73dbef09fafa1bb8fb8c3ddfe4d39721c1e2dec12a98"

BBCLASSEXTEND = "nativesdk"

XORG_PN = "libXrandr"
