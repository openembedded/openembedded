SECTION = "console/utils"
DEPENDS = "ncurses"
LICENSE = "GPL"
DESCRIPTION = "Dialog lets you to present a variety of questions \
or display messages using dialog boxes from a shell \
script (or any scripting language)."

INC_PR = "r1"

SRC_URI = "ftp://invisible-island.net/dialog/dialog-${PV}.tgz"

inherit autotools

do_configure() {
	sed -i "s:-L/lib::" "${S}/configure"
	oe_runconf
}
