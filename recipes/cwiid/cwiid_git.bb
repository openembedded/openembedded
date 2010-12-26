DESCRIPTION = "wiimote library + tools"
LICENSE = "GPLv2"
HOMEPAGE = "http://abstrakraft.org/cwiid/"

PR = "r1"

SRCREV = "fadf11e89b579bcc0336a0692ac15c93785f3f82"
PV = "0.6.00+gitr${SRCREV}"

inherit autotools
inherit distutils-base

DEPENDS += "bluez-libs gtk+ glib-2.0 atk"

RDEPENDS_libcwiid = "bluez-libs"
RDEPENDS_lwsm = "bluez-libs libcwiid"
RDEPENDS_wmgui = "bluez-libs libcwiid glib-2.0 gtk+ atk"
RDEPENDS_wminput = "bluez-libs libcwiid python python-cwiid"
RDEPENDS_python-cwiid = "bluez-libs libcwiid python" 

export BUILD_SYS
export HOST_SYS

PARALLEL_MAKE = ""

SRC_URI = "git://github.com/abstrakraft/cwiid.git;protocol=git"
S = "${WORKDIR}/git"

EXTRA_OECONF = "--disable-ldconfig"

LEAD_SONAME = "libcwiid.so.1"

PACKAGES = "libcwiid libcwiid-dev libcwiid-dbg lswm lswm-dbg wmgui wmgui-dbg \
	wminput wminput-dbg python-cwiid python-cwiid-dbg"

FILES_libcwiid = "${libdir}/libcwiid.so.*"
FILES_libcwiid-dbg = "${libdir}/.debug/libcwiid.so.*"
FILES_libcwiid-dev = "${libdir}/libcwiid.so ${libdir}/libcwiid.a ${includedir} /usr/lib/pkgconfig/"
FILES_lswm = "${bindir}/lswm ${mandir}/man1/wmgui.1"
FILES_lswm-dbg = "${bindir}/.debug/lswm"
FILES_wmgui = "${bindir}/wmgui"
FILES_wmgui-dbg = "${bindir}/.debug/wmgui"
FILES_wminput = "${bindir}/wminput ${sysconfdir}/cwiid/ ${libdir}/cwiid/plugins/*.so \
	${mandir}/man1/wminput.1 ${docdir}"
FILES_wminput-dbg = "${bindir}/.debug/wminput ${libdir}/cwiid/plugins/.debug/"
FILES_python-cwiid = "${libdir}/python2.6/*/cwiid*"
FILES_python-cwiid-dbg = "${libdir}/python2.6/*/.debug/"

do_configure_append() {
	find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
 	find ${S} -name Makefile | xargs sed -i s:'-I/usr/include':'-I${STAGING_INCDIR}':g
}


