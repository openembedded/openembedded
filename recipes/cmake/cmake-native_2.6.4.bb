inherit native
require cmake.inc

do_install() {
	oe_runmake install
}

SRC_URI[md5sum] = "50f387d0436696c4a68b5512a72c9cde"
SRC_URI[sha256sum] = "9cdd2152e37b05d0d40d334a1bb2dfc0250021797360f971c6ea3d457ac9fdf2"
