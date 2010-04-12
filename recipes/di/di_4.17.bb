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

SRC_URI[md5sum] = "be55b3a1693b318effa3db8d1c0243c1"
SRC_URI[sha256sum] = "46e124670fb2b63cb7500a8b36b7856c15858cb35658263ddad4933935d5e210"
