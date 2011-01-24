DESCRIPTION = "XBMC Media Center"
LICENSE = "xbmc"

DEPENDS = "gperf-native libxmu fribidi mpeg2dec ffmpeg samba fontconfig curl python libmodplug libmicrohttpd wavpack libmms cmake-native libsdl-image libsdl-mixer virtual/egl mysql5 sqlite3 libmms faad2 libcdio libpcre boost lzo2 enca avahi libsamplerate0 libxinerama libxrandr libxtst bzip2 virtual/libsdl jasper zip-native zlib"
require recipes/egl/egl.inc

SRCREV = "e2ab481ebe964321c358ab9d6402088c714adcbe"

PV = "10.05"
PR = "r11"
PR_append = "+gitr${SRCPV}"

SRC_URI = "git://xbmc.git.sourceforge.net/gitroot/xbmc/xbmc;protocol=git;branch=master \
file://0001-Only-check-for-nasm-on-i686-it-is-bogus-on-ARM-which.patch \
file://0002-Exclude-gnu-configize-for-ngstr-m-Thanks-koen.patch \
file://0003-Workaround-to-compile-python-on-ngstr-m-with-Python-.patch \
file://0004-Don-t-use-sudo-in-install-of-xbmc.bin-not-all-distri.patch \
file://0005-Hardcode-arm7-for-now.patch \
file://0006-Hardcode-python2.6-for-now.patch \
file://0007-No-need-for-FEH-on-embedded-need-a-better-way-to-not.patch \
file://0008-configure.in-also-pass-down-target-when-using-host-a.patch \
file://0009-Added-a-configure-option-disable-optical-drive.patch \
file://0010-Fixed-so-compile-worked-when-disabling-optical.patch \
file://0011-reverted-so-normal-bootstrap-doesn-t-exclude-gnu-con.patch \
file://0012-fix-lzo-things.patch \
"

inherit autotools gettext

S = "${WORKDIR}/git"

EXTRA_OECONF = " \
 --enable-gles \
 --disable-optical-drive \
 --enable-external-libraries \
"

do_configure() {
	if [ -e bootstrap.angstrom ] ; then
		sh bootstrap.angstrom
	else
		sh bootstrap
	fi
	oe_runconf
}

do_compile_prepend() {
	for i in $(find . -name "Makefil*") ; do
		sed -i 's:I/usr/include:I${STAGING_INCDIR}:g' $i
	done
	for i in $(find . -name "*.mak*") ; do
		sed -i 's:I/usr/include:I${STAGING_INCDIR}:g' $i
	done
	sed -i 's:I/usr/include:I${STAGING_INCDIR}:g' ${S}/Makefile	
}

do_install_append() {
	ln -sf ${libdir}/xbmc/system/python/python24-arm.so ${D}${datadir}/xbmc/system/python/ || true
	ln -sf ${libdir}/xbmc/system/python/python26-arm.so ${D}${datadir}/xbmc/system/python/ || true
}

FILES_${PN} += "${datadir}/xsessions"
FILES_${PN}-dbg += "${libdir}/xbmc/.debug ${libdir}/xbmc/*/.debug ${libdir}/xbmc/*/*/.debug ${libdir}/xbmc/*/*/*/.debug"

# Only builds with glibc currently, so this is "safe"
RRECOMMENDS_${PN} += "glibc-charmap-ibm850 glibc-gconv-ibm850"

# GNU_HASH QA errors...
INSANE_SKIP_${PN} = "True"


