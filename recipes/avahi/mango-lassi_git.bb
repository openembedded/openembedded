DESCRIPTION = "Input sharing, the avahi way"
DEPENDS = "libxtst avahi-ui libnotify gnome-doc-utils-native scrollkeeper-native"
LICENSE = "GPLv2+"

SRCREV = "d50141ce4eb96e7326ba"
PV = "001+${PR}+gitr${SRCREV}"
PR = "r0"

SRC_URI = "git://github.com/herzi/mango-lassi.git;protocol=git"

S = "${WORKDIR}/git"

inherit autotools

do_configure_prepend() {
	touch config.rpath
	gnome-doc-prepare --automake
}

FILES_${PN} += "${datadir}/icons"
