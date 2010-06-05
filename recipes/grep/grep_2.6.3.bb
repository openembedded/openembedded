LICENSE = "GPL"
SECTION = "console/utils"
DESCRIPTION = "grep GNU utility"
PR = "r1"

DEPENDS += "xz-native"

SRC_URI = "${GNU_MIRROR}/grep/grep-${PV}.tar.xz \
           file://uclibc-fix.patch"

inherit autotools

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

SRC_URI[md5sum] = "69a3bf508a3f14d12369e0e1c7a92763"
SRC_URI[sha256sum] = "ba745e2ff297ab225bf870740d35593d402a1d92999cf0d7e56840f10218db7c"

