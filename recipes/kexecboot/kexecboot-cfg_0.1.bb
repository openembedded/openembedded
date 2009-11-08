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

        echo "# Show this label in kexecboot menu." >> ${S}/boot.cfg
        echo "LABEL=${DISTRO}" >> ${S}/boot.cfg
        echo "#" >> ${S}/boot.cfg

        echo "# Specify full path to the kernel." >> ${S}/boot.cfg
        echo "KERNEL=/boot/${KERNEL_IMAGETYPE}" >> ${S}/boot.cfg
        echo "#" >> ${S}/boot.cfg

        echo "# Append this tags to the kernel cmdline." >> ${S}/boot.cfg
        echo "APPEND=${CMDLINE}" >> ${S}/boot.cfg
        echo "#" >> ${S}/boot.cfg

        echo "# Specify full path for a custom distro-icon for the menu-item." >> ${S}/boot.cfg
        echo "# If not set, use device-icons as default (NAND, SD, CF, ...)." >> ${S}/boot.cfg
        echo "#ICON=/boot/icon.xpm" >> ${S}/boot.cfg
        echo "#" >> ${S}/boot.cfg

        echo "# Priority of item in kexecboot menu." >> ${S}/boot.cfg
        echo "# Items with highest priority will be shown at top of menu." >> ${S}/boot.cfg
        echo "# Default: 0 (lowest, ordered by device ordering)" >> ${S}/boot.cfg
        echo "#PRIORITY=10" >> ${S}/boot.cfg
        echo "#" >> ${S}/boot.cfg
}

do_install () {
        install -d ${D}/boot
        install -m 0644 boot.cfg ${D}/boot/boot.cfg
        install -m 0644 icon.xpm ${D}/boot/icon.xpm
}
