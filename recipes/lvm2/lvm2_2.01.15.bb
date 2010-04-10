SECTION = "utils"
DESCRIPTION = "LVM2 is a set of utilities to manage logical volumes in Linux."
LICENSE = "GPL"
PR = "r1"
DEPENDS = "device-mapper"

S = "${WORKDIR}/LVM2.${PV}"

SRC_URI = "ftp://sources.redhat.com/pub/lvm2/LVM2.${PV}.tgz \
           file://crosscompile_fix.patch;patch=1"

# Unset user/group to unbreak install.
EXTRA_OECONF = "--with-user= --with-group= --disable-o_direct"
EXTRA_OECONF_arm = "--with-user= --with-group= --disable-o_direct"
inherit autotools


SRC_URI[md5sum] = "c71654baff263254fb5a226624ee8ef3"
SRC_URI[sha256sum] = "80b47604ace83db4450f43d94a99fdf2ca317323fde8a591f57290d28ece7d3b"
