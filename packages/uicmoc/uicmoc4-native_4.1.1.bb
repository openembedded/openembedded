DESCRIPTION = "User-Interface-, Meta-Object-, and Resource Compiler for Qt/[X11|Mac|Embedded] version 4.x"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL QPL"
PR = "r0"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-x11-opensource-src-${PV}.tar.gz"

S = "${WORKDIR}/qt-x11-opensource-src-${PV}"

inherit native

EXTRA_OECONF = "-qt-libjpeg -qt-gif -system-zlib \
		-no-nis -no-cups -no-exceptions  \
		-no-accessibility -no-libjpeg    \
                -no-nas-sound -no-sm             \
                -no-xshape    -no-xinerama       \
                -no-xcursor   -no-xrandr         \
                -no-xrender   -no-fontconfig     \
                -no-tablet    -no-xkb            \
                -no-libpng                       \
                -verbose -release  -fast -static "
EXTRA_OEMAKE = " "

do_configure() {
	echo yes | ./configure ${EXTRA_OECONF} || die "Configuring qt failed. EXTRA_OECONF was ${EXTRA_OECONF}"
}

do_compile() {
	unset CC CXX CFLAGS LFLAGS CXXFLAGS CPPFLAGS
	cd ${S}/src/tools/moc && oe_runmake CC="${CC}" CXX="${CXX}"
	cd ${S}/src/corelib   && oe_runmake CC="${CC}" CXX="${CXX}"
	cd ${S}/src/xml       && oe_runmake CC="${CC}" CXX="${CXX}"
	cd ${S}/src/tools/uic && oe_runmake CC="${CC}" CXX="${CXX}"
	cd ${S}/src/tools/rcc && oe_runmake CC="${CC}" CXX="${CXX}"
}

do_stage() {
        install -m 0755 bin/moc ${STAGING_BINDIR}/moc4
        install -m 0755 bin/uic ${STAGING_BINDIR}/uic4
        install -m 0755 bin/rcc ${STAGING_BINDIR}/rcc4
}
