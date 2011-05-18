DESCRIPTION = "SDR-Shell is Qt GUI for the sdr-core (DttSP) Software Defined Radio"
LICENSE = "GPLv2"

DEPENDS = "hamlib dttsp libusb1 ncurses"

inherit qt4x11

SRCREV = "154"
PV = "${SRCREV}"

SRC_URI = "svn://sdr-shell.googlecode.com/svn/branches;module=sdr-shell-v4;proto=http \
"
S = "${WORKDIR}/sdr-shell-v4"

PARALLEL_MAKE = ""

do_configure_prepend() {
	rm -f ${S}/sdr-shell
}

do_compile_prepend() {
	sed -i -e s:OE_QMAKE_LINK:CXX:g ${S}/Makefile
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/sdr-shell ${D}${bindir}
}

