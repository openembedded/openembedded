DESCRIPTION = " Webkit browser engine, EFL edition"
LICENSE = "GPL"
PV="0.0.1"
PR="r0"
DEPENDS = "icu gst-plugins-base gstreamer jpeg libpng libxml2 pango libsoup eina ecore evas edje cairo fontconfig freetype curl sqlite libxslt"

SRC_URI = "git://code.staikos.net/webkit;branch=origin/kenneth/efl-port;protocol=git"

S= "${WORKDIR}/webkit"

inherit autotools lib_package
EXTRA_OECONF = "--with-port=efl --enable-web-workers=no"
