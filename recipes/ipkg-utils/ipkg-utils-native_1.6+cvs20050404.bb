require ipkg-utils_${PV}.bb

RDEPENDS_${PN} = ""
PR = "r22"

inherit native

# Avoid circular dependencies from package_ipk.bbclass
PACKAGES = ""
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/ipkg-utils"
INSTALL += "arfile.py"

do_stage() {
        for i in ${INSTALL}; do
                install -m 0755 $i ${STAGING_BINDIR}
        done
}
