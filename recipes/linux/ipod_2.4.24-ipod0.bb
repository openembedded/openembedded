SECTION = "kernel"
DESCRIPTION = "Linux kernel for Ipods"
LICENSE = "GPLv2"
KV = "2.4.24"
PV = "${KV}-ipod0"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.4/linux-${KV}.tar.bz2 \
           http://www.uclinux.org/pub/uClinux/uClinux-2.4.x/uClinux-2.4.24-uc0.diff.gz;patch=1 \
           ${SOURCEFORGE_MIRROR}/ipodlinux/uclinux-2.4.24-ipod0.patch.gz;patch=1  "

S = "${WORKDIR}/linux-${KV}"

COMPATIBLE_MACHINE = "ipod"

inherit kernel

EXTRA_OEMAKE = ""
do_configure_prepend() {
        install -m 0644 ${S}/arch/armnommu/def-configs/ipod ${S}/.config
}

do_compile() {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
        oe_runmake
}
