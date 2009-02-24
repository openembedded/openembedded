require dpkg.inc

inherit native

DEPENDS = "bzip2-native zlib-native virtual/update-alternatives-native"

SRC_URI += "file://noman.patch;patch=1"
FILESPATH += "dpkg-${PV}"

PERL_LIBDIR = "${STAGING_LIBDIR}/perl"

EXTRA_OECONF = "--without-static-progs \
		--without-dselect \
		--with-start-stop-daemon \
		--with-zlib \
		--with-bz2lib \
		--without-selinux \
		--without-sgml-doc"

do_stage_append() {
	for BIN in dpkg-architecture; do
		sed -i -e '1s,^#.*usr/bin,#!${STAGING_BINDIR},' ${STAGING_BINDIR}/$BIN
	done
}
