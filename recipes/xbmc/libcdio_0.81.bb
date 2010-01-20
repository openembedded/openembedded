DESCRIPTION = "The GNU Compact Disc Input and Control library (libcdio) contains a library for CD-ROM and CD image access."
LICENSE = "GPL"

SRC_URI = "http://ftp.gnu.org/gnu/libcdio/libcdio-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = " ac_cv_member_struct_tm_tm_gmtoff=no"

FILES_${PN} = "${bindir}/*"

python populate_packages_prepend () {
	glibdir = bb.data.expand('${libdir}', d)
	do_split_packages(d, glibdir, '^lib(.*)\.so\.*', 'lib%s', 'gstreamer %s library', extra_depends='', allow_links=True)
}



