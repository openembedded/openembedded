SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libx11"
DESCRIPTION = "Cairo support library"
LICENSE = "X11"
SRC_URI = "http://cairographics.org/snapshots/libpixman-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "4af4bbf35840016f40f287a0bb6526b1"
SRC_URI[sha256sum] = "e4ad16bd198722ba4ea41be77b17fe1c2b6e60de7a96fc4aac6a7b20f3fa448d"
