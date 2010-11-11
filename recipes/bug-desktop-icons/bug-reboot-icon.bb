DESCRIPTION = "A desktop icon for system reboot."
DEPENDS = "matchbox-desktop"

PR = "r0"
PACKAGE_ARCH = "all"

SRC_URI = "file://bug-reboot.desktop"

S = "${WORKDIR}"

PACKAGE_ARCH = "all"
FILES_${PN} += "/usr/share/applications/bug-reboot.desktop"

do_install() {
	install -m 0755 -d ${D}/usr/share/applications
	install -m 0644 ${S}/bug-reboot.desktop ${D}/usr/share/applications/
}
