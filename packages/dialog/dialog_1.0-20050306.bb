SECTION = "console/utils"
DEPENDS = "ncurses"
LICENSE = "GPL"
DESCRIPTION = "Dialog lets you to present a variety of questions \
or display messages using dialog boxes from a shell \
script (or any scripting language)."

SRC_URI = "ftp://ftp.us.debian.org/debian/pool/main/d/dialog/dialog_${PV}.orig.tar.gz \
	   file://configure.patch;patch=1 \
	   file://m4.patch;patch=1"

inherit autotools
