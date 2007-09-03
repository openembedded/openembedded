DEPENDS = "flex-native gperf-native gperf perl-native curl icu libxml2 sqlite3 cairo libxslt libidn gnutls gtk+"

# Yes, this is wrong...
PV = "0.0+svn${SRCDATE}"
PR = "r1"

inherit qmake2 pkgconfig

SRC_URI = "\
  svn://svn.webkit.org/repository/webkit/trunk/;module=JavaScriptCore;proto=http \
  svn://svn.webkit.org/repository/webkit/trunk/;module=JavaScriptGlue;proto=http \
  svn://svn.webkit.org/repository/webkit/trunk/;module=WebCore;proto=http \
  svn://svn.webkit.org/repository/webkit/trunk/;module=WebKit;proto=http \
  svn://svn.webkit.org/repository/webkit/trunk/;module=WebKitLibraries;proto=http \
#  svn://svn.webkit.org/repository/webkit/trunk/;module=WebKitQt;proto=http \
  svn://svn.webkit.org/repository/webkit/trunk/;module=WebKitTools;proto=http \
  file://Makefile \
  file://Makefile.shared \
  file://WebKit.pri \
  file://WebKit.pro \
"
S = "${WORKDIR}/"

do_configure() {
	qmake2 -spec ${QMAKESPEC} CONFIG+=gdk-port CONFIG-=qt CONFIG-=release CONFIG+=debug
	mkdir -p WebKitBuilds/Debug
	cd WebKitBuilds/Debug
	PWD=`pwd` qmake2 -spec ${QMAKESPEC} -r OUTPUT_DIR=$PWD/ CONFIG-=qt CONFIG+=gdk-port $PWD/../../WebKit.pro \
      WEBKIT_INC_DIR=${prefix}/include WEBKIT_LIB_DIR=${libdir}
}

do_compile_prepend() {
	mkdir -p ${S}/WebKitBuilds/Debug/JavaScriptCore/pcre/tmp/
	cd ${S}/JavaScriptCore/pcre 
	${BUILD_CC} dftables.c -o dftables -I. -I../wtf
	cp dftables ${S}/WebKitBuilds/Debug/JavaScriptCore/pcre/tmp/
	cd ${S}/WebKitBuilds/Debug
}

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${libdir}
	install -d ${D}${libdir}/pkgconfig

	install -m 0755 ${S}/WebKitBuilds/Debug/WebKitTools/GdkLauncher/GdkLauncher ${D}${bindir}
	cd ${S}/WebKitBuilds/Debug
	PWD=`pwd` qmake2 -spec ${QMAKESPEC} -r OUTPUT_DIR=$PWD/ CONFIG-=qt CONFIG+=gdk-port $PWD/../../WebKit.pro \
      WEBKIT_INC_DIR=${D}${prefix}/include WEBKIT_LIB_DIR=${D}${libdir}
	oe_runmake install
}

do_stage() {
	install -d ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}
	cd ${S}/WebKitBuilds/Debug
	PWD=`pwd` qmake2 -spec ${QMAKESPEC} -r OUTPUT_DIR=$PWD/ CONFIG-=qt CONFIG+=gdk-port $PWD/../../WebKit.pro \
      WEBKIT_INC_DIR=${STAGING_INCDIR} WEBKIT_LIB_DIR=${STAGING_LIBDIR}
	oe_runmake install
}

PACKAGES =+ "webkit-gdklauncher-dbg webkit-gdklauncher"

FILES_webkit-gdklauncher = "${bindir}/GdkLauncher"
FILES_webkit-gdklauncher-dbg = "${bindir}/.debug/GdkLauncher"
