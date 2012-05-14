DESCRIPTION = "A library handling all the details of proxy configuration"
LICENSE = "LGPLv2.1+"
DEPENDS = "libxmu gconf virtual/libx11"

PR = "r2"

SRC_URI = "http://libproxy.googlecode.com/files/libproxy-${PV}.tar.gz \
	   file://libproxy-move-define-__USE_BSD.patch \
	   "

inherit autotools

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


SRC_URI[md5sum] = "86b635e1eb2d665cfbef4c6134fe6604"
SRC_URI[sha256sum] = "59ded160b3547d29e37cc9d06359f7f37d94112214e4532430cd65e704c1339a"
