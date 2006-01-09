SECTION = "base"
include ipkg-utils_${PV}.bb
PR = "r4"
inherit native
RDEPENDS = "python-native"
# Avoid circular dependencies from package_ipk.bbclass
PACKAGES = ""

do_stage() {
        for i in ${INSTALL}; do
                install -m 0755 $i ${STAGING_BINDIR}
        done
}
