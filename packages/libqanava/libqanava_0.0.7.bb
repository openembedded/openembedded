DESCRIPTION = "Qanava is a gtaph library based on the Qt4 Arthur framework."
SECTION = "x11/libs"
HOMEPAGE = "http://www.libqanava.org/"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
# LGPL after 0.0.7
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.libqanava.org/dl/qanava-${PV}.tar.gz"
S = "${WORKDIR}/qanava-${PV}"

inherit qmake qt4x11

PARALLEL_MAKE = ""

EXTRA_QMAKEVARS_POST = "CONFIG+=thread CONFIG-=staticlib CONFIG-=debug"

do_configure_prepend() {
	find . -name "Makefile"|xargs rm -f
}

LIBS = "can la utl"
BINS = "basic layout logo timetree"

do_stage() {
	for lib in ${LIBS}
	do
		oe_libinstall -so -C build libqanava_$lib ${D}${libdir}
	done
}

do_install() {
	for lib in ${LIBS}
	do
		oe_libinstall -so -C build libqanava_$lib ${D}${libdir}
	done

	install -d ${D}${bindir}
	for bin in ${BINS}
	do
		install -m 0755 tests/$bin/test_$bin ${D}${bindir}
	done
}

PACKAGES = "libqanava-can libqanava-la libqanava-utl qanava-examples"
FILES_libqanava-can = "${libdir}/libqanava_can*.so*"
FILES_libqanava-la = "${libdir}/libqanava_la*.so*"
FILES_libqanava-utl = "${libdir}/libqanava_utl*.so*"
FILES_qanava-examples = "${bindir}"

