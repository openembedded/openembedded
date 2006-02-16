DESCRIPTION = "Qt/X11 Version ${PV}"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL QPL"
DEPENDS = "qmake-native x11-native"
HOMEPAGE = "http://www.trolltech.com"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/qt-x11-free"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-x11-free-${PV}.tar.bz2 \
	   file://no-examples.patch;patch=1"
S = "${WORKDIR}/qt-x11-free-${PV}"

#
# FIXME - This should be updated to use OE's qmake-base.oeclass
#         or the full qmake.oeclass.
#

export QTDIR = "${S}"
export SYSCONF_CXX = "${CCACHE} g++"
export SYSCONF_CC  = "${CCACHE} gcc"
export SYSCONF_LINK  = "${CCACHE} g++"
THIS_QMAKESPEC = "${STAGING_DATADIR}/qmake/${TARGET_OS}-oe-g++"
export QMAKESPEC = ""
ARCH_i686 = "x86"

QT_CONFIG_FLAGS = "-release -shared -qt-zlib -no-nas-sound -no-sm -qt-libpng -qt-gif -no-xshape -no-xinerama -no-xcursor -no-xrandr \
                   -no-xrender -no-xft -no-tablet -no-xkb -no-dlopen-opengl -no-freetype -no-nis -no-cups -stl -thread -no-exceptions"


inherit native

do_configure() {
	echo "yes" | ./configure -prefix ${prefix} ${QT_CONFIG_FLAGS} -fast
}

do_compile() {
	LD_LIBRARY_PATH=${S}/lib oe_runmake \
		QMAKE="${STAGING_BINDIR}/qmake -after INCLUDEPATH+=${STAGING_INCDIR} LIBS+=-I${STAGING_LIBDIR}" \
		QMAKESPEC="${THIS_QMAKESPEC}"
}

do_stage() {
	install -d ${STAGING_DIR}/${HOST_SYS}/qt3/lib
	oe_soinstall lib/libqt-mt.so.${PV} ${STAGING_DIR}/${HOST_SYS}/qt3/lib
	install -d ${STAGING_DIR}/${HOST_SYS}/qt3/include/private
	for f in include/*.h
	do
		install -m 0644 $f ${STAGING_DIR}/${HOST_SYS}/qt3/include/
	done
	for f in include/private/*.h
	do
	        install -m 0644 $f ${STAGING_DIR}/${HOST_SYS}/qt3/include/private
	done
}

do_install() {
	install -d ${D}${libdir}/
	oe_soinstall lib/libqt-mt.so.${PV} ${D}${libdir}/
}

