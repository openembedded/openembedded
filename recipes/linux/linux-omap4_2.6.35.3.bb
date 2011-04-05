COMPATIBLE_MACHINE = "omap4430-panda|am45x-evm"

require multi-kernel.inc

CORTEXA8FIXUP = "no"

SRCREV = "ti-ubuntu-2.6.35-980.1release13"

SRC_URI = "git://dev.omapzoom.org/pub/scm/integration/kernel-ubuntu.git;protocol=git;branch=ti-ubuntu-L24.11 \
           file://0001-tiler-avoid-lock-ups-due-to-unmapped-DMM-entries.patch \
           file://0002-ARM-Add-prompt-for-CONFIG_ALIGNMENT_TRAP.patch \
           file://0003-ARM-Print-warning-on-alignment-trap-in-kernel-mode.patch \
           file://0004-ARM-Expose-some-CPU-control-registers-via-sysfs.patch \
           file://0005-ARM-Add-option-to-allow-userspace-PLE-access.patch \
           file://0006-ARM-Add-option-to-allow-userspace-access-to-performa.patch \
           file://0007-OMAP4-do-not-force-select-options-which-are-not-requ.patch \
           file://0008-omap4-pandaboard-add-support-for-DVI-output.patch \
	   file://0001-UBUNTU-Config-Fix-FTBS-caused-by-new-binutils.patch \
	   file://0002-Add-AFLAGS-for-sleep44xx-to-fix-FTBS.patch \
           file://defconfig"

S = "${WORKDIR}/git"
