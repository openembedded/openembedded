DESCRIPTION = "A library emulating libhal on systems where HAL cannot run"
SECTION = "libs"
LICENSE = "LGPL"
HOMEPAGE = "http://www.handhelds.org/~mmp"
PRIORITY = "optional"
DEPENDS = "glib-2.0"
SRC_URI = "http://www.handhelds.org/~mmp/files/libhal-nm-${PV}.tar.gz"

PR = "r1"

inherit autotools

do_stage () {
	autotools_stage_all
}

do_install () {
	oe_runmake DESTDIR=${D} install
}

