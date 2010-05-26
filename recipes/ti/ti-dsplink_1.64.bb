require ti-dsplink.inc

PE = "1"
PV = "1_64"

PV_DL_PATH = "sdo_sb/targetcontent/DSPLink/${PV}/exports"

SRC_URI[dsplinktarball.md5sum] = "90223da7c88af57d12936adeba1a0661"
SRC_URI[dsplinktarball.sha256sum] = "32b6fbae2b61f5f71ab3eae9d2f5ad6b75d682ad8bde9963152830be1f8d286b"

SRC_URI_append = "file://dsplink_1_64_kernel_2_6_33_autoconf.patch \
                  file://dsplink_1_64_add_dm6446_build_support.patch \
                  file://dsplink_1_64_add_omapl137_build_support.patch "


# Fix-up headers for latest kernels and remove bogus CROSS_COMPILE configuration

do_configure_prepend() {

    # asm/page.h is gone with linux-libc-headers 2.6.31.
    # We can safely sed it out since it has been empty for the past 2 years
    sed -i /page.h/d ${S}/dsplink/gpp/src/api/Linux/drv_api.c || true

    # Makefile passes hardcoded CROSS_COMPILE - rename so this doesnt get passed to kbuild
    sed -i -e s:CROSS_COMPILE:BOGUS_CROSS_COMPILE:g ${S}/dsplink/gpp/src/Rules.mk
}

# Cheat a bit with includes
# SZ_1k = 0x00000400
# ../gpp/src/arch/OMAP3530/shmem/Linux/omap3530_phy_shmem.c:127: error: 'SZ_2K' undeclared (first use in this function)

do_compile_prepend() {
    sed -i s:SZ_2K:0x00000800:g ${S}/dsplink/gpp/src/arch/OMAP3530/shmem/Linux/omap3530_phy_shmem.c
}

