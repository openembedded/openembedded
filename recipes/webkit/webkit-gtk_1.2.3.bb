DESCRIPTION = "WebKit browser engine, GTK+ edition"
DEPENDS = "geoclue enchant gtk-doc-native gtk-doc gnome-keyring libsoup-2.4 curl icu libxml2 cairo libxslt libxt libidn gnutls gtk+ gstreamer gst-plugins-base gnome-vfs bison-native flex-native gperf-native perl-native sqlite3"


SRC_URI = "http://webkitgtk.org/webkit-${PV}.tar.gz"
SRC_URI[md5sum] = "0ab5c478a6f5b74a1ae96bf13a456662"
SRC_URI[sha256sum] = "ff70b25ea8dedc0031f29f2ea8d9aa226bfa65ebd2f12772390f4e2845306fe1"

S = "${WORKDIR}/webkit-${PV}"

inherit autotools lib_package

export BISON="${STAGING_BINDIR_NATIVE}/bison"
ARM_INSTRUCTION_SET = "arm"
EXTRA_OECONF = "\
                --enable-debug=no \
                --enable-svg \
                --enable-icon-database=yes \
                --enable-geolocation=yes \
#                --with-unicode-backend=glib \
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

PACKAGES =+ "${PN}-webinspector ${PN}launcher-dbg ${PN}launcher libjavascriptcore"
FILES_${PN}launcher = "${bindir}/GtkLauncher"
FILES_${PN}launcher-dbg = "${bindir}/.debug/GtkLauncher"
FILES_libjavascriptcore = "${libdir}/libJavaScriptCore.so.*"
FILES_${PN}-webinspector = "${datadir}/webkit*/webinspector/"
FILES_${PN} += "${datadir}/webkit*/resources/error.html ${datadir}/webkit*/images"

