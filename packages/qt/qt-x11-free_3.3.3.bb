DESCRIPTION = "Qt/X11 Version ${PV}"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL QPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "uicmoc3-native freetype x11 xft xext libxrender libxrandr libxcursor mysql"
PR = "r5"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-x11-free-${PV}.tar.bz2 \
	   file://configure.patch;patch=1 \
	   file://no-examples.patch;patch=1"
S = "${WORKDIR}/qt-x11-free-${PV}"

PACKAGES += "qt-x11-plugins"
FILES_qt-x11-plugins = "${prefix}/plugins"

inherit qmake-base qt3x11

export QTDIR = "${S}"
STAGING_QT_DIR = "${STAGING_DIR}/${HOST_SYS}/qt3"
ARCH_i686 = "x86"
EXTRA_OEMAKE = "-e"

QT_CONFIG_FLAGS = "-release -shared -qt-zlib -no-nas-sound -no-sm -qt-libpng -no-gif -no-xinerama \
                   -no-tablet -no-xkb -no-dlopen-opengl -no-nis -no-cups -thread -plugin-sql-mysql -verbose"

do_configure() {
	echo "yes" | ./configure -prefix ${prefix} ${QT_CONFIG_FLAGS} -fast \
		-L${STAGING_LIBDIR} -I${STAGING_INCDIR} -I${STAGING_INCDIR}/freetype2 -I${STAGING_INCDIR}/mysql
	# force regenerate
	rm -f src/qtmain.pro
	cat Makefile >makefile
	find . -name "Makefile"|xargs rm -f
	(cd src && qmake -spec ${QMAKESPEC} )
	(cd plugins/src && qmake -spec ${QMAKESPEC} )
}

do_compile() {
	unset CFLAGS
	unset CXXFLAGS
#	cd src && oe_runmake QMAKESPEC="${QMAKESPEC}" QMAKE="${STAGING_BINDIR}/qmake" MOC="moc3" UIC="uic3" MAKE="make -e"
	oe_runmake -C src \
		QMAKE="${STAGING_BINDIR}/qmake -after INCPATH+=${STAGING_INCDIR} \
		INCPATH+=${STAGING_INCDIR}/freetype2 LIBS+=-L${STAGING_LIBDIR}" \
		QMAKESPEC="${QMAKESPEC}" LINK="${CXX} -Wl,-rpath-link,${STAGING_LIBDIR}" \
		MOC="${STAGING_BINDIR}/moc3" UIC="${STAGING_BINDIR}/uic3" MAKE="make -e"
	oe_runmake -C plugins/src \
		QMAKE="${STAGING_BINDIR}/qmake -after INCPATH+=${STAGING_INCDIR} \
		INCPATH+=${STAGING_INCDIR}/freetype2 LIBS+=-L${STAGING_LIBDIR} \
		QMAKE_LIBS_QT=-lqt QMAKE_LIBS_QT_THREAD=-lqt-mt" \
		QMAKESPEC="${QMAKESPEC}" LINK="${CXX} -Wl,-rpath-link,${STAGING_LIBDIR}" \
		MOC="${STAGING_BINDIR}/moc3" UIC="${STAGING_BINDIR}/uic3" MAKE="make -e"
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
		MOC="${STAGING_BINDIR}/moc3" UIC="${STAGING_BINDIR}/uic3" MAKE="make -e" \
		install
}
