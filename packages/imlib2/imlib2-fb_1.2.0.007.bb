SECTION = "libs"
LICENSE = "BSD"
include imlib2.inc
inherit native
DEPENDS = "freetype"

EXTRA_OECONF = "--without-x \
		--disable-mmx"
