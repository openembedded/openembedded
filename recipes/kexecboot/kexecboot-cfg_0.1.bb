LICENSE = "GPL"
SECTION = "base"
DESCRIPTION = "Configuration file for kexecboot"

PR = "r3"
PACKAGE_ARCH = "${MACHINE_ARCH}"

CMDLINE_CON = "console=ttyS0,115200n8 console=tty1 noinitrd"
CMDLINE_CON_collie = "console=ttySA0,115200n8 console=tty1 noinitrd"
CMDLINE_CON_qemuarm = "console=ttyAMA0,115200n8 console=tty1 noinitrd"

CMDLINE_DEBUG = '${@base_conditional("DISTRO_TYPE", "release", "quiet", "debug",d)}'

CMDLINE_MEM_collie = "mem=64M"

CMDLINE_ROTATE_spitz = "fbcon=rotate:1"
CMDLINE_ROTATE_akita = "fbcon=rotate:1"
CMDLINE_ROTATE_collie = "fbcon=rotate:1"
CMDLINE_ROTATE_poodle = "fbcon=rotate:1"
FILES_${PN} += "/boot/*"


do_install_prepend () {
        echo "DEFAULT=${DISTRO}" > ${S}/boot.cfg
        echo "LABEL=${DISTRO}" >> ${S}/boot.cfg
        echo "KERNEL=/boot/${KERNEL_IMAGETYPE}" >> ${S}/boot.cfg
        echo "APPEND=${CMDLINE_CON} ${CMDLINE_MEM} ${CMDLINE_ROTATE} ${CMDLINE_OTHER} ${CMDLINE_DEBUG}" >> ${S}/boot.cfg
}

do_install () {
	install -d ${D}/boot
	install -m 0644 boot.cfg ${D}/boot/boot.cfg

	# old kexecboot versions < 0.6 need '/boot/kernel-cmdline'
	echo "${CMDLINE_CON} ${CMDLINE_MEM} ${CMDLINE_ROTATE} ${CMDLINE_OTHER} ${CMDLINE_DEBUG}"> ${D}/boot/kernel-cmdline
}
