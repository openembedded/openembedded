LICENSE = "GPL"
SECTION = "console/utils"
DESCRIPTION = "grep GNU utility"
PR = "r2"

SRC_URI = "${GNU_MIRROR}/grep/grep-${PV}.tar.bz2 \
           file://uclibc-fix.patch;patch=1"

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

SRC_URI[md5sum] = "ddd99e2d5d4f4611357e31e97f080cf2"
SRC_URI[sha256sum] = "fca0532a4b58021863b6673dc65b275f3e34cafd3b327dcf47da265af359778a"
