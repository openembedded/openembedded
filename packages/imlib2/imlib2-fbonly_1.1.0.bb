SECTION = "libs"
LICENSE = "BSD"
include imlib2_${PV}.bb
inherit native
DEPENDS = "freetype"

EXTRA_OECONF = "--without-x \
		--disable-mmx"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/imlib2-${PV}"
