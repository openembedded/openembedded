DESCRIPTION = "User Interface Generator and Meta Object Compiler (moc) for Qt(E) 3.x"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "GPL/QPL"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-embedded-free-3.3.2.tar.bz2 \
	   file://no-examples.patch;patch=1"

S = "${WORKDIR}/qt-embedded-free-3.3.2"

inherit native qmake-base

export QTDIR = "${S}"
export OE_QMAKE_LINK="${CXX}"
CXXFLAGS += " -DQWS"

QT_CONFIG_FLAGS = "-release -static -depths 8,16 -qt-zlib -no-nas-sound \
                   -no-sm -qt-libpng -no-gif -no-xshape -no-xinerama \
                   -no-xcursor -no-xrandr -no-xrender -no-xft -no-tablet \
                   -no-xkb -no-dlopen-opengl -no-freetype -no-thread \
                   -no-nis -no-cups -prefix ${prefix} \
                   -xplatform ${OE_QMAKE_PLATFORM} \
                   -platform ${OE_QMAKE_PLATFORM}"

do_configure() {
    oe_qmake_mkspecs
    echo "yes" | ./configure ${QT_CONFIG_FLAGS}
}

do_stage() {
	install -m 0755 bin/moc ${STAGING_BINDIR}/moc3
	install -m 0755 bin/uic ${STAGING_BINDIR}/uic3
	install -m 0655 lib/*.a ${STAGING_LIBDIR}/
	for f in include/*.h
	do
		install -m 0644 $f ${STAGING_INCDIR}/
	done
}
