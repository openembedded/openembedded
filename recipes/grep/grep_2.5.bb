LICENSE = "GPL"
SECTION = "console/utils"
DESCRIPTION = "grep GNU utility"

SRC_URI = "${GNU_MIRROR}/grep/grep-${PV}.tar.bz2 \
	   file://install.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--disable-perl-regexp --disable-ncurses"

do_configure () {
	rm -f ${S}/m4/init.m4
	autotools_do_configure
}

SRC_URI[md5sum] = "5e7bd36e089b637ab3795354ec25dcae"
SRC_URI[sha256sum] = "cb47ab7e7e472e1cb27948d2ce055632ad68557f5ed5af989278e43117a611cd"
