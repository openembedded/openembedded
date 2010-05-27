DESCRIPTION = "rfkill CLI utility"
HOMEPAGE = "http://linuxwireless.org/en/users/Documentation/rfkill"
SECTION = "base"
LICENSE = "BSD"
PR = "r0"

DEPENDS = "libnl pkgconfig"

SRC_URI = "http://wireless.kernel.org/download/${PN}/${P}.tar.bz2"

do_compile() {
	oe_runmake
}

do_install() {
	oe_runmake DESTDIR=${D} install
}

SRC_URI[md5sum] = "727892c0fb35c80ee3849fbe89b45350"
SRC_URI[sha256sum] = "ca10e4827a5f0a36e093aee6ad81b5febf81f8097d7d858889ac51ff364168c1"
