DESCRIPTION = "A curses based OO user interface framework"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "libcurses-perl-native libtermreadkey-perl-native"
RDEPENDS_${PN} += " \
	 libcurses-perl \
	 libtermreadkey-perl \
	 perl-module-base \
	 perl-module-exporter-heavy \
	 perl-module-filehandle \
	 "
BBCLASSEXTEND = "native"

PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MD/MDXI/Curses-UI-${PV}.tar.gz;name=curses-ui-perl-${PV}"
SRC_URI[curses-ui-perl-0.9607.md5sum] = "8970c72e378aa386e0e79a884ef5863a"
SRC_URI[curses-ui-perl-0.9607.sha256sum] = "8aad18855557278a64a14d512f837a0b6ff0ad4329728e35ea1fc5e6712c3f8a"

S = "${WORKDIR}/Curses-UI-${PV}"

inherit cpan

PACKAGE_ARCH = "all"
