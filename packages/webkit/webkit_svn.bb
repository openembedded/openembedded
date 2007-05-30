DEPENDS = "flex-native curl icu uicmoc4-native qmake2-native libxml2 sqlite3 cairo gtk+"

# Yes, this is wrong...
PV = "0.0+svn${SRCDATE}"

inherit qmake

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
        cd ${S}/WebKitBuilds/Debug
}
