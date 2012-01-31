DESCRIPTION = "Gives a fake root environment"
HOMEPAGE = "http://fakeroot.alioth.debian.org/"
SECTION = "base"
LICENSE = "GPL"
# fakeroot needs getopt which is provided by the util-linux package
RDEPENDS_${PN} = "util-linux"

require fakeroot.inc

PR = "${INC_PR}.0"

inherit autotools

SRC_URI =+ "\
	${DEBIAN_MIRROR}/main/f/fakeroot/fakeroot_${PV}.orig.tar.bz2 \
	file://0001-quiet-getopt-check.patch \
	"

SRC_URI[md5sum] = "79f32331358ad58499704ea5e19fd0ae"
SRC_URI[sha256sum] = "9dc942e3ef2ec83c6e6fe59de05da6ab54f39948be64803f37721adab4c6aed8"
