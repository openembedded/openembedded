LICENSE = "GPL"
DESCRIPTION = "Wiggle is a program for applying patches that patch cannot \
apply because of conflicting changes."
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
EXTRA_OEMAKE += "'STRIP='"

do_compile () {
#	oe_runmake wiggle wiggle.man # requires nroff
	oe_runmake wiggle
}

do_install () {
	oe_runmake 'DESTDIR=${D}' install
}

SRC_URI[md5sum] = "1884607cdebaf730737cb99b2909219b"
SRC_URI[sha256sum] = "639f8bd48c58b1fa4f24a65bc8aa3e53219e7d48726e63e7c40f0701d1d89b9c"
