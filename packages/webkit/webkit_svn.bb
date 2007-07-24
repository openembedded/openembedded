DEPENDS = "libpcre flex-native gperf-native gperf perl-native curl icu uicmoc4-native qmake2-native libxml2 sqlite3 cairo libxslt libidn gnutls gtk+"

# Yes, this is wrong...
PV = "0.0+svn${SRCDATE}"
PR = "r1"

inherit qmake pkgconfig

SRC_URI = "\
           svn://svn.webkit.org/repository/webkit/trunk/;module=JavaScriptCore;proto=http \
           svn://svn.webkit.org/repository/webkit/trunk/;module=JavaScriptGlue;proto=http \
           svn://svn.webkit.org/repository/webkit/trunk/;module=WebCore;proto=http \
           svn://svn.webkit.org/repository/webkit/trunk/;module=WebKit;proto=http \
           svn://svn.webkit.org/repository/webkit/trunk/;module=WebKitLibraries;proto=http \
#           svn://svn.webkit.org/repository/webkit/trunk/;module=WebKitQt;proto=http \
           svn://svn.webkit.org/repository/webkit/trunk/;module=WebKitTools;proto=http \
           file://Makefile \
	   file://Makefile.shared \
	   file://WebKit.pri \
	   file://WebKit.pro \
"

S = "${WORKDIR}/"


do_configure_append() {
        qmake2 -spec ${QMAKESPEC} CONFIG+=gdk-port CONFIG-=qt CONFIG-=release CONFIG+=debug
	mkdir -p WebKitBuilds/Debug
	cd WebKitBuilds/Debug
	PWD=`pwd` qmake2 -spec ${QMAKESPEC} -r OUTPUT_DIR=$PWD/ CONFIG-=qt CONFIG+=gdk-port $PWD/../../WebKit.pro
}

do_compile_prepend() {
         mkdir -p ${S}/WebKitBuilds/Debug/JavaScriptCore/pcre/tmp/
	 cp ${STAGING_BINDIR_NATIVE}/dftables ${S}/WebKitBuilds/Debug/JavaScriptCore/pcre/tmp/
         cd ${S}/WebKitBuilds/Debug
}

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${libdir}
	install -d ${D}${libdir}/pkgconfig

	install -m 0755 ${S}/WebKitBuilds/Debug/WebKitTools/GdkLauncher/GdkLauncher ${D}${bindir}
	cp -pPR WebKitBuilds/Debug/lib/*.so* ${D}${libdir} 
	cp -pPR WebKitBuilds/Debug/lib/*.pc ${D}${libdir}/pkgconfig/ || true
}


PACKAGES =+ "webkit-gdklauncher-dbg webkit-gdklauncher"

FILES_webkit-gdklauncher = "${bindir}/GdkLauncher"
FILES_webkit-gdklauncher-dbg = "${bindir}/.debug/GdkLauncher"



