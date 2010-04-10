DESCRIPTION = "Startup notification support"
LICENSE = "LGPL"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libx11 libsm"

inherit autotools pkgconfig

SRC_URI = "http://www.freedesktop.org/software/startup-notification/releases/startup-notification-${PV}.tar.gz"

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "5480d3af709523ec70e0e04692744f2d"
SRC_URI[sha256sum] = "c2fa09f9a49d8b319e79638e49e967c682df8726006e03059b1ffca5ab82099c"
