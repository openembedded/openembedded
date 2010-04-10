DESCRIPTION = "Startup notification support"
LICENSE = "LGPL"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libx11 libsm"

inherit autotools pkgconfig

SRC_URI = "http://www.freedesktop.org/software/startup-notification/releases/startup-notification-0.8.tar.gz"

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "9bba52ffe8c096cfeeaf7a1dcd9b943d"
SRC_URI[sha256sum] = "7b5d0458b7831ed96633fca771e5707bfd2d3c1c91a8442c6f412e6fa98025bf"
