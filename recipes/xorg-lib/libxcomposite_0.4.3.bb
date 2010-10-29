require xorg-lib-common.inc
DESCRIPTION = "X Composite extension library."
LICENSE = "BSD-X"
DEPENDS += " compositeproto virtual/libx11 libxfixes libxext"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "a60e0b5c276d0aa9e2d3b982c98f61c8"
SRC_URI[archive.sha256sum] = "32294d28f4ee46db310c344546d98484728b7d52158c6d7c25bba02563b41aad"

XORG_PN = "libXcomposite"
