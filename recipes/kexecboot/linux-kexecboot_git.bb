require linux-kexecboot.inc

KERNEL_RELEASE = "2.6.35-rc3"
SRCREV = "7e27d6e778cd87b6f2415515d7127eba53fe5d02"
PV = "${KERNEL_RELEASE}+gitr${SRCPV}"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
            file://use-noclone-attribute-for-naked.patch;status=pending \
           file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
