SECTION = "utils"
DESCRIPTION = "LVM2 is a set of utilities to manage logical volumes in Linux."
MAINTAINER = "Dan Williams <dan.j.williams@gmail.com>"
LICENSE = "GPL"
PR = ""
DEPENDS = "device-mapper"

S = "${WORKDIR}/LVM2.${PV}"

SRC_URI = "ftp://sources.redhat.com/pub/lvm2/LVM2.${PV}.tgz"

# Unset user/group to unbreak install.
EXTRA_OECONF = "--with-user= --with-group= --disable-o_direct"
EXTRA_OECONF_arm = "--with-user= --with-group= --disable-o_direct"
inherit autotools

