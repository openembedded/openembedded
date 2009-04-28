DESCRIPTION = " Webkit browser engine, EFL edition"
LICENSE = "GPL"
PV="0.0.1"
PR="r0"
DEPENDS = "icu gst-plugins-base gstreamer jpeg libpng libxml2 pango libsoup-2.4 eina ecore evas edje cairo fontconfig freetype curl sqlite libxslt gperf-native"

SRC_URI = "git://code.staikos.net/webkit;branch=kenneth/efl-port;protocol=git"

S= "${WORKDIR}/git"

inherit autotools lib_package pkgconfig

EXTRA_OECONF = "--with-port=efl --enable-web-workers=no"

do_configure() {
	sh autogen.sh --host=${TARGET_SYS}
}

