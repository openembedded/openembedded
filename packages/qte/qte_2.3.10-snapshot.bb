DESCRIPTION = "Qt/Embedded Version ${PV}"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL QPL"
DEPENDS = "zlib libpng jpeg tslib uicmoc-native"
PROVIDES = "virtual/qte virtual/libqte2"
PR = "r8"

SRC_URI = "ftp://ftp.trolltech.com/pub/qt/snapshots/qt-embedded-${PV}.tar.gz \
   	   file://qpe.patch;patch=1 \
	   file://vt-switch.patch;patch=1 \
	   file://daemonize.patch;patch=1 \
	   file://no-moc.patch;patch=1 \
	   file://gcc3.patch;patch=1 \
	   file://c700-hardware.patch;patch=1 \
	   file://encoding.patch;patch=1 \
	   file://fix-qgfxraster.patch;patch=1 \
	   file://qt-visibility.patch;patch=1 \
	   file://tslib.patch;patch=1 \
	   file://simpad.patch;patch=1 \
	   file://update-qtfontdir \
	   file://sharp_char.h \
	   file://switches.h "

SRC_URI_append_simpad   	= "file://devfs.patch;patch=1 file://simpad.patch;patch=1 "
SRC_URI_append_corgi		= "file://kernel-keymap.patch;patch=1 file://kernel-keymap-corgi.patch;patch=1 "
SRC_URI_append_shepherd		= "file://kernel-keymap.patch;patch=1 file://kernel-keymap-corgi.patch;patch=1 "
SRC_URI_append_husky		= "file://kernel-keymap.patch;patch=1 file://kernel-keymap-corgi.patch;patch=1 "
SRC_URI_append_tosa		= "file://kernel-keymap.patch;patch=1 file://kernel-keymap-tosa.patch;patch=1 "
SRC_URI_append_beagle   	= "file://beagle.patch;patch=1 "
SRC_URI_append_openzaurus-pxa-2.6 = "file://kernel-keymap.patch;patch=1 "

S = "${WORKDIR}/qt-${PV}"

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

EXTRA_OECONF_CONFIG = "-qconfig qpe"
EXTRA_OECONF = "-system-jpeg -system-libpng -system-zlib -no-qvfb -no-xft -no-vnc -gif \
		-xplatform ${TARGET_OS}-${QTE_ARCH}-g++ ${EXTRA_OECONF_CONFIG} -depths 8,16,32"
EXTRA_OEMAKE = "-e"
PARALLEL_MAKE = ""

#
# FIXME: Add more here
#
EXTRA_DEFINES 			= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DWARNING_UNKNOWN_DEVICE"
EXTRA_DEFINES_collie 		= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_SL5XXX"
EXTRA_DEFINES_poodle		= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_SL5XXX"
EXTRA_DEFINES_tosa		= "-DQT_QWS_TSLIB                 -DQT_QWS_SL5XXX -DQT_QWS_SL6000"
EXTRA_DEFINES_h3600     	= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_IPAQ" 
EXTRA_DEFINES_h3900 		= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_IPAQ"
EXTRA_DEFINES_jornada56x	= "-DQT_QWS_TSLIB                 -DQT_QWS_IPAQ"
EXTRA_DEFINES_simpad		= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_IPAQ   -DQT_QWS_SIMPAD -DQT_QWS_DEVFS"
EXTRA_DEFINES_corgi     	= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_SLC700 -DQT_QWS_SL5XXX"
EXTRA_DEFINES_shepherd  	= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_SLC700 -DQT_QWS_SL5XXX"
EXTRA_DEFINES_husky		= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_SLC700 -DQT_QWS_SL5XXX"
EXTRA_DEFINES_beagle		= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_IPAQ   -DQT_QWS_BEAGLE"
EXTRA_DEFINES_openzaurus-pxa-2.6= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_SLC700"

export SYSCONF_CC = "${CC}"
export SYSCONF_CXX = "${CXX}"
export SYSCONF_LINK = "${CCLD}"
export SYSCONF_SHLIB = "${CCLD}"
export SYSCONF_CFLAGS = "${CFLAGS}"
export SYSCONF_CXXFLAGS = "${CXXFLAGS} -pipe -DQWS -fno-exceptions -fno-rtti -DNO_DEBUG ${EXTRA_DEFINES}"
#export SYSCONF_CXXFLAGS = "${CXXFLAGS} -pipe -DQWS -fno-exceptions -fno-rtti -fvisibility=hidden -DGCC_SUPPORTS_VISIBILITY -DNO_DEBUG ${EXTRA_DEFINES}"
export SYSCONF_LFLAGS = "${LDFLAGS} -lts"
export SYSCONF_MOC = "${STAGING_BINDIR}/moc"
export SYSCONF_UIC = "${STAGING_BINDIR}/uic"

do_configure() {
	for f in ${S}/configs/linux-*-g++-shared; do
		sed -e 's,-linux-,-linux-uclibc-,g' < $f \
			> `dirname $f`/`basename $f | sed -e 's,linux-,linux-uclibc-,'`
	done
	echo yes | ./configure ${EXTRA_OECONF} || die "Configuring qt failed. EXTRA_OECONF was ${EXTRA_OECONF}"
}

do_compile() {
	unset CC LD CCLD CXX RANLIB AR STRIP CFLAGS LDFLAGS CXXFLAGS CPPFLAGS
	install -d include/asm/	
	install -m 0644 ${WORKDIR}/sharp_char.h include/asm/
	install -d include/linux/
	install -m 0644 ${WORKDIR}/switches.h   include/linux/
	oe_runmake
}

do_stage() {
	install -d ${STAGING_DIR}/${HOST_SYS}/qt2/lib
	oe_libinstall -so -C lib libqte ${STAGING_DIR}/${HOST_SYS}/qt2/lib
	rm -f include/qxt.h
	install -d ${STAGING_DIR}/${HOST_SYS}/qt2/include
	cp -pfLR include/* ${STAGING_DIR}/${HOST_SYS}/qt2/include
}

do_install() {
	install -d ${D}/${sbindir}/
	install -m 0755 ${WORKDIR}/update-qtfontdir ${D}/${sbindir}/
	install -d ${D}${palmtopdir}/lib/fonts/
	oe_libinstall -so -C lib libqte ${D}/${palmtopdir}/lib
	cp -a lib/fonts/* ${D}${palmtopdir}/lib/fonts/
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

PACKAGES = "libqte2 qte-font-fixed qte-font-helvetica-small qte-font-helvetica-large \
			qte-font-smoothtimes qte-font-smallsmooth qte-font-unicode qte-font-lcd \
			qte-font-japanese qte-font-micro qte-font-courier"
PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} = ""
FILES_libqte2 = "${palmtopdir}/lib/libqte.so* /usr/sbin/update-qtfontdir"
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
