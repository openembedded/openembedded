DESCRIPTION = "Mickey's DBus introspection and calling Program"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
LICENSE = "GPLv2"
PV = "0.9.0+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/python-helpers.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 mickeydbus/mdbus ${D}${bindir}
}

RDEPENDS_${PN} = "\
  python-dbus \
"
