WEBKIT_PORT = "qt"
WEBKIT_EXTRA_OPTIONS = ""

FILES_${PN}launcher = "${bindir}/QtLauncher"
FILES_${PN}launcher-dbg += "${bindir}/.debug/*"

RDEPENDS += "openssl"

require webkit.inc

PR = "r6"
SRC_URI += " file://qt-api-changes.diff;patch=0;pnum=0 \
             file://qtwebkit-use-image-decoders.patch;patch=0 "

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${libdir}
	install -d ${D}${libdir}/pkgconfig

	install -m 0755 ${S}/WebKitBuilds/Debug/bin/QtLauncher ${D}${bindir}
	cd ${S}/WebKitBuilds/Debug
	PWD=`pwd` ${WEBKIT_QMAKE} WEBKIT_INC_DIR=${D}${prefix}/include WEBKIT_LIB_DIR=${D}${libdir} $PWD/../../WebKit.pro
	oe_runmake install

    oe_libinstall -C ${S}/WebKitBuilds/Debug/lib libQtWebKit ${D}${libdir}
}

# disabled as Qt and Qtopia will not like each other...
#do_stage_prepend() {
#    oe_libinstall -C ${S}/WebKitBuilds/Debug/lib libQtWebKit ${D}${libdir}
#}

