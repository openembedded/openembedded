DESCRIPTION = "Qt/X11 Version ${PV}"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL QPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "uicmoc4-native qmake-native-1.08a freetype x11 xft xext libxrender libxrandr libxcursor mysql"
PR = "r0"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-x11-opensource-${PV}.tar.gz"
S = "${WORKDIR}/qt-x11-opensource-${PV}"

# Not the prime time of Qt4 yet
# TODO: make it not look in /usr and /usr/include for its tests!
DEFAULT_PREFERENCE = "-1"
BROKEN             = "1"

PACKAGES += "qt-x11-plugins"
FILES_qt-x11-plugins = "${prefix}/plugins"

inherit qmake-base qt4x11

export QTDIR = "${S}"
STAGING_QT_DIR = "${STAGING_DIR}/${HOST_SYS}/qt4"
ARCH_i686 = "x86"
EXTRA_OEMAKE = "-e"

QT_CONFIG_FLAGS = "-release -shared -qt-zlib -no-nas-sound -no-sm -qt-libpng -no-gif -no-xinerama \
                   -no-tablet -no-xkb -no-nis -no-cups -plugin-sql-mysql -verbose -stl"

do_configure() {
	echo "DEFINES -= QT_NO_CAST_TO_ASCII" >>src/qbase.pri
	unset QMAKESPEC
	echo yes | ./configure -prefix ${prefix} ${QT_CONFIG_FLAGS} -fast \
		-L${STAGING_LIBDIR} -I${STAGING_INCDIR} -I${STAGING_INCDIR}/freetype2 -I${STAGING_INCDIR}/mysql
}

do_compile() {
        unset CC LD CCLD CXX RANLIB AR STRIP CFLAGS LDFLAGS CXXFLAGS CPPFLAGS LINK
	install -m 0755 ${STAGING_BINDIR}/rcc4 ${S}/bin/rcc
	install -m 0755 ${STAGING_BINDIR}/moc4 ${S}/bin/moc
	install -m 0755 ${STAGING_BINDIR}/uic4 ${S}/bin/uic

	oe_runmake
}

do_stage() {
	install -d ${STAGING_QT_DIR}/lib
	oe_soinstall lib/libqt-mt.so.${PV} ${STAGING_QT_DIR}/lib
	install -d ${STAGING_QT_DIR}/include/private
	for f in include/*.h
	do
		install -m 0644 $f ${STAGING_QT_DIR}/include/
	done
	for f in include/private/*.h
	do
	        install -m 0644 $f ${STAGING_QT_DIR}/include/private
	done
}

do_install() {
	install -d ${D}${libdir}/
	oe_soinstall lib/libqt-mt.so.${PV} ${D}${libdir}/
	oe_runmake -C plugins/src INSTALL_ROOT="${D}" \
		QMAKE="${STAGING_BINDIR}/qmake -after INCPATH+=${STAGING_INCDIR} \
		INCPATH+=${STAGING_INCDIR}/freetype2 LIBS+=-L${STAGING_LIBDIR} \
		QMAKE_LIBS_QT=-lqt QMAKE_LIBS_QT_THREAD=-lqt-mt" \
		QMAKESPEC="${QMAKESPEC}" LINK="${CXX} -Wl,-rpath-link,${STAGING_LIBDIR}" \
		MOC="${STAGING_BINDIR}/moc4" UIC="${STAGING_BINDIR}/uic4" MAKE="make -e" \
		install
}
