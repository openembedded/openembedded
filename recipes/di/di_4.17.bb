DESCRIPTION = "di is a disk information utility, displaying everything (and more) that your df(1) command does. It features the ability to display your disk usage in whatever format you desire/prefer/are used to. It is designed to be portable across many platforms. "
HOMEPAGE = "http://www.gentoo.com/di/"
LICENSE = "MIT-style"
SECTION = "base"
DEPENDS = "perl-native"

SRC_URI = "http://www.gentoo.com/di/di-${PV}.tar.gz"

do_install() {
	# install binary
	install -d ${D}${bindir}
	install -m 0755 ${S}/di ${D}${bindir}

	# install manpage
	install -d ${D}${mandir}/man1
	install -m 0644 ${S}/di.1 ${D}${mandir}/man1
}
