DESCRIPTION = "Lightweight backlight saver daemon"
SECTION = "base"
LICENSE="GPL"

PR = "r0"

SRC_URI = "file://Makefile \
    file://backsaver.c"

S = ${WORKDIR}

do_install () {
	oe_runmake 'prefix=${D}' install
}
