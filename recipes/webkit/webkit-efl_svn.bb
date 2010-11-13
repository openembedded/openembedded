DESCRIPTION = "Webkit browser engine, EFL edition"
LICENSE = "GPL"
DEPENDS = "icu libxslt sqlite3 gperf-native bison-native flex-native jpeg \
           libpng libxt fontconfig cairo freetype glib-2.0 libsoup-2.4 \
           libxml2 pango eina ecore evas edje"

SRCREV = "72648"
PV = "1.3.4+svnr${SRCPV}"
PR = "r1"

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

# Wants to jump too far for THUMB on armv4t
# in WebCore::DocTypeStringsHash::doctype_hash_function(char const*, unsigned int)':
# DocTypeStrings.cpp:(.text._ZN7WebCore18DocTypeStringsHash21doctype_hash_functionEPKcj[WebCore::DocTypeStringsHash::doctype_hash_function(char const*, unsigned int)]+0x12): relocation truncated to fit: R_ARM_THM_CALL against symbol `__gnu_thumb1_case_uhi' defined in .text section in x86_64-linux/usr/armv4t/lib/gcc/arm-oe-linux-gnueabi/4.5.2/libgcc.a(_thumb1_case_uhi.o)
# the same in WebCore::CSSValueKeywordsHash::value_hash_function(char const*, unsigned int)':
#             WebCore::CSSPropertyNamesHash::propery_hash_function(char const*, unsigned int)':
#             WebCore::ColorDataHash::colordata_hash_function(char const*, unsigned int)':
ARM_INSTRUCTION_SET = "ARM"

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
