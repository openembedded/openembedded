DESCRIPTION = "suite of utilities for programming Xilinx FPGAs, CPLDs, and EEPROMs"
LICENSE = "GPL"
HOMEPAGE = "http://sourceforge.net/projects/xc3sprog"
SECTION = "console/utils"

DEPENDS += "libftdi libusb"

SRC_URI = "svn://${PN}.svn.sourceforge.net/svnroot/${PN};module=trunk;proto=https"
SRCREV = ${PV}

SRC_URI[md5sum] = "916f65fa68d154621fc0cf1f405f2726"
SRC_URI[sha256sum] = "5b6f3c3ee51c6aa24d3b87135e01762cf68821d1c3599d87d349fea4ede74c62"

S = "${WORKDIR}/trunk"
PR = "r0"

inherit cmake

