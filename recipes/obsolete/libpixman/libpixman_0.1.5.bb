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

SRC_URI[md5sum] = "756107dd2b23553df2f85cd92cab82d5"
SRC_URI[sha256sum] = "4d18f3d9dbbe877b4cfd240891b711179e2ac8b8ad61392aa309e35d9c912d63"
