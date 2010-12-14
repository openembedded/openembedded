COMPATIBLE_MACHINE = "omap4430-panda"

require multi-kernel.inc

CORTEXA8FIXUP = "no"

SRCREV = "6aba79f8f85b937596373cda8e266b823395996e"

SRC_URI = "git://kernel.ubuntu.com/ubuntu/ubuntu-maverick.git;protocol=git;branch=ti-omap4 \
           file://0001-ARM-Add-prompt-for-CONFIG_ALIGNMENT_TRAP.patch \
           file://0002-ARM-Print-warning-on-alignment-trap-in-kernel-mode.patch \
           file://0003-ARM-Expose-some-CPU-control-registers-via-sysfs.patch \
           file://0004-ARM-Add-option-to-allow-userspace-PLE-access.patch \
           file://0005-ARM-Add-option-to-allow-userspace-access-to-performa.patch \
           file://0006-OMAP4-do-not-force-select-options-which-are-not-requ.patch \
           file://0007-omap4-enable-L2-prefetching.patch \
           file://0008-tiler-avoid-lock-ups-due-to-unmapped-DMM-entries.patch \
           file://defconfig"

S = "${WORKDIR}/git"
