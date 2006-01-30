DESCRIPTION = "Localized key mappings"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Matthias 'CoreDump' Hentges  <oe@hentges.net>"
LICENSE = "GPL"

PR = "r3"

SRC_URI = "file://*.map"

# If any python guru wants to setup PACKAGES_$machine with some code instead,
# be my guet =)
PACKAGES_akita = "keymap-extension-de"

FILES_keymap-extension-de = "/etc/*-de.map"
FILES_keymap-extension-fr = "/etc/*-fr.map"

do_install() {
	install -d ${D}/${sysconfdir}
	
	install -m 0644 ${WORKDIR}/*.map ${D}/${sysconfdir}
}
