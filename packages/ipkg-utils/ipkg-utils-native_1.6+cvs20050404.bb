include ipkg-utils_${PV}.bb

RDEPENDS = ""
PR = "r6"

inherit native

# Avoid circular dependencies from package_ipk.bbclass
PACKAGES = ""

do_stage() {
        for i in ${INSTALL}; do
                install -m 0755 $i ${STAGING_BINDIR}
        done
}
