DESCRIPTION = "Qt/Embedded version ${PV}"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL QPL"
DEPENDS = "zlib libpng jpeg tslib uicmoc4-native"
PROVIDES = "virtual/qte4 virtual/libqte4"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
PR = "ml4"

SRC_URI = "ftp://ftp.trolltech.com/pub/qt/source/qt-embedded-opensource-${PV}.tar.bz2 \
           file://gcc34.patch;patch=1 \
           file://add-qatomic.patch;patch=1 \
           file://fix-mkspecs.patch;patch=1 \
           file://fix-qwidget.patch;patch=1 \
           file://fix-qwsmanager.patch;patch=1 \
           file://fix-vncdriver.patch;patch=1 \
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

EXTRA_OECONF = "-embedded ${QTE_ARCH} \
		-system-libjpeg -system-libpng -system-zlib \
		-no-qvfb -no-nis -no-cups -no-stl -no-pch   \
		-no-accessibility -no-compat                \
		-qconfig large -depths 8,16,24,32 -fast     \
                -qt-gfx-transformed			    \
		-qt-gfx-vnc             		    \
                -plugin-kbd-sl5000                          \
		-plugin-kbd-tty                             \
		-plugin-kbd-usb                             \
		-plugin-kbd-yopy			    \
		-plugin-mouse-pc                            \
		-plugin-mouse-bus			    \
		-plugin-mouse-linuxtp			    \
		-plugin-mouse-yopy			    \
		"

EXTRA_OEMAKE = "-e"

export EXTRA_CFLAGS = "-I${STAGING_INCDIR}"
export EXTRA_CXXFLAGS = "-I${STAGING_INCDIR}"
export EXTRA_LFLAGS = "-L${STAGING_LIBDIR} -Wl,-rpath-link,${STAGING_LIBDIR}"

do_configure() {
	unset QMAKESPEC
	echo yes | ./configure ${EXTRA_OECONF} || die "Configuring qt failed. EXTRA_OECONF was ${EXTRA_OECONF}"
}

do_compile() {
        unset CC LD CCLD CXX RANLIB AR STRIP CFLAGS LDFLAGS CXXFLAGS CPPFLAGS LINK
	install -m 0755 ${STAGING_BINDIR}/rcc4 ${S}/bin/rcc
	install -m 0755 ${STAGING_BINDIR}/moc4 ${S}/bin/moc
	install -m 0755 ${STAGING_BINDIR}/uic4 ${S}/bin/uic

	cp -fa	${WORKDIR}/mousedrivers/	${S}/src/gui/embedded/

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
                cp -a lib/libQt${lib}* ${STAGING_DIR}/${HOST_SYS}/qt4/lib/
        done

	install -d ${STAGING_DIR}/${HOST_SYS}/qt4/include/
	cp -a include/* ${STAGING_DIR}/${HOST_SYS}/qt4/include
}

do_install() {
	install -d ${D}/${palmtopdir}/bin
	install -d ${D}/${sbindir}/
	install -m 0755 ${WORKDIR}/update-qtfontdir ${D}/${sbindir}/
	install -d ${D}${palmtopdir}/lib/fonts/
	cp -a lib/fonts/* ${D}${palmtopdir}/lib/fonts/

	for lib in Core Gui Network Sql Xml
	do
		oe_soinstall lib/libQt${lib}.so.4.0.0 ${D}/${palmtopdir}/lib
	done

	for i in `find . -perm 0755 -type f`
	do
		install -m 0755 $i ${D}/${palmtopdir}/bin/`basename $i`
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
FILES_libqte4-core	= "${palmtopdir}/lib/libQtCore.* /usr/sbin/update-qtfontdir"
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
