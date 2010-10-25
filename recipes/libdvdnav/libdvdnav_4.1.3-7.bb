DESCRIPTION = "DVD navigation multimeda library"
SECTION = "libs/multimedia"
LICENSE = "GPLv2+"
DEPENDS = "libdvdread"

SRC_URI = "git://git.debian-maintainers.org/git/daniel/${PN}.git;protocol=git;branch=debian \
           file://0001-dvdnavmini.pc-link-against-libdvdnavmini.patch"

SRCREV = "850e513d4fea29b40879378b13003cd677e5214b"
S = "${WORKDIR}/git"

inherit autotools lib_package binconfig pkgconfig

do_unpackpost() {
        QUILT_PATCHES=debian/patches quilt push -a
}

FILES_${PN} = "${libdir}/${PN}${SOLIB}"

addtask unpackpost after do_unpack before do_patch

python populate_packages_prepend () {
        description = bb.data.expand('${DESCRIPTION}', d)
        libdir = bb.data.expand('${libdir}', d)
        do_split_packages(d, libdir, '^lib(.*)\.so\..*', 'lib%s', description + ' (%s)', extra_depends='', allow_links=True)
}
