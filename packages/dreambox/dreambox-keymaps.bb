DESCRIPTION = "Dreambox Keyboard Keymap files"
LICENSE = "GPL"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

SRC_URI = "file://dream-de.info file://dream-de.kmap file://eng.info file://eng.kmap"

PR = "r0"

FILES_${PN} = "/"

do_install() {
	install -d ${D}/usr/share/keymaps
	for x in /dream-de.info dream-de.kmap eng.info eng.kmap; do
		install -m 0644 ${WORKDIR}/$x ${D}/usr/share/keymaps/$x
	done
}
