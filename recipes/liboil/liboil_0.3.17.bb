DESCRIPTION = "Liboil is a library of simple functions that are optimized for various CPUs."
HOMEPAGE = "http://liboil.freedesktop.org/"
LICENSE = "liboil"
PR = "r1"

DEPENDS = "glib-2.0"

SRC_URI = " \
	http://liboil.freedesktop.org/download/${P}.tar.gz \
	file://fix-unaligned-whitelist.patch;apply=yes \
"

inherit autotools pkgconfig

SRC_URI[md5sum] = "47dc734f82faeb2964d97771cfd2e701"
SRC_URI[sha256sum] = "105f02079b0b50034c759db34b473ecb5704ffa20a5486b60a8b7698128bfc69"
