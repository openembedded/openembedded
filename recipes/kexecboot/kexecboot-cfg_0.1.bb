DESCRIPTION = "Configuration file for kexecboot"
SECTION = "base"
LICENSE = "GPL"
PR = "r10"

SRC_URI = "file://icon.xpm"

CMDLINE_CON = "console=ttyS0,115200n8 console=tty1 noinitrd"
CMDLINE_CON_collie = "console=ttySA0,115200n8 console=tty1 noinitrd rw"
CMDLINE_CON_qemuarm = "console=ttyAMA0,115200n8 console=tty1 noinitrd"
CMDLINE_CON_ben-nanonote = "console=ttyS0,57600n8 console=tty0"
CMDLINE_MEM = ""
CMDLINE_MEM_collie = "mem=64M"
CMDLINE_MEM_ben-nanonote = "mem=32M"
CMDLINE_ROTATE = ""
CMDLINE_ROTATE_spitz = "fbcon=rotate:1"
CMDLINE_ROTATE_akita = "fbcon=rotate:1"
CMDLINE_ROTATE_collie = "fbcon=rotate:1"
CMDLINE_ROTATE_poodle = "fbcon=rotate:1"
CMDLINE_OTHER = ""
CMDLINE_DEBUG = "${@base_conditional('DISTRO_TYPE', 'release', 'quiet', 'debug',d)}"
CMDLINE = "${CMDLINE_CON}"
CMDLINE += "${CMDLINE_MEM}"
CMDLINE += "${CMDLINE_ROTATE}"
CMDLINE += "${CMDLINE_OTHER}"
CMDLINE += "${CMDLINE_DEBUG}"

do_configure_prepend () {
    install -m 0644 ${WORKDIR}/icon.xpm ${S}
}
do_install_prepend () {
echo '# Show this label in kexecboot menu.
LABEL=${DISTRO}-${MACHINE}
#
# Specify full kernel path on target.
KERNEL=/boot/${KERNEL_IMAGETYPE}
#
# Append this tags to the kernel cmdline.
APPEND=${CMDLINE}
#
# Specify optional initrd/initramfs.
# INITRD=/boot/initramfs.cpio.gz
#
# Specify full path for a custom distro-icon for the menu-item.
# If not set, use device-icons as default (NAND, SD, CF, ...).
# ICON=/boot/icon.xpm
#
# Priority of item in kexecboot menu.
# Items with highest priority will be shown at top of menu.
# Default: 0 (lowest, ordered by device ordering)
# PRIORITY=10
#' >> ${S}/boot.cfg
}
do_install () {
        install -d ${D}/boot
        install -m 0644 boot.cfg ${D}/boot/boot.cfg
        install -m 0644 icon.xpm ${D}/boot/icon.xpm
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} += "/boot/*"
