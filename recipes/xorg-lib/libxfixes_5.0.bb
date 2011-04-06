require xorg-lib-common.inc
DESCRIPTION = "X Fixes extension library."
LICENSE = "BSD-X"
DEPENDS += "virtual/libx11 xproto fixesproto xextproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "678071bd7f9f7467e2fc712d81022318"
SRC_URI[archive.sha256sum] = "537a2446129242737a35db40081be4bbcc126e56c03bf5f2b142b10a79cda2e3"

BBCLASSEXTEND = "native"

XORG_PN = "libXfixes"
