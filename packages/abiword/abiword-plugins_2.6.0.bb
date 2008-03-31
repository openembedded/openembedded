DESCRIPTION = "AbiWord is a free word processing program similar to Microsoft(r) Word"
HOMEPAGE = "http://www.abiword.org"
SECTION = "x11/office"
LICENSE = "GPLv2"
DEPENDS = "boost loudmouth libwpd librsvg goffice poppler libglade"
RDEPENDS = "abiword"

SRC_URI = "http://www.abiword.org/downloads/abiword/${PV}/source/abiword-plugins-${PV}.tar.gz \
           http://www.abiword.org/downloads/abiword/${PV}/source/abiword-${PV}.tar.gz \
           file://abiword-cxx-for-ld-fix.patch;patch=1 \
	   "

DEFAULT_PREFERENCE = "2"

inherit autotools

PARALLEL_MAKE=""

# Ugly hack to find libstdc++
export LD="${CXX}"

EXTRA_OECONF = " --without-libwmf \
                 --without-inter7eps \
		 --with-abiword=${WORKDIR}/abiword-${PV} \
		 --with-boost=${STAGING_DIR_HOST} \ 
		 --with-boost-thread=boost_thread-mt \
               "

PACKAGES_DYNAMIC = "abiword-plugin-*"

python populate_packages_prepend () {
	abiword_libdir    = bb.data.expand('${libdir}/abiword-2.6/plugins', d)
	do_split_packages(d, abiword_libdir, '^libAbi(.*)\.so$', 'abiword-plugin-%s', 'Abiword plugin for %s', extra_depends='')
        do_split_packages(d, abiword_libdir, '^libAbi(.*)\.la$', 'abiword-plugin-%s-dev', 'Abiword plugin for %s', extra_depends='')
}


PACKAGES =+ "abiword-plugin-collab-glade"

FILES_abiword-plugin-collab-glade += "${datadir}"
RDEPENDS_abiword-plugin-collab-glade = "abiword-plugin-collab"

FILES_${PN}-dbg += "${libdir}/abiword-2.6/plugins/.debug"

