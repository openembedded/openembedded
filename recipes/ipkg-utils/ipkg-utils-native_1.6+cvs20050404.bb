require ipkg-utils_${PV}.bb

RDEPENDS_${PN} = ""
PR = "r25"

inherit native

NATIVE_INSTALL_WORKS = "1"

# Avoid circular dependencies from package_ipk.bbclass
PACKAGES = ""
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/ipkg-utils"
INSTALL += "arfile.py"

do_install() {
	install -d ${D}${bindir}
        for i in ${INSTALL}; do
                install -m 0755 $i ${D}${bindir}
        done
}
