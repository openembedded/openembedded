DESCRIPTION = "xdotool - command-line X11 automation tool - utilising X11 XTEST interface"
HOMEPAGE = "http://www.semicomplete.com/projects/xdotool"
LICENSE = "GPL"
SECTION = "x11"
PRIORITY = "optional"
DEPENDS = "virtual/libx11 libxtst"

SRC_URI = "http://semicomplete.googlecode.com/files/xdotool-${PV}.tar.gz"

EXTRA_OEMAKE = "PREFIX=${prefix}"

do_install() {
	oe_runmake -e install DESTDIR=${D} PREFIX=${prefix}
}

SRC_URI[md5sum] = "1d5be641e512c343abfe5f78b39e6f19"
SRC_URI[sha256sum] = "42d7271fbc796e53db71bb221f311b9ff3c51d90a71c9487a9bd3101ca39894f"

