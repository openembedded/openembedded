SECTION = "base"
include ipkg-utils_${PV}.bb
PR = "r3"
inherit native
DEPENDS = "python-native"

do_stage() {
        for i in ${INSTALL}; do
                install -m 0755 $i ${STAGING_BINDIR}
        done
}
