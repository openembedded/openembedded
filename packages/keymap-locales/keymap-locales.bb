DESCRIPTION = "Localized key mappings"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Matthias 'CoreDump' Hentges  <oe@hentges.net>"
LICENSE = "GPL"

PR = "r6"

SRC_URI = "file://*.map"

# If any python guru wants to setup PACKAGES_$machine with some code instead,
# be my guest =)
PACKAGES_akita = "keymap-extension-de keymap-extension-fi"
PACKAGES_spitz = "keymap-extension-de keymap-extension-fi"
PACKAGES_c7x0 = "keymap-extension-de keymap-extension-fi"
PACKAGES_collie = "keymap-extension-de keymap-extension-fi"

FILES_keymap-extension-de = "/etc/*-de.map"
FILES_keymap-extension-fr = "/etc/*-fr.map"
FILES_keymap-extension-fi = "/etc/*-fi.map"

do_install() {
	install -d ${D}/${sysconfdir}
	
	install -m 0644 ${WORKDIR}/*.map ${D}/${sysconfdir}
}
