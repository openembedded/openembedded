DESCRIPTION = "The GNU Compact Disc Input and Control library (libcdio) contains a library for CD-ROM and CD image access."
LICENSE = "GPLv3+"

SRC_URI = "http://ftp.gnu.org/gnu/libcdio/libcdio-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = " ac_cv_member_struct_tm_tm_gmtoff=no"

FILES_${PN} = "${bindir}/*"

python populate_packages_prepend () {
	glibdir = bb.data.expand('${libdir}', d)
	do_split_packages(d, glibdir, '^lib(.*)\.so\.*', 'lib%s', 'gstreamer %s library', extra_depends='', allow_links=True)
}




SRC_URI[md5sum] = "2ad1622b672ccf53a3444a0c55724d38"
SRC_URI[sha256sum] = "ddeafa5965eaa07f3bd46b0e39b65cba6fa9940d684f7b15bfd615f77eccb51c"
