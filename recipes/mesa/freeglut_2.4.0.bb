DESCRIPTION = "freeglut is a completely OpenSourced alternative to the OpenGL Utility Toolkit (GLUT) library. "
LICENSE = "MIT/X11"

DEPENDS = "virtual/libgl"

SRC_URI = "http://dfn.dl.sourceforge.net/sourceforge/freeglut/freeglut-${PV}.tar.gz"

inherit autotools lib_package

export CCLD="${CXX}"

do_configure_prepend() {
	sed -i -e s:-Werror::g -e s:AC_PROG_CC:AC_PROG_CXX:g configure.ac
}

do_configure_append() {
	for i in $(find . -name "Makefile") ; do
		sed -i -e /^CCLD/d $i
	done
}


do_stage() {
	autotools_stage_all
}


SRC_URI[md5sum] = "6d16873bd876fbf4980a927cfbc496a1"
SRC_URI[sha256sum] = "269f2d50ba30b381622eb36f20b552ad43a1b43d544b9075e484e7146e81b052"
