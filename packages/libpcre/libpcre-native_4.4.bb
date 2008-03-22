SECTION = "unknown"
require libpcre_${PV}.bb
inherit native
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libpcre-${PV}"

# NOTE: multiple providers are available (libpcre, libpcre-native);
# NOTE: consider defining PREFERRED_PROVIDER_pcre
PROVIDES = ""

SRC_URI += "file://native-rpath-link.patch;patch=1"

do_compile () {
	# The generation of dftables can lead to timestamp problems with ccache
	# because the generated config.h seems newer.  It is sufficient to ensure that the
	# attempt to build dftables inside make will actually work (foo_FOR_BUILD is
	# only used for this).
	oe_runmake CC_FOR_BUILD="${BUILD_CC}" CFLAGS_FOR_BUILD="-DLINK_SIZE=2 -I${S}/include" LINK_FOR_BUILD="${BUILD_CC}"
}

