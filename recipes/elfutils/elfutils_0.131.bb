DESCRIPTION = "A collection of utilities and DSOs to handle compiled objects."
SECTION = "base"
LICENSE = "OSL"
DEPENDS = "libtool"

SRC_URI = "http://distro.ibiblio.org/pub/linux/distributions/gentoo/distfiles/elfutils-${PV}.tar.gz \
	   file://warnings.patch;patch=1"

inherit autotools

do_stage () {
	autotools_stage_all
}



SRC_URI[md5sum] = "f7963fba80c6f74cd6c4990d2a76d121"
SRC_URI[sha256sum] = "947a9566a622f701a2fe2416d3b85b397d38d5f4189da91fc0a306b4d9950e6f"
