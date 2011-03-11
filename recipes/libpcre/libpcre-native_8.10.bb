SECTION = "unknown"
require libpcre_${PV}.bb
inherit native
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libpcre-${PV}"

# NOTE: multiple providers are available (libpcre, libpcre-native);
# NOTE: consider defining PREFERRED_PROVIDER_pcre
PROVIDES = ""

do_compile () {
	# The generation of dftables can lead to timestamp problems with ccache
	# because the generated config.h seems newer.  It is sufficient to ensure that the
	# attempt to build dftables inside make will actually work (foo_FOR_BUILD is
	# only used for this).
	oe_runmake CC_FOR_BUILD="${BUILD_CC}" CFLAGS_FOR_BUILD="-DLINK_SIZE=2 -I${S}/include" LINK_FOR_BUILD="${BUILD_CC}"
}

SRC_URI[md5sum] = "780867a700e9d4e4b9cb47aa5453e4b2"
SRC_URI[sha256sum] = "7ac4e016f6bad8c7d990e6de9bce58c04ff5dd8838be0c5ada0afad1d6a07480"
