require linux.inc

# Linux kernel using the PREEMPT RT patch

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mpc8315e-rdb = "1"
DEFAULT_PREFERENCE_efika = "1"

PR = "r4"

#KERNEL_IMAGETYPE_efika = "Image"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.25.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-2.6.25.4.bz2;patch=1;name=stablepatch \
           ${KERNELORG_MIRROR}/pub/linux/kernel/projects/rt/older/patch-2.6.25.4-rt6.bz2;patch=1;name=rtpatch \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.25"



SRC_URI[kernel.md5sum] = "db95a49a656a3247d4995a797d333153"
SRC_URI[kernel.sha256sum] = "108b2a3f2b05c0e57d1d0977619525e46f8d4b425aef4b38b47dcf94292f2dd2"
SRC_URI[stablepatch.md5sum] = "f12f43dd78b765f3d1402aa9d2170cf5"
SRC_URI[stablepatch.sha256sum] = "5bad39b0d28f294f10690d15bc1e54ba549324a7ce26db1406f3c3a50cd1d504"
SRC_URI[rtpatch.md5sum] = "be6ff6fc5eb746e66a1a15629d05bedd"
SRC_URI[rtpatch.sha256sum] = "513dd1ef58c6f3b2668731f078fb16df2e2152f5a7b66d153c2d41c4dca5b186"
