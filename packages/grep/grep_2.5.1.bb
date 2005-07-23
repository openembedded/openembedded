LICENSE = "GPL"
SECTION = "console/utils"
DESCRIPTION = "grep GNU utility"
MAINTAINER = "Pawel Osiczko <p.osiczko@tetrapyloctomy.org>"
PR = "r1"

SRC_URI = "${GNU_MIRROR}/grep/grep-${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF = "--disable-perl-regexp --disable-ncurses"

do_configure () {
	rm -f ${S}/m4/init.m4
	autotools_do_configure
}

do_install () {
	autotools_do_install
	install -d ${D}${base_bindir}
	mv ${D}${bindir}/grep ${D}${base_bindir}/grep.${PN}
	mv ${D}${bindir}/egrep ${D}${base_bindir}/egrep.${PN}
	mv ${D}${bindir}/fgrep ${D}${base_bindir}/fgrep.${PN}
}


pkg_postinst_${PN} () {
	update-alternatives --install ${base_bindir}/grep grep grep.${PN} 100
	update-alternatives --install ${base_bindir}/egrep egrep egrep.${PN} 100
	update-alternatives --install ${base_bindir}/fgrep fgrep fgrep.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove grep grep.${PN}
	update-alternatives --remove egrep egrep.${PN}
	update-alternatives --remove fgrep fgrep.${PN}
}
