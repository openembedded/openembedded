DEPENDS = "ti-tilermemmgr"

LICENSE = "BSD"

PV = "2.0"
PR = "${MACHINE_KERNEL_PR}"
PR_append = "-24.11a+gitr${SRCREV}"

# ti-syslink-mpu-rls-24.11-p1 tag
SRCREV = "16f0cebd8b5a430d943bc6bcfa0fe592bad425b9"
SRC_URI = "git://git.omapzoom.org/platform/hardware/ti/syslink.git;protocol=git;branch=syslink-2.0"

inherit autotools

export ARCH = "${TARGET_ARCH}"
export CROSS_COMPILE = "${TARGET_PREFIX}"
export TILER_INC_PATH= "${STAGING_INCDIR}/memmgr"
#export KRNLSRC = "${STAGING_KERNELDIR}"

S = "${WORKDIR}/git/syslink/"

