DESCRIPTION = "Mono Programming Language"
SECTION = "devel/mono"
LICENSE = "GPL LGPL X11"

SRC_URI = "http://bec-systems.com/pub/mono/mono-2.2-rc1.tar.bz2 \
		"

#	   file://mono-libgc-configure.patch;patch=1"

S = "${WORKDIR}/mono-2.2"

do_fix_dolt_libtool() {
	# look for libtool prefixed with HOST_SYS
	sed -e "s/slash\}libtool/slash\}${HOST_SYS}-libtool/" -i acinclude.m4
}

inherit autotools
EXTRA_OECONF_arm = "--without-tls"
EXTRA_OECONF_mipsel = "--without-tls"

addtask fix_dolt_libtool after do_patch before do_configure

