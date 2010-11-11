DESCRIPTION = "A desktop icon for system shutdown."
DEPENDS = "matchbox-desktop"

PR = "r0"
PACKAGE_ARCH = "all"

SRC_URI = "file://bug-shutdown.desktop"

S = "${WORKDIR}"

PACKAGE_ARCH = "all"
FILES_${PN} += "/usr/share/applications/bug-shutdown.desktop"

do_install() {
	install -m 0755 -d ${D}/usr/share/applications
	install -m 0644 ${S}/bug-shutdown.desktop ${D}/usr/share/applications/
}
