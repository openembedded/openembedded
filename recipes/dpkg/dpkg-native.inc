require dpkg.inc

inherit native

DEPENDS = "perl-native bzip2-native zlib-native virtual/update-alternatives-native"
RDEPENDS_${PN} = ""

SRC_URI += "file://noman.patch"

# We need to do this so our perl is picked up.
do_configure_prepend() {
	export PERL=${STAGING_BINDIR}/perl
}

EXTRA_OECONF = "--without-static-progs \
		--without-dselect \
		--with-start-stop-daemon \
		--with-zlib \
		--with-bz2lib \
		--without-selinux \
		--with-admindir='\$\$$ENV{D}/var/lib/dpkg' \
		--without-sgml-doc"

do_stage_append() {
	for BIN in dpkg-architecture; do
		sed -i -e '1s,^#.*usr/bin,#!${STAGING_BINDIR},' ${STAGING_BINDIR}/$BIN
	done
}
