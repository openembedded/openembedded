SECTION = "unknown"
include eet_${PV}.bb
inherit native
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/eet"
DEPENDS = "zlib-native jpeg-native"

do_stage () {
        oe_libinstall -C src/lib libeet ${STAGING_LIBDIR}/
        install -m 0644 ${S}/src/lib/Eet.h ${STAGING_INCDIR}/
}
