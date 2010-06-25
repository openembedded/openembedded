require xorg-lib-common.inc
DESCRIPTION = "X Composite extension library."
LICENSE = "BSD-X"
DEPENDS += " compositeproto virtual/libx11 libxfixes libxext"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI += " file://change-include-order.patch"
SRC_URI[archive.md5sum] = "7e95395dea89be21bae929b9b7f16641"
SRC_URI[archive.sha256sum] = "7db759e82dd1f68094e4c4d257025f7893dafb2913ed249e00cbe18fa13c7510"

XORG_PN = "libXcomposite"
