DESCRIPTION = " Webkit browser engine, EFL edition"
LICENSE = "GPL"
DEPENDS = "icu flex gst-plugins-base gstreamer jpeg libpng libxml2 pango \
           libsoup-2.4 eina ecore evas edje cairo fontconfig freetype curl \
           sqlite3 libxslt gperf-native libxt"

PV = "1.1.11+gitr${SRCREV}"
PR = "r4"

SRC_URI = "git://gitorious.org/webkit-efl/webkit-efl.git;protocol=git;branch=master \
           file://fix-build-with-newer-evas.patch;patch=1"

S = "${WORKDIR}/git"

inherit autotools lib_package pkgconfig

EXTRA_OECONF = "--disable-video --host=${TARGET_SYS} --with-port=efl --enable-web-workers=no"

PACKAGES =+ "${PN}-webinspector"

FILES_${PN} += "${datadir}/webkit-1.0/theme/default.edj"
FILES_${PN}-webinspector = "${datadir}/webkit-1.0/webinspector/"
