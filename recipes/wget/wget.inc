DESCRIPTION = "A console URL download utility featuring HTTP, FTP, and more."
SECTION = "console/network"
DEPENDS = ""
DEPENDS_shr = "gnutls"
INC_PR = "r8"
LICENSE = "GPL"

S = "${WORKDIR}/wget-${PV}"

inherit autotools gettext

# Disable checking for SSL since that searches the system paths
EXTRA_OECONF = "--enable-ipv6 --without-ssl"

# Enable SSL it's usefull
EXTRA_OECONF_shr = "--enable-ipv6 --with-ssl=gnutls"
# The unslung kernel does not support ipv6
EXTRA_OECONF_unslung = "--without-ssl"
# SlugOS kernels do not support ipv6. Can be loaded as a module.
EXTRA_OECONF_slugos = "--without-ssl"

do_configure() {
	autotools_do_configure
}

do_install () {
	autotools_do_install
	mv ${D}${bindir}/wget ${D}${bindir}/wget.${PN}
}

pkg_postinst_${PN} () {
	update-alternatives --install ${bindir}/wget wget wget.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove wget wget.${PN}
}
