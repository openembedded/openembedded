DESCRIPTION = "User-Interface-, Meta-Object-, and Resource Compiler for Qt/[X11|Mac|Embedded] version 4.x"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL QPL"
PR = "r1"

SRC_URI = "ftp://ftp.trolltech.com/pub/qt/source/qt-embedded-opensource-${PV}.tar.bz2 \
           file://gcc34.patch;patch=1 \
           file://fix-qwsmanager.patch;patch=1 \
           file://fix-qwidget.patch;patch=1 "
S = "${WORKDIR}/qt-embedded-opensource-${PV}"

inherit native

EXTRA_OECONF = "-qt-libjpeg -qt-libpng -qt-gif -system-zlib \
		-no-qvfb -no-nis -no-cups -no-pch \
		-no-accessibility -verbose -no-compat -fast"
EXTRA_OEMAKE = " "

do_configure() {
	echo yes | ./configure ${EXTRA_OECONF} || die "Configuring qt failed. EXTRA_OECONF was ${EXTRA_OECONF}"
}

do_compile() {
	unset CC CXX CFLAGS LFLAGS CXXFLAGS CPPFLAGS
	cd ${S}/src/moc && oe_runmake CC="${CC}" CXX="${CXX}"
	cd ${S}/src/core && oe_runmake CC="${CC}" CXX="${CXX}"
	cd ${S}/src/xml && oe_runmake CC="${CC}" CXX="${CXX}"
	cd ${S}/src/tools/uic && oe_runmake CC="${CC}" CXX="${CXX}"
	cd ${S}/src/tools/rcc && oe_runmake CC="${CC}" CXX="${CXX}"
}

do_stage() {
        install -m 0755 bin/moc ${STAGING_BINDIR}/moc4
        install -m 0755 bin/uic ${STAGING_BINDIR}/uic4
        install -m 0755 bin/rcc ${STAGING_BINDIR}/rcc4
        install -m 0655 lib/libQtXml.so.4 ${STAGING_LIBDIR}
	install -m 0655 lib/libQtCore.so.4 ${STAGING_LIBDIR}
}
