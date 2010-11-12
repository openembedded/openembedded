DESCRIPTION = "Return the canonicalized absolute pathname"
SECTION = "utility"
PRIORITY = "optional"
LICENSE = "GPLv2"
PR = "r1"

SRC_URI = "${DEBIAN_MIRROR}/main/r/realpath/realpath_${PV}.tar.gz;name=realpath \
           file://makefile.patch"

SRC_URI[realpath.md5sum] = "1f2b2bceaacadf79162a9cbb5956c3b6"
SRC_URI[realpath.sha256sum] = "72199f9c11d1f9a36b3b9693988b558a167def6b88fa146ea6a7f7223f96c535"

CFLAGS += "-DVERSION=${PV}"

do_install () {
	install -d ${D}${bindir}
	install -p -m 0755 ${S}/realpath ${D}${bindir}/realpath.${PN}
}

pkg_postinst_${PN} () {
	update-alternatives --install ${bindir}/realpath realpath realpath.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove realpath realpath.${PN}
}
