DESCRIPTION = "Configuration file for kexecboot"
SECTION = "base"
LICENSE = "GPL"
PR = "r11"

SRC_URI = "file://icon.xpm"

CMDLINE_DEBUG = "${@base_conditional('DISTRO_TYPE', 'release', 'quiet', 'debug',d)}"

CMDLINE_akita = "console=ttyS0,115200n8 console=tty1 fbcon=rotate:1 ${CMDLINE_DEBUG}"
CMDLINE_ben-nanonote = "console=ttyS0,57600n8 console=tty0 mem=32M ${CMDLINE_DEBUG}"
CMDLINE_c7x0 = "console=ttyS0,115200n8 console=tty1 ${CMDLINE_DEBUG}"
CMDLINE_collie = "console=ttySA0,115200n8 console=tty1 mem=64M ${CMDLINE_DEBUG}"
CMDLINE_poodle = "console=ttyS0,115200n8 console=tty1 fbcon=rotate:1 ${CMDLINE_DEBUG}"
CMDLINE_qemuarm = "console=ttyAMA0,115200n8 console=tty1 ${CMDLINE_DEBUG}"
CMDLINE_spitz = "console=ttyS0,115200n8 console=tty1 fbcon=rotate:1 ${CMDLINE_DEBUG}"
CMDLINE_tosa = "console=ttyS0,115200n8 console=tty1 ${CMDLINE_DEBUG}"

do_configure_prepend () {
    install -m 0644 ${WORKDIR}/icon.xpm ${S}
}

do_install_prepend () {
echo '# First kernel stanza.
# Specify full kernel path on target.
KERNEL=/boot/${KERNEL_IMAGETYPE}

# Show this label in kexecboot menu.
LABEL=${DISTRO}-${MACHINE}
#
# Append this tags to the kernel cmdline.
APPEND=${CMDLINE}
#
# Specify optional initrd/initramfs.
# INITRD=/boot/initramfs.cpio.gz
#
# Specify full path for a custom icon for the menu-item.
# If not set, use device-icons as default (NAND, SD, CF, ...).
# ICON=/boot/icon.xpm
#
# Priority of item in kexecboot menu.
# Items with highest priority will be shown at top of menu.
# Default: 0 (lowest, ordered by device ordering)
# PRIORITY=10
#
#
# Second kernel stanza.
# KERNEL=/boot/${KERNEL_IMAGETYPE}-test
# LABEL=${DISTRO}-${MACHINE}-test
# APPEND=${CMDLINE}
#' >> ${S}/boot.cfg
}

do_install () {
        install -d ${D}/boot
        install -m 0644 boot.cfg ${D}/boot/boot.cfg
        install -m 0644 icon.xpm ${D}/boot/icon.xpm
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} += "/boot/*"
