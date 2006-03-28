DESCRIPTION = "Localized key mappings"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Matthias 'CoreDump' Hentges  <oe@hentges.net>"
LICENSE = "GPL"
RDEPENDS = "keymaps"

PR = "r6"

SRC_URI = "file://*.map"

# If any python guru wants to setup PACKAGES_$machine with some code instead,
# be my guest =)
PACKAGES_akita = "keymap-extension-de"
PACKAGES_spitz = "keymap-extension-de"
PACKAGES_borzoi = "keymap-extension-de"
PACKAGES_c7x0 = "keymap-extension-de"
PACKAGES_collie = "keymap-extension-de"

FILES_keymap-extension-de = "/etc/*-de.map"
FILES_keymap-extension-fr = "/etc/*-fr.map"

do_install() {
	install -d ${D}/${sysconfdir}
	
	install -m 0644 ${WORKDIR}/*.map ${D}/${sysconfdir}
}
