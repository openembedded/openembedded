SECTION = "utils"
DESCRIPTION = "LVM2 is a set of utilities to manage logical volumes in Linux."
LICENSE = "GPL"
PR = "r1"
DEPENDS = "device-mapper"

S = "${WORKDIR}/LVM2.${PV}"

SRC_URI = "ftp://sources.redhat.com/pub/lvm2/old/LVM2.${PV}.tgz"

SRC_URI[md5sum] = "ed6fe3b734d05c6497cfa4f9932046e6"
SRC_URI[sha256sum] = "f72b5868f8ab4c6d5ba4cd470e33ef8d916e9c6c1363a7ae48aefd9361e5fc90"

inherit autotools

