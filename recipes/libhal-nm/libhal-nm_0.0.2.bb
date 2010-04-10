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


SRC_URI[md5sum] = "2f0882a711759113b2388a790abe8fd8"
SRC_URI[sha256sum] = "68dd467cf8bd54283da874af54ac35de58b88444371ea48bb5cef289a0942981"
