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

