DESCRIPTION = "Mono Programming Language"
SECTION = "devel/mono"
LICENSE = "GPL LGPL X11"

SRC_URI = "http://ftp.novell.com/pub/mono/sources/mono/mono-2.4.2.3.tar.bz2"

INC_PR = "r3"

S = "${WORKDIR}/mono-2.4.2.3"

do_fix_dolt_libtool() {
	# look for libtool prefixed with HOST_SYS
	sed -e "s/slash\}libtool/slash\}${HOST_SYS}-libtool/" -i acinclude.m4
	echo No acinclude!
}

inherit autotools
EXTRA_OECONF_arm = "--without-tls"
EXTRA_OECONF_mipsel = "--without-tls"

addtask fix_dolt_libtool after do_patch before do_configure
