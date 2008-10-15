SECTION = "utils"
DESCRIPTION = "LVM2 is a set of utilities to manage logical volumes in Linux."
LICENSE = "GPL"
FILE_PR = "r1"
DEPENDS = "device-mapper"

S = "${WORKDIR}/LVM2.${PV}"

SRC_URI = "ftp://sources.redhat.com/pub/lvm2/LVM2.${PV}.tgz"

inherit autotools

