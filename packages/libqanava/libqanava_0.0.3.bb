DESCRIPTION = "Qanava is a library built on top of the standard QT QCanvas \
to enable graphical display of graphs and other relational structures."
SECTION = "x11/libs"
HOMEPAGE = "http://www.libqanava.org/"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "qt3x11"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.libqanava.org/dl/qanava-${PV}.tar.gz"
S = "${WORKDIR}/qanava-${PV}"

inherit qmake qt3x11

PARALLEL_MAKE = ""

EXTRA_QMAKEVARS_POST = "CONFIG+=thread CONFIG-=staticlib"

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

