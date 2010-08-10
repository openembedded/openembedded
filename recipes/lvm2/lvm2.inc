SECTION = "utils"
DESCRIPTION = "LVM2 is a set of utilities to manage logical volumes in Linux."
LICENSE = "GPL"
DEPENDS = "device-mapper"
INC_PR = "r2"

S = "${WORKDIR}/LVM2.${PV}"
SRC_URI = "ftp://sources.redhat.com/pub/lvm2/old/LVM2.${PV}.tgz \
           file://crosscompile_fix.patch \
           file://include-limits.patch \
           file://lvm.conf"

# Unset user/group to unbreak install.
EXTRA_OECONF = "--with-user= --with-group= --disable-o_direct"

inherit autotools

# We don't need to stage anything (the executables are no needed at build time by any
# other recipe)
do_stage() {
}

do_install_append() {
    # Install machine specific configuration file
    install -m 0644 ${WORKDIR}/lvm.conf ${D}${sysconfdir}/lvm/lvm.conf
}
