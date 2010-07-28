LICENSE = "GPL"
SECTION = "console/utils"
DESCRIPTION = "grep GNU utility"
PR = "r2"

SRC_URI = "${GNU_MIRROR}/grep/grep-${PV}.tar.gz \
           file://uclibc-fix.patch"

inherit autotools gettext

EXTRA_OECONF = "--disable-perl-regexp --disable-ncurses"
EXTRA_OECONF_virtclass-native = "--with-included-regex --disable-ncurses"

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

do_install_virtclass-native () {
	autotools_do_install
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

BBCLASSEXTEND = "native"
SRC_URI[md5sum] = "3095b57837b312f087c0680559de7f13"
SRC_URI[sha256sum] = "a340e5d1544d9a964072196be627bad3e434ff7a87f3a57ea15aaccbbea4d666"
