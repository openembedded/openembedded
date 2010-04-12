DESCRIPTION = "AbiWord is a free word processing program similar to Microsoft(r) Word"
HOMEPAGE = "http://www.abiword.org"
SECTION = "x11/office"
LICENSE = "GPLv2"
DEPENDS = "boost loudmouth libwpd librsvg goffice poppler libglade"
RDEPENDS = "abiword"

PR = "r1"

DEFAULT_PREFERENCE = "1"

SRC_URI = "http://www.abiword.org/downloads/abiword/${PV}/source/abiword-plugins-${PV}.tar.gz;name=plugins \
           http://www.abiword.org/downloads/abiword/${PV}/source/abiword-${PV}.tar.gz;name=archive \
	   "

inherit autotools

PARALLEL_MAKE=""

EXTRA_OECONF = " --without-libwmf \
                 --without-inter7eps \
		 --with-abiword=${WORKDIR}/abiword-${PV} \
		 --with-boost=${STAGING_INCDIR}/../ \ 
		 "

PACKAGES_DYNAMIC = "abiword-plugin-*"

python populate_packages_prepend () {
	abiword_libdir    = bb.data.expand('${libdir}/abiword-2.5/plugins', d)
	do_split_packages(d, abiword_libdir, '^libAbi(.*)\.so$', 'abiword-plugin-%s', 'Abiword plugin for %s', extra_depends='')
        do_split_packages(d, abiword_libdir, '^libAbi(.*)\.la$', 'abiword-plugin-%s-dev', 'Abiword plugin for %s', extra_depends='')
}


PACKAGES =+ "abiword-plugin-collab-glade"

FILES_abiword-plugin-collab-glade += "${datadir}"
RDEPENDS_abiword-plugin-collab-glade = "abiword-plugin-collab"

FILES_${PN}-dbg += "${libdir}/abiword-2.5/plugins/.debug"


SRC_URI[plugins.md5sum] = "0ad700d0cb6d176b39a191b16e3886c0"
SRC_URI[plugins.sha256sum] = "5714753ce1e89e72c2ba7e7d7d95546d9965a4e86bf76c060a8779b08fc2ae85"
SRC_URI[archive.md5sum] = "bbc9c124f8072875129bd67092f0fa0b"
SRC_URI[archive.sha256sum] = "db34eeb5457fb7572fc76ec2a73cdb4f7a67307e7468b6c4bde820b58c598b3f"
