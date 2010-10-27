DESCRIPTION = "Webkit browser engine, EFL edition"
LICENSE = "GPL"
DEPENDS = "icu libxslt sqlite3 gperf-native bison-native flex-native jpeg \
           libpng libxt fontconfig cairo freetype glib-2.0 libsoup-2.4 \
           libxml2 pango eina ecore evas edje"

SRCREV = "70645"
PV = "1.3.4+svnr${SRCPV}"

SRCREV_FORMAT = "webcore-rwebkit"

SRC_URI = "\
  svn://svn.webkit.org/repository/webkit/trunk/;module=JavaScriptCore;proto=http;subdir=src \
  svn://svn.webkit.org/repository/webkit/trunk/;module=JavaScriptGlue;proto=http;subdir=src \
  svn://svn.webkit.org/repository/webkit/trunk/;module=WebCore;proto=http;name=webcore;subdir=src \
  svn://svn.webkit.org/repository/webkit/trunk/;module=WebKit;proto=http;name=webkit;subdir=src \
  svn://svn.webkit.org/repository/webkit/trunk/;module=WebKitLibraries;proto=http;subdir=src \
  svn://svn.webkit.org/repository/webkit/trunk/;module=WebKitTools;proto=http;subdir=src \
  svn://svn.webkit.org/repository/webkit/trunk/;module=cmake;proto=http;subdir=src \
  file://cmakeconfig.h.cmake \
  file://CMakeLists.txt \
 "

S = "${WORKDIR}/src"

inherit cmake lib_package pkgconfig

#EXTRA_OECMAKE = "-DPORT=Efl"
EXTRA_OECMAKE = "-DPORT=Efl -DSHARED_CORE=ON"

do_unpack_append() {
	bb.build.exec_func('do_move_files', d)
}

do_move_files() {
	mv "${WORKDIR}/cmakeconfig.h.cmake" "${S}"
	mv "${WORKDIR}/CMakeLists.txt" "${S}"
}

LEAD_SONAME = "libewebkit.so"
PACKAGES =+ "${PN}launcher-dbg ${PN}launcher"

FILES_${PN} += "${datadir}/webkit-1.0/theme/default.edj ${datadir}/ewebkit-0/themes/default.edj"
FILES_${PN}launcher = "${bindir}/EWebLauncher"
FILES_${PN}launcher-dbg = "${bindir}/.debug/EWebLauncher"
