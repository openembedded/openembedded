require xorg-lib-common.inc

DESCRIPTION = "X Composite extension library."
LICENSE= "BSD-X"
DEPENDS += " compositeproto virtual/libx11 libxfixes libxext"
PROVIDES = "xcomposite"
PE = "1"

XORG_PN = "libXcomposite"

SRC_URI[archive.md5sum] = "e38dc98509149083f6c31b49b484e63c"
SRC_URI[archive.sha256sum] = "442bde0bf7684330d6f5e4dd5a6faa46f1950512ff4e7bb6c01b36702166f800"
