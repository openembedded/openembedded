require linux-kexecboot.inc

KERNEL_RELEASE = "2.6.37-rc4"
OLD_KERNEL_RELEASE = "2.6.36"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}+gitr${SRCPV}"

SRCREV = "e8a7e48bb248a1196484d3f8afa53bded2b24e71"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
            file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
