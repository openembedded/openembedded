DESCRIPTION = "The Enlightenment Canvas Library"
include evas_${PV}.bb
inherit native
DEPENDS = "freetype-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/evas"

do_stage () {
        for i in ${headers}; do
                install -m 0644 ${S}/src/lib/$i ${STAGING_INCDIR}/
        done
        oe_libinstall -C src/lib libevas ${STAGING_LIBDIR}/
}

#FIXME: Conflicts with zlib-devel on the build machine. Remove it and it builds.
