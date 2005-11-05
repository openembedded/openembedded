DESCRIPTION = "Qt/Embedded version ${PV}"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL QPL"
DEPENDS = "zlib libpng jpeg tslib qmake-native-1.08a uicmoc4-native"
PROVIDES = "virtual/qte4 virtual/libqte4"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
PR = "ml1"

BROKEN = "1"

PV = "4.0.0-b2-snapshot-20050128"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/qte-4.0.0-snapshot"

SRC_URI = "ftp://ftp.trolltech.com/pub/qt/snapshots/qt-embedded-opensource-${PV}.tar.bz2 \
           file://gcc34.patch;patch=1 \
           file://add-qatomic.patch;patch=1 \
           file://fix-mkspecs.patch;patch=1 \
           file://fix-qwsmanager.patch;patch=1 \
           file://fix-sl5000driver.patch;patch=1 \
           file://no-moc-no-uic-no-rcc.patch;patch=1 \
           file://sharp_char.h \
           file://switches.h \
           file://update-qtfontdir"
S = "${WORKDIR}/qt-embedded-opensource-${PV}"

DEFAULT_PREFERENCE = "-1"

export QTDIR = "${S}"

def qte_arch(d):
	import bb, re
	arch = bb.data.getVar('TARGET_ARCH', d, 1)
	if re.match("^i.86$", arch):
		arch = "x86"
	elif arch == "x86_64":
		arch = "x86"
	elif arch == "mipsel":
		arch = "mips"
	return arch

QTE_ARCH := "${@qte_arch(d)}"

#
# How to build the embedded drivers. Use plugin-<type> or qt-<type>. As for Beta1, that doesn't work :D
#
GFX = "qt-gfx"
KBD = "qt-kbd"
MSE = "qt-mouse"

#
# Which configuration to build. As for Beta1, this doesn't work :)
#
QCONFIG = ""
# QCONFIG = "-qconfig full"
QDEPTHS = "-depths 8,16,24,32"

#
# Borken: yopy, busmouse, linuxtp
#

EXTRA_OECONF = "-embedded ${QTE_ARCH} \
		-system-libjpeg -system-libpng -system-zlib \
		-no-qvfb -no-nis -no-cups -no-stl -no-pch   \
		-no-accessibility -no-compat -fast          \
		${QCONFIG} ${QDEPTHS}                       \
                -qt-gfx-transformed			    \
		-qt-gfx-vnc             		    \
                -${KBD}-sl5000                          \
		-${KBD}-tty                             \
		-${KBD}-usb                             \
		-${MSE}-pc                            \
		"

EXTRA_OEMAKE = "-e"
PARALLEL_MAKE = ""

export EXTRA_CFLAGS = "-I${STAGING_INCDIR}"
export EXTRA_CXXFLAGS = "-I${STAGING_INCDIR}"
export EXTRA_LFLAGS = "-L${STAGING_LIBDIR} -Wl,-rpath-link,${STAGING_LIBDIR}"

do_configure() {
	echo "DEFINES -= QT_NO_CAST_TO_ASCII" >>src/qbase.pri
	unset QMAKESPEC
	echo yes | ./configure ${EXTRA_OECONF} || die "Configuring qt failed. EXTRA_OECONF was ${EXTRA_OECONF}"
}

do_compile() {
        unset CC LD CCLD CXX RANLIB AR STRIP CFLAGS LDFLAGS CXXFLAGS CPPFLAGS LINK
	install -m 0755 ${STAGING_BINDIR}/rcc4 ${S}/bin/rcc
	install -m 0755 ${STAGING_BINDIR}/moc4 ${S}/bin/moc
	install -m 0755 ${STAGING_BINDIR}/uic4 ${S}/bin/uic

	install -d include/asm/	
	install -m 0644 ${WORKDIR}/sharp_char.h include/asm/
	install -d include/linux/
	install -m 0644 ${WORKDIR}/switches.h   include/linux/

	oe_runmake
}

do_stage() {
	install -d ${STAGING_DIR}/${HOST_SYS}/qt4/lib

        for lib in Core Gui Network Sql Xml
        do
                cp -pPR lib/libQt${lib}* ${STAGING_DIR}/${HOST_SYS}/qt4/lib/
        done

	install -d ${STAGING_DIR}/${HOST_SYS}/qt4/include/
	cp -pPR include/* ${STAGING_DIR}/${HOST_SYS}/qt4/include
}

do_install() {
	install -d ${D}${palmtopdir}/bin
	install -d ${D}${sbindir}/
	install -m 0755 ${WORKDIR}/update-qtfontdir ${D}${sbindir}/
	install -d ${D}${palmtopdir}/lib/fonts/
	cp -pPR lib/fonts/* ${D}${palmtopdir}/lib/fonts/

	for lib in Core Gui Network Sql Xml
	do
		oe_soinstall lib/libQt${lib}.so.4.0.0 ${D}${palmtopdir}/lib
	done

	for i in `find . -perm 0755 -type f`
	do
		install -m 0755 $i ${D}${palmtopdir}/bin/`basename $i`
	done
}

pkg_postinst() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir
}

pkg_postinst_qte-font-unicode() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir
}

pkg_postinst_qte-font-lcd () {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir
}

pkg_postinst_qte-font-japanese() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir
}

pkg_postinst_qte-font-micro() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir
}

pkg_postinst_qte-font-courier() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir
}

LIB_PACKAGES = "\
		libqte4-debug			\
		libqte4-core			\
		libqte4-gui			\
		libqte4-network			\
		libqte4-sql			\
		libqte4-xml			\
		"
		

FONT_PACKAGES = "\
		qte-font-fixed			\
		qte-font-helvetica-small	\
		qte-font-helvetica-large 	\
		qte-font-smoothtimes 		\
		qte-font-smallsmooth		\
		qte-font-unicode		\
		qte-font-lcd 			\
		qte-font-japanese 		\
		qte-font-micro 			\
		qte-font-courier		\
		"

PACKAGES = "${LIB_PACKAGES} ${FONT_PACKAGES} examples"

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} = ""
FILES_libqte4-debug	= "${palmtopdir}/lib/libQt*_debug.*"
FILES_libqte4-core	= "${palmtopdir}/lib/libQtCore.* ${sbindir}/update-qtfontdir"
FILES_libqte4-gui	= "${palmtopdir}/lib/libQtGui.*"
FILES_libqte4-network	= "${palmtopdir}/lib/libQtNetwork.*"
FILES_libqte4-sql	= "${palmtopdir}/lib/libQtSql.*"
FILES_libqte4-xml	= "${palmtopdir}/lib/libQtXml.*"
FILES_examples		= "${palmtopdir}/bin"

FILES_qte-font-fixed = "${palmtopdir}/lib/fonts/fixed*"
PACKAGE_ARCH_qte-font-fixed = "all"

FILES_qte-font-helvetica-small = "${palmtopdir}/lib/fonts/helvetica_80*.qpf \
	${palmtopdir}/lib/fonts/helvetica_100*.qpf ${palmtopdir}/lib/fonts/helvetica_120*.qpf"
PACKAGE_ARCH_qte-font-helvetica-small = "all"

FILES_qte-font-helvetica-large = "${palmtopdir}/lib/fonts/helvetica_140*.qpf \
	${palmtopdir}/lib/fonts/helvetica_180*.qpf ${palmtopdir}/lib/fonts/helvetica_240*.qpf"
PACKAGE_ARCH_qte-font-helvetica-large = "all"

FILES_qte-font-smoothtimes = "${palmtopdir}/lib/fonts/smoothtimes*"
PACKAGE_ARCH_qte-font-smoothtimes = "all"

FILES_qte-font-smallsmooth = "${palmtopdir}/lib/fonts/smallsmooth*"
PACKAGE_ARCH_qte-font-smallsmooth = "all"

FILES_qte-font-unicode = "${palmtopdir}/lib/fonts/unifont*.qpf"
PACKAGE_ARCH_qte-font-unicode = "all"

FILES_qte-font-lcd = "${palmtopdir}/lib/fonts/lcd*"
PACKAGE_ARCH_qte-font-lcd = "all"

FILES_qte-font-japanese = "${palmtopdir}/lib/fonts/japanese*"
PACKAGE_ARCH_qte-font-japanese = "all"

FILES_qte-font-micro = "${palmtopdir}/lib/fonts/micro*.qpf"
PACKAGE_ARCH_qte-font-micro = "all"

FILES_qte-font-courier = "${palmtopdir}/lib/fonts/cour*"
PACKAGE_ARCH_qte-font-courier = "all"
