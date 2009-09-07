DESCRIPTION = "WebKit browser engine, GTK+ edition"
DEPENDS = "libsoup-2.4 icu libxml2 cairo libxslt libxt libidn gnutls gtk+ gstreamer gst-plugins-base gnome-vfs bison-native flex-native gperf-native perl-native sqlite3"

SRCREV_FORMAT = "webcore-rwebkit"

PR = "r1"

SRC_URI = "\
	http://www.webkitgtk.org/webkit-${PV}.tar.gz \
 "

S = "${WORKDIR}/webkit-${PV}"

inherit autotools pkgconfig lib_package

export BISON="${STAGING_BINDIR_NATIVE}/bison"
ARM_INSTRUCTION_SET = "arm"
EXTRA_OECONF = "\
                --enable-debug=no \
                --enable-svg \
                --enable-icon-database=yes \
		--with-http-backend=soup \
               "
EXTRA_AUTORECONF = " -I autotools "

# Dolt gets used on x86 and ppc and hardcodes 'libtool'
do_configure_append() {
	cp ${TARGET_PREFIX}libtool libtool || true
}

do_compile_prepend() {
        mkdir -p ${S}/WebKitBuilds/Debug/JavaScriptCore/pcre/tmp/
        mkdir -p ${S}/Programs/
	cd ${S}/JavaScriptCore/pcre
        if test -e dftables.c
        then
            ${BUILD_CC} dftables.c -o dftables -I. -I../wtf
        elif test -e dftables.cpp
        then
            ${BUILD_CXX} dftables.cpp -o dftables -I. -I../wtf
        fi
        cp dftables ${S}/WebKitBuilds/Debug/JavaScriptCore/pcre/tmp/
        cp dftables ${S}/Programs/        
	cd ${S}
}

do_stage() {
	autotools_stage_all
}

PACKAGES =+ "${PN}-webinspector ${PN}launcher-dbg ${PN}launcher libjavascriptcore"
FILES_${PN}launcher = "${bindir}/GtkLauncher"
FILES_${PN}launcher-dbg = "${bindir}/.debug/GtkLauncher"
FILES_libjavascriptcore = "${libdir}/libJavaScriptCore.so.*"
FILES_${PN}-webinspector = "${datadir}/webkit-1.0/webinspector/"


