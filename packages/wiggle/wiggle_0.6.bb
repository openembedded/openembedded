LICENSE = GPL
DESCRIPTION = "Wiggle is a program for applying patches that patch cannot \
apply because of conflicting changes."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
SECTION = "console/utils"
PR = "r1"

SRC_URI = "http://cgi.cse.unsw.edu.au/~neilb/source/wiggle/wiggle-${PV}.tar.gz \
	   file://001NoQuietTime;patch=1 \
	   file://002SpecFile;patch=1 \
	   file://003Recommit;patch=1 \
	   file://004ExtractFix;patch=1 \
	   file://005Pchanges;patch=1"
S = "${WORKDIR}/wiggle-${PV}"

export MANDIR = "${mandir}"
export BINDIR = "${bindir}"
EXTRA_OEMAKE += "'STRIP=/bin/true'"

do_compile () {
#	oe_runmake wiggle wiggle.man # requires nroff
	oe_runmake wiggle
}

do_install () {
	oe_runmake 'DESTDIR=${D}' install
}
