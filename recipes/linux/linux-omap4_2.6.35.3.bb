COMPATIBLE_MACHINE = "omap4430-panda"

require multi-kernel.inc

CORTEXA8FIXUP = "no"

SRCREV = "35528f5b0481485654a6577306f7a80d9e6a5cf5"

SRC_URI = "git://dev.omapzoom.org/pub/scm/integration/kernel-ubuntu.git;protocol=git;branch=ti-ubuntu-L24.11 \
           file://0001-tiler-avoid-lock-ups-due-to-unmapped-DMM-entries.patch \
           file://0002-ARM-Add-prompt-for-CONFIG_ALIGNMENT_TRAP.patch \
           file://0003-ARM-Print-warning-on-alignment-trap-in-kernel-mode.patch \
           file://0004-ARM-Expose-some-CPU-control-registers-via-sysfs.patch \
           file://0005-ARM-Add-option-to-allow-userspace-PLE-access.patch \
           file://0006-ARM-Add-option-to-allow-userspace-access-to-performa.patch \
           file://0007-OMAP4-do-not-force-select-options-which-are-not-requ.patch \
           file://defconfig"

S = "${WORKDIR}/git"
