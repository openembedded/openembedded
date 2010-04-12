SECTION = "kernel"
DESCRIPTION = "Linux kernel for Ipods"
LICENSE = "GPLv2"
KV = "2.4.24"
PV = "${KV}-ipod0"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.4/linux-${KV}.tar.bz2;name=kernel \
           http://www.uclinux.org/pub/uClinux/uClinux-2.4.x/uClinux-2.4.24-uc0.diff.gz;patch=1;name=uclinupatch \
           ${SOURCEFORGE_MIRROR}/ipodlinux/uclinux-2.4.24-ipod0.patch.gz;patch=1;name=ipodpatch  "

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

SRC_URI[kernel.md5sum] = "1e055c42921b2396a559d84df4c3d9aa"
SRC_URI[kernel.sha256sum] = "9a6c37e048376cd2a9845f6f75cb44fb27c244d719e9d9dd81063a525f081e1f"
SRC_URI[uclinupatch.md5sum] = "cd8a3b23299305761c5b3b3f81dd017a"
SRC_URI[uclinupatch.sha256sum] = "c409609ce3bdf5bc4c040aa17ec28c6c214695a6aaaa408643edbda704142fcf"
SRC_URI[ipodpatch.md5sum] = "5d16f569d2a18b6536749cc2b229649d"
SRC_URI[ipodpatch.sha256sum] = "43604951abb43246ccd6b6e7b6935f92322f9313ded99044057b241a2a20b07b"
