DESCRIPTION = "The PhoneUI app starters"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS += "dbus-glib"
PV = "0.0.0+gitr${SRCREV}"
PR = "r1"

inherit pkgconfig autotools

SRC_URI = "git://git.shr-project.org/repo/phoneui-apps.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

PACKAGES = "${PN}-dialer ${PN}-messages ${PN}-contacts ${PN}-quick-settings"

FILES_${PN}-dialer = "\
	/usr/bin/phoneui-dialer \
	/usr/share/applications/phoneui-dialer.desktop \
"
FILES_${PN}-messages = "\
	/usr/bin/phoneui-messages \
	/usr/share/applications/phoneui-messages.desktop \
"
FILES_${PN}-contacts = "\
	/usr/bin/phoneui-contacts \
	/usr/share/applications/phoneui-contacts.desktop \
"

FILES_${PN}-quick-settings = "\
	/usr/bin/phoneui-quick-settings \
"

