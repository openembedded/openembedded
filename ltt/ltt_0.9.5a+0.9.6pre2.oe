SECTION = "devel"
DESCRIPTION = "The Linux trace toolkit is a suite of tools designed to \
extract program execution details from the Linux operating system and  \
interpret them."
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"

# NOTE: we're applying the relayfs patch.  therefore, this version of the
# tools will only work with a kernel that uses that particular incarnation
# of the ltt patch.  We probably need a way to exert control over this
# based on a variable that ${MACHINE}.conf can manipulate.
SRC_URI = "http://www.opersys.com/ftp/pub/LTT/TraceToolkit-0.9.6pre2.tgz \
	   http://www.opersys.com/ftp/pub/relayfs/LTT/patch-ltt-on-relayfs-0.9.6pre2.bz2;patch=1 \
	   file://gcc34.patch;patch=1 \
	   file://m4.patch;patch=1"
S = "${WORKDIR}/TraceToolkit-0.9.6pre2"

inherit autotools

INHIBIT_PACKAGE_STRIP = "1"
EXTRA_OECONF = "--without-rtai \
		--without-gtk"

do_configure () {
	rm -f ${S}/acinclude.m4
	autotools_do_configure
}
