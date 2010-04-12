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



SRC_URI[md5sum] = "905411e1deda0aee17ae99dbdeaf7506"
SRC_URI[sha256sum] = "bb5d2a846dbb5c9e779cec37a0ebdb4b1c8071131cfcce05358a08367281c38a"
