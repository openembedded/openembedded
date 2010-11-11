DESCRIPTION = "A desktop icon for system suspend."
DEPENDS = "matchbox-desktop"

PR = "r0"
PACKAGE_ARCH = "all"

SRC_URI = "file://bug-suspend.desktop"

S = "${WORKDIR}"

PACKAGE_ARCH = "all"
FILES_${PN} += "/usr/share/applications/bug-suspend.desktop"

do_install() {
	install -m 0755 -d ${D}/usr/share/applications
	install -m 0644 ${S}/bug-suspend.desktop ${D}/usr/share/applications/
}
