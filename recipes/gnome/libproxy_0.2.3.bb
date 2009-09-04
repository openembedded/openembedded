DESCRIPTION = "A library handling all the details of proxy configuration"
LICENSE = "LGPL"
DEPENDS = "libxmu gconf virtual/libx11"

PR = "r1"

SRC_URI = "http://libproxy.googlecode.com/files/libproxy-${PV}.tar.gz \
	   file://libproxy-move-define-__USE_BSD.patch;patch=1 \
	   "

inherit autotools_stage

# Disable plugins that are *up* in the depchain, they need libproxy to build
# Don't we just love circular deps?
EXTRA_OECONF = " --with-file \
                 --with-gnome \
                 --without-kde \
                 --without-webkit \
                 --without-mozjs \
                 --without-networkmanager \
                "

FILES_${PN}-dbg += "${libdir}/libproxy/*/plugins/.debug"

