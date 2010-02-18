LICENSE = "GPL"
SECTION = "base"
DESCRIPTION = "Configuration file for kexecboot"

PR = "r7"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://icon.xpm"

CMDLINE_CON = "console=ttyS0,115200n8 console=tty1 noinitrd"
CMDLINE_CON_collie = "console=ttySA0,115200n8 console=tty1 noinitrd rw"
CMDLINE_CON_qemuarm = "console=ttyAMA0,115200n8 console=tty1 noinitrd"

CMDLINE_MEM_collie = "mem=64M"

CMDLINE_ROTATE_spitz = "fbcon=rotate:1"
CMDLINE_ROTATE_akita = "fbcon=rotate:1"
CMDLINE_ROTATE_collie = "fbcon=rotate:1"
CMDLINE_ROTATE_poodle = "fbcon=rotate:1"

#CMDLINE_OTHER = "dyntick=enable"
CMDLINE_OTHER = ""

CMDLINE_DEBUG = '${@base_conditional("DISTRO_TYPE", "release", "quiet", "debug",d)}'

CMDLINE = ${CMDLINE_CON}
CMDLINE += ${CMDLINE_MEM}
CMDLINE += ${CMDLINE_ROTATE}
CMDLINE += ${CMDLINE_OTHER}
CMDLINE += ${CMDLINE_DEBUG}

FILES_${PN} += "/boot/*"

do_configure_prepend () {
    install -m 0644 ${WORKDIR}/icon.xpm ${S}
}

do_install_prepend () {

echo '# Show this label in kexecboot menu.
LABEL=${DISTRO}
#
# Specify full kernel path on target.
KERNEL=/boot/${KERNEL_IMAGETYPE}
#
# Append this tags to the kernel cmdline.
APPEND=${CMDLINE}
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
