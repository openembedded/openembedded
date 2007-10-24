WEBKIT_PORT = "qt"
WEBKIT_EXTRA_OPTIONS = ""
PACKAGES =+ "${PN}launcher-dbg ${PN}launcher"

FILES_${PN}launcher = "${bindir}/QtLauncher"
FILES_${PN}launcher-dbg = "${bindir}/.debug/*"

require webkit.inc

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${libdir}
	install -d ${D}${libdir}/pkgconfig

	install -m 0755 ${S}/WebKitBuilds/Debug/bin/QtLauncher ${D}${bindir}
	cd ${S}/WebKitBuilds/Debug
	PWD=`pwd` ${WEBKIT_QMAKE} WEBKIT_INC_DIR=${D}${prefix}/include WEBKIT_LIB_DIR=${D}${libdir} $PWD/../../WebKit.pro
	oe_runmake install
}

