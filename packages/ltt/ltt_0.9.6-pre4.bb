SECTION = "devel"
DESCRIPTION = "The Linux trace toolkit is a suite of tools designed to \
extract program execution details from the Linux operating system and  \
interpret them."
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"

SRC_URI = "http://www.opersys.com/ftp/pub/LTT/ltt-${PV}.tar.bz2 \
	   file://m4.patch;patch=1"

inherit autotools

INHIBIT_PACKAGE_STRIP = "1"

EXTRA_OECONF = "--without-rtai \
		--without-gtk"

do_configure () {
	rm -f ${S}/acinclude.m4
	autotools_do_configure
}
