DESCRIPTION = "ATA over Ethernet Tools"
SECTION = "console/network"
RRECOMMENDS = "kernel-module-aoe"
PR = "r0"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "6a77c8a017ef8dc0a5310db944b30035"
SRC_URI[sha256sum] = "caba504ca4f769c5f3f8b4e97ed0da1888bd0be2efd3c33cac9bf36e7c285bc3"
