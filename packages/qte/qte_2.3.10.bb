DESCRIPTION = "Qt/Embedded Version ${PV}"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL QPL"
DEPENDS = "zlib libpng jpeg tslib uicmoc-native"
DEPENDS_mnci = "zlib libpng jpeg uicmoc-native"
DEPENDS_append_c7x0 = " sharp-aticore-oss"
PROVIDES = "virtual/qte virtual/libqte2"
PR = "r18"

SRC_URI = "ftp://ftp.trolltech.com/pub/qt/source/qt-embedded-${PV}-free.tar.gz;md5=1f7ad30113afc500cab7f5b2f4dec0d7 \
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
	   file://handhelds.patch;patch=1 \
	   file://qiconview-speed.patch;patch=1 \
	   file://qtabbar.patch;patch=1 \
	   file://increase-qxml-robustness.patch;patch=1 \
	   file://qte-fix-iconsize.patch;patch=1 \
	   file://sharp_char.h \
	   file://key.patch;patch=1 \
	   file://switches.h \
           file://bidimetrics.patch;patch=5 "

SRC_URI_append_simpad   	= "file://devfs.patch;patch=1 "
SRC_URI_append_c7x0		= "file://kernel-keymap.patch;patch=1 file://kernel-keymap-corgi.patch;patch=1 file://c7x0-w100-accel.patch;patch=1 "
SRC_URI_append_spitz		= "file://kernel-keymap.patch;patch=1 file://kernel-keymap-corgi.patch;patch=1 file://kernel-keymap-CXK.patch;patch=1 "
SRC_URI_append_akita            = "file://kernel-keymap.patch;patch=1 file://kernel-keymap-corgi.patch;patch=1 file://kernel-keymap-CXK.patch;patch=1 "
SRC_URI_append_tosa		= "file://kernel-keymap.patch;patch=1 file://kernel-keymap-tosa.patch;patch=1 "
SRC_URI_append_beagle   	= "file://beagle.patch;patch=1 "
SRC_URI_append_jornada7xx       = "file://kernel-keymap.patch;patch=1 file://ipaq_sound_fix.patch;patch=1 "
SRC_URI_append_jornada56x       = "file://kernel-keymap.patch;patch=1 file://ipaq_sound_fix.patch;patch=1 "
SRC_URI_append_mnci             = "file://devfs.patch;patch=1 \
                                   file://mnci.patch;patch=1 \
                                   file://mnci-touchscreen.patch;patch=1 \
				   file://qkeyboard_qws.h \
				   file://qkeyboard_qws.cpp "
SRC_URI_append_h3600            = "file://ipaq-keyboard.patch;patch=1 file://ipaq_sound_fix.patch;patch=1 "
SRC_URI_append_h3900            = "file://ipaq-keyboard.patch;patch=1 file://ipaq_sound_fix.patch;patch=1 "


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
EXTRA_OECONF_CONFIG_c7x0 = "-qconfig qpe -accel-w100"
EXTRA_OECONF = "-system-jpeg -system-libpng -system-zlib -no-qvfb -no-xft -no-vnc -gif \
		-xplatform ${TARGET_OS}-${QTE_ARCH}-g++ ${EXTRA_OECONF_CONFIG} -depths 8,16,32"
EXTRA_OEMAKE = "-e"

#
# FIXME: Add more here
#
EXTRA_DEFINES 			= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DWARNING_UNKNOWN_DEVICE"
EXTRA_DEFINES_collie 		= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_SL5XXX"
EXTRA_DEFINES_poodle		= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_SL5XXX"
EXTRA_DEFINES_tosa		= "-DQT_QWS_TSLIB                 -DQT_QWS_SL5XXX -DQT_QWS_SL6000"
EXTRA_DEFINES_h3600     	= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_IPAQ" 
EXTRA_DEFINES_h3900 		= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_IPAQ"
EXTRA_DEFINES_jornada56x	= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_IPAQ"
EXTRA_DEFINES_jornada6xx	= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_IPAQ"
EXTRA_DEFINES_jornada7xx	= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_IPAQ"
EXTRA_DEFINES_simpad		= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_IPAQ   -DQT_QWS_SIMPAD -DQT_QWS_DEVFS"
EXTRA_DEFINES_c7x0		= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_SLC700 -DQT_QWS_SL5XXX"
EXTRA_DEFINES_spitz		= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_SLC700 -DQT_QWS_SL5XXX -DQT_QWS_SLCXK"
EXTRA_DEFINES_akita             = "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_SLC700 -DQT_QWS_SL5XXX -DQT_QWS_SLCXK"
EXTRA_DEFINES_beagle		= "-DQT_QWS_TSLIB -DQT_QWS_CUSTOM -DQT_QWS_IPAQ   -DQT_QWS_BEAGLE"
EXTRA_DEFINES_mnci 		= "                               -DQT_QWS_RAMSES                 -DQT_QWS_DEVFS"

export SYSCONF_CC = "${CC}"
export SYSCONF_CXX = "${CXX}"
export SYSCONF_LINK = "${CCLD}"
export SYSCONF_SHLIB = "${CCLD}"
export SYSCONF_CFLAGS = "${CFLAGS}"
export SYSCONF_LINK_SHLIB = "${CCLD}"
export SYSCONF_CXXFLAGS = "${CXXFLAGS} -pipe -DQWS -fno-exceptions -fno-rtti -DNO_DEBUG ${EXTRA_DEFINES} -DUSE_BIDI"
#export SYSCONF_CXXFLAGS = "${CXXFLAGS} -pipe -DQWS -fno-exceptions -fno-rtti -fvisibility=hidden -DGCC_SUPPORTS_VISIBILITY -DNO_DEBUG ${EXTRA_DEFINES} -DUSE_BIDI"
export SYSCONF_LFLAGS = "${LDFLAGS} -lts"
export SYSCONF_LFLAGS_mnci = "${LDFLAGS}"
export SYSCONF_MOC = "${STAGING_BINDIR}/moc"
export SYSCONF_UIC = "${STAGING_BINDIR}/uic"

do_configure_prepend_mnci() {
	chmod -R a+w ${S}/src/kernel
	cp ${WORKDIR}/qkeyboard_qws.h ${S}/src/kernel
	cp ${WORKDIR}/qkeyboard_qws.cpp ${S}/src/kernel
	mkdir bin
	ln -sf ${STAGING_BINDIR}/moc bin/moc
	ln -sf ${STAGING_BINDIR}/uic bin/uic
}

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

	# Create symlinks first and then compile the library
	oe_runmake symlinks
	oe_runmake src-mt sub-src
}

do_stage() {
	rm -rf ${STAGING_DIR}/${HOST_SYS}/qt2
	install -d ${STAGING_DIR}/${HOST_SYS}/qt2/lib
	oe_libinstall -so -C lib libqte ${STAGING_DIR}/${HOST_SYS}/qt2/lib
	rm -f include/qxt.h
	install -d ${STAGING_DIR}/${HOST_SYS}/qt2/include
	cp -pfLR include/* ${STAGING_DIR}/${HOST_SYS}/qt2/include
	cp -a lib/fonts ${STAGING_DIR}/${HOST_SYS}/qt2/lib/
}

do_install() {
	oe_libinstall -so -C lib libqte ${D}${palmqtdir}/lib/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
FILES_${PN} = "${palmqtdir}"
