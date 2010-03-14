require ti-dsplink.inc

PE = "1"
PV = "1_64"

SRC_URI[dsplinktarball.md5sum] = "90223da7c88af57d12936adeba1a0661"
SRC_URI[dsplinktarball.sha256sum] = "32b6fbae2b61f5f71ab3eae9d2f5ad6b75d682ad8bde9963152830be1f8d286b"

SRC_URI_append = "file://dsplink_1_64_kernel_2_6_33_autoconf.patch;patch=1 \
                  file://dsplink_1_64_add_dm6446_build_support.patch;patch=1 \
                  file://dsplink_1_64_add_omapl137_build_support.patch;patch=1 "

# Cheat a bit with includes
# SZ_1k = 0x00000400
# ../gpp/src/arch/OMAP3530/shmem/Linux/omap3530_phy_shmem.c:127: error: 'SZ_2K' undeclared (first use in this function)

do_compile_prepend() {
    sed -i s:SZ_2K:0x00000800:g ${S}/dsplink/gpp/src/arch/OMAP3530/shmem/Linux/omap3530_phy_shmem.c
}


