DESCRIPTION = " Webkit browser engine, EFL edition"
LICENSE = "GPL"
PV="0.1+gitr${SRCPV}"
PR="r1"

DEPENDS = "icu flex gst-plugins-base gstreamer jpeg libpng libxml2 pango \
           libsoup-2.4 eina ecore evas edje cairo fontconfig freetype curl \
           sqlite3 libxslt gperf-native libxt"

SRC_URI = "git://gitorious.org/webkit-efl/webkit-efl.git;protocol=git;branch=master"

S= "${WORKDIR}/git"

inherit autotools lib_package pkgconfig

EXTRA_OECONF = "--disable-video --host=${TARGET_SYS} --with-port=efl --enable-web-workers=no"

do_stage() {
    autotools_stage_all
}

PACKAGES =+ "${PN}-webinspector"
FILES_${PN}-webinspector = "${datadir}/webkit-1.0/webinspector/"
