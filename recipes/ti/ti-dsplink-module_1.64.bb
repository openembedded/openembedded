require ti-dsplink-module.inc

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/DSPLink/${PV}/exports/dsplink_linux_${PV}.tar.gz;name=dsplinktarball \
                   file://loadmodules-ti-dsplink-apps.sh \
                   file://unloadmodules-ti-dsplink-apps.sh"

SRC_URI[dsplinktarball.md5sum] = "90223da7c88af57d12936adeba1a0661"
SRC_URI[dsplinktarball.sha256sum] = "32b6fbae2b61f5f71ab3eae9d2f5ad6b75d682ad8bde9963152830be1f8d286b"

# tconf from xdctools dislikes '.' in pwd :/
PE = "1"
PV = "1_64"
S = "${WORKDIR}/dsplink_linux_${PV}"

# Cheat a bit with includes
# SZ_1k = 0x00000400
# /OE/angstrom-dev/work/beagleboard-angstrom-linux-gnueabi/ti-dsplink-module-1_64-r50/dsplink_linux_1_64/dsplink/gpp/src/../../gpp/src/arch/OMAP3530/shmem/Linux/omap3530_phy_shmem.c:127: error: 'SZ_2K' undeclared (first use in this function)

do_compile_prepend() {
    sed -i s:SZ_2K:0x00000800:g ${S}/dsplink/gpp/src/arch/OMAP3530/shmem/Linux/omap3530_phy_shmem.c
}


