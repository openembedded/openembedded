HOMEPAGE = "http://www.muppetlabs.com/~breadbox/software/elfkickers.html"
LICENSE = "GPL"
PRIORITY = "optional"
SECTION = "devel"

SRC_URI = "http://www.muppetlabs.com/~breadbox/pub/software/ELFkickers-${PV}.tar.gz \
           file://gentoo.patch;patch=1 \
           file://mjn3-sstrip.patch;patch=1"
S = "${WORKDIR}/ELFkickers"

ELFPKGS = "ebfc elfls elftoc \
           rebind sstrip"

PACKAGES = "${PN}-dbg ${ELFPKGS} ${PN}"
FILES_ebfc = "${bindir}/ebfc"
FILES_elfls = "${bindir}/elfls"
FILES_elftoc = "${bindir}/elftoc"
FILES_rebind = "${bindir}/rebind"
FILES_sstrip = "${bindir}/sstrip"

do_compile () {
	for d in ${ELFPKGS}; do
		oe_runmake -C $d || exit 1
	done
}

do_install () {
	install -d ${D}${bindir}
	for d in ${ELFPKGS}; do
		install -m 0755 $d/$d ${D}${bindir}/ || exit 1
	done
}

SRC_URI[md5sum] = "3bf4d8d285591a5b7f31170f9b87aba0"
SRC_URI[sha256sum] = "c196988f55fc6633d9f9f6d9ddc2ae9b4dfa1f300edf4cbbad865c06a8656df7"
