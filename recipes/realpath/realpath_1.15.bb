DESCRIPTION = "Return the canonicalized absolute pathname"
SECTION = "utility"
PRIORITY = "optional"
LICENSE = "GPLv2"
PR = "r2"

SRC_URI = "${DEBIAN_MIRROR}/main/r/realpath/realpath_${PV}.tar.gz;name=realpath \
	   file://fix-common-mk.patch \
	   file://no-po4a.patch  \
	   file://remove-nls.patch \
	  "

CFLAGS += "-DVERSION=${PV}"
TARGET_CC_ARCH += "${LDFLAGS}"

do_install () {
	install -d ${D}${bindir}
	install -p -m 0755 ${S}/src/_build/realpath ${D}${bindir}/realpath.${PN}
}

pkg_postinst_${PN} () {
	update-alternatives --install ${bindir}/realpath realpath realpath.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove realpath realpath.${PN}
}

SRC_URI[realpath.md5sum] = "3351ce6e3d0ce255641c8ca9216a8638"
SRC_URI[realpath.sha256sum] = "b3d11cec375145ea60663e6fe54727c70a0e86c18f40bddac2a89b635cc1531f"
