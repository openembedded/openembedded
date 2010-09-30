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

SRC_URI[md5sum] = "1c29b18e01ab2b966162bc727bf3c360"
SRC_URI[sha256sum] = "1acb3de8e0927906ade7a34c5853173d3068b87b02dfba80d0bf11e47f0b5d39"

