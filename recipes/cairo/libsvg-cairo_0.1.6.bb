SECTION = "libs"
LICENSE = "LGPL"
PRIORITY = "optional"
DEPENDS = "libsvg cairo"
DESCRIPTION = "SVG rendering library"

SRC_URI = "http://cairographics.org/snapshots/libsvg-cairo-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "d79da7b3a60ad8c8e4b902c9b3563047"
SRC_URI[sha256sum] = "a380be6a78ec2938100ce904363815a94068fca372c666b8cc82aa8711a0215c"
