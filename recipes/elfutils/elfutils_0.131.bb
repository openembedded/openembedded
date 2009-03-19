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


