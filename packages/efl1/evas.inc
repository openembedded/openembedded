DESCRIPTION = "Evas is a hardware-accelerated canvas API that can draw \
anti-aliased text, smooth super and sub-images, alpha-blend, as well as drop \
down to using normal X11 primitives such as pixmaps, lines and rectangles if \
your CPU or graphics hardware are too slow."
LICENSE = "MIT"
# can also depend on valgrind (?)
DEPENDS = "directfb eet freetype jpeg virtual/libx11 libxext"

inherit efl1

export FREETYPE_CONFIG = "${STAGING_BINDIR_CROSS}/freetype-config"

SRC_URI = "http://enlightenment.freedesktop.org/files/evas-${PV}.tar.gz \
           file://fix-configure.patch;patch=1 \
           ${E_CVS};module=e17/libs/evas/m4;date=20060101"

S = "${WORKDIR}/evas-${PV}"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/evas"

EXTRA_OECONF = "<override me>"

do_configure_prepend() {
    if [ -e "${WORKDIR}/m4" ]; then
        install -d "${S}/m4"
        install "${WORKDIR}/m4/"*.m4 "${S}/m4"
        aclocal -I m4
    fi
}

python populate_packages_prepend () {
        for plugin_type in "engines loaders savers".split():
            bb.note( "splitting packages for evas %s..." % plugin_type )
            basedir = bb.data.expand( '${libdir}/evas/modules/%s' % plugin_type, d )

            do_split_packages(d, basedir, '^(.*)',
            output_pattern = 'evas-' + plugin_type[:-1] + "-%s",
            description = 'Evas module %s',
            allow_dirs=True, recursive=False )
}

do_install_append() {
    find "${D}" -name .debug -type d | xargs -iBLAH rm -rf "BLAH"
}

#do_stage_append() {
#	cd src
#	modules=`find modules -name ".libs"`
#	for module in $modules
#	do
#		install -d ${STAGING_LIBDIR}/evas/`dirname $module`/${TARGET_OS}-gnu-${TARGET_ARCH}
#		install -m 0755 $module/module.so ${STAGING_LIBDIR}/evas/`dirname $module`/${TARGET_OS}-gnu-${TARGET_ARCH}/module.so
#	done
#}

FILES_${PN}-dev += "${libdir}/evas/modules/*/*/*/*.a ${libdir}/evas/modules/*/*/*/*.la"
FILES_${PN}-dbg += "${libdir}/evas/modules/*/*/*/.debug/"
FILES_${PN} = "${libdir}/libevas*.so*"
