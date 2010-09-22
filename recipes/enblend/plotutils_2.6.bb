DESCRIPTION = "The GNU plotutils package contains software for both programmers and technical users. Its centerpiece is libplot, a powerful C/C++ function library for exporting 2-D vector graphics in many file formats, both vector and raster. It can also do vector graphics animations."

LICENSE = "GPLv2+"

SRC_URI = "http://ftp.gnu.org/gnu/plotutils/plotutils-${PV}.tar.gz \
           file://01_configure_ac.patch"
SRC_URI[md5sum] = "c08a424bd2438c80a786a7f4b5bb6a40"
SRC_URI[sha256sum] = "4f4222820f97ca08c7ea707e4c53e5a3556af4d8f1ab51e0da6ff1627ff433ab"

inherit autotools

EXTRA_OECONF = "--enable-libxmi"

python populate_packages_prepend () {
	libdir = bb.data.expand('${libdir}', d)
	libdir_dbg = bb.data.expand('${libdir}/.debug', d)
	do_split_packages(d, libdir, '^lib(.*)\.so$', 'lib%s-dev', 'GNU Plotutils %s development package', extra_depends='${PN}-dev', allow_links=True)
	do_split_packages(d, libdir, '^lib(.*)\.la$', 'lib%s-dev', 'GNU Plotutils %s development package', extra_depends='${PN}-dev')
	do_split_packages(d, libdir, '^lib(.*)\.a$', 'lib%s-dev', 'GNU Plotutils %s development package', extra_depends='${PN}-dev')
	do_split_packages(d, libdir, '^lib(.*)\.so\.*', 'lib%s', 'GNU Plotutils %s library', extra_depends='', allow_links=True)
}

FILES_${PN} = "${bindir}"
