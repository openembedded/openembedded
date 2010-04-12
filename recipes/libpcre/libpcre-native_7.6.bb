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


SRC_URI[md5sum] = "2af38e083fb90ef60fa9eda7cc290e86"
SRC_URI[sha256sum] = "362e4b4473f2f7a3bfa28ea73e80ec00a2fe525a1aceb5f66e1c528a900bd735"
