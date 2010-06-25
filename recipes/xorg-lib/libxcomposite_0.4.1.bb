require xorg-lib-common.inc
DESCRIPTION = "X Composite extension library."
LICENSE = "BSD-X"
DEPENDS += " compositeproto virtual/libx11 libxfixes libxext"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "0f1367f57fdf5df17a8dd71d0fa68248"
SRC_URI[archive.sha256sum] = "3715a25565222d8eb0468805db1113b514128ee5e9bc6908400f189f680d7a13"

XORG_PN = "libXcomposite"
