require ipkg-utils_${PV}.bb

RDEPENDS_${PN} = ""
PR = "r23"

inherit native

NATIVE_INSTALL_WORKS = "1"

# Avoid circular dependencies from package_ipk.bbclass
PACKAGES = ""
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/ipkg-utils"
INSTALL += "arfile.py"

do_install() {
        for i in ${INSTALL}; do
                install -m 0755 $i ${D}${bindir}
        done
}
