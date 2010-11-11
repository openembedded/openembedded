DESCRIPTION = "A desktop icon for xeyes."
DEPENDS = "xeyes matchbox-desktop"

PR = "r0"
PACKAGE_ARCH = "all"

SRC_URI = "file://xeyes.desktop"

S = "${WORKDIR}"

PACKAGE_ARCH = "all"
FILES_${PN} += "/usr/share/applications/xeyes.desktop"

do_install() {
	install -m 0755 -d ${D}/usr/share/applications
	install -m 0644 ${S}/xeyes.desktop ${D}/usr/share/applications/
}
