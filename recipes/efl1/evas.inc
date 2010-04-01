DESCRIPTION = "Evas is the Enlightenment canvas API"
LICENSE = "MIT BSD"
# can also depend on valgrind, libsdl-x11, directfb
DEPENDS = "librsvg eina eet freetype jpeg libpng virtual/libx11 libxext libxrender fontconfig libfribidi"
SRCREV = "${EFL_SRCREV}"
PV = "0.9.9.060+svnr${SRCPV}"
PR = "r1"


# disable thumb mode for arm
ARM_INSTRUCTION_SET = "arm"

inherit efl

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/evas"
EXTRA_OECONF = "<override me>"

python populate_packages_prepend () {
        for plugin_type in "engines loaders savers".split():
            bb.note( "splitting packages for evas %s..." % plugin_type )
            basedir = bb.data.expand( '${libdir}/evas/modules/%s' % plugin_type, d )

            do_split_packages(d, basedir, '^(.*)',
            output_pattern = 'evas-' + plugin_type[:-1] + "-%s",
            description = 'Evas module %s',
            allow_dirs=True, recursive=False, extra_depends="" )
}

do_install_append() {
    find "${D}" -name .debug -type d -exec rm -rf {} \;
}

FILES_${SRCNAME}-dev += "${libdir}/evas/modules/*/*/*/*.a ${libdir}/evas/modules/*/*/*/*.la"
FILES_${SRCNAME}-dbg += "${libdir}/evas/modules/*/*/*/.debug/"

PACKAGES_DYNAMIC = "evas-engine-* evas-loader-* evas-saver-*"

RRECOMMENDS_${SRCNAME} = "\
  evas-engine-buffer \
  evas-engine-fb \
  evas-engine-software-generic \
  evas-engine-software-x11 \
  evas-engine-software-16 \
  evas-engine-software-16-x11 \
  evas-engine-xrender-x11 \
  \
  evas-loader-png \
  evas-loader-jpeg \
  evas-loader-eet \
"

# Some upgrade path tweaking
AUTO_LIBNAME_PKGS = ""

RREPLACES_${SRCNAME} = "libevas-ver-pre-svn-00-0 libevas-ver-pre-svn-01-0"

RREPLACES_${SRCNAME}-tests = "libevas-ver-pre-svn-00-tests libevas-ver-pre-svn-01-tests"

RREPLACES_evas-loader-pmaps = "liblibevas-ver-pre-svn-00-loader-pmaps libevas-ver-pre-svn-00-loader-pmaps "
RREPLACES_evas-loader-eet = "liblibevas-ver-pre-svn-00-loader-eet libevas-ver-pre-svn-00-loader-eet "
RREPLACES_evas-loader-jpeg = "liblibevas-ver-pre-svn-00-loader-jpeg libevas-ver-pre-svn-00-loader-jpeg "
RREPLACES_evas-loader-tiff = "liblibevas-ver-pre-svn-00-loader-tiff libevas-ver-pre-svn-00-loader-tiff "
RREPLACES_evas-loader-png = "liblibevas-ver-pre-svn-00-loader-png libevas-ver-pre-svn-00-loader-png "
RREPLACES_evas-loader-xpm = "liblibevas-ver-pre-svn-00-loader-xpm libevas-ver-pre-svn-00-loader-xpm "

RREPLACES_evas-saver-pmaps = "liblibevas-ver-pre-svn-00-saver-pmaps libevas-ver-pre-svn-00-saver-pmaps "
RREPLACES_evas-saver-eet = "liblibevas-ver-pre-svn-00-saver-eet libevas-ver-pre-svn-00-saver-eet "
RREPLACES_evas-saver-jpeg = "liblibevas-ver-pre-svn-00-saver-jpeg libevas-ver-pre-svn-00-saver-jpeg "
RREPLACES_evas-saver-tiff = "liblibevas-ver-pre-svn-00-saver-tiff libevas-ver-pre-svn-00-saver-tiff "
RREPLACES_evas-saver-png = "liblibevas-ver-pre-svn-00-saver-png libevas-ver-pre-svn-00-saver-png "
RREPLACES_evas-saver-xpm = "liblibevas-ver-pre-svn-00-saver-xpm libevas-ver-pre-svn-00-saver-xpm "

RREPLACES_evas-engine-fb = "liblibevas-ver-pre-svn-00-engine-fb libevas-ver-pre-svn-00-engine-fb "
RREPLACES_evas-engine-software-generic = "liblibevas-ver-pre-svn-00-engine-software-generic libevas-ver-pre-svn-00-engine-software-generic "
RREPLACES_evas-engine-software-16 = "liblibevas-ver-pre-svn-00-engine-software-16 libevas-ver-pre-svn-00-engine-software-16 "
RREPLACES_evas-engine-buffer = "liblibevas-ver-pre-svn-00-engine-buffer libevas-ver-pre-svn-00-engine-buffer "
RREPLACES_evas-engine-xrender-x11 = "liblibevas-ver-pre-svn-00-engine-xrender-x11 libevas-ver-pre-svn-00-engine-xrender-x11 "
RREPLACES_evas-engine-software-x11 = "liblibevas-ver-pre-svn-00-engine-software-x11 libevas-ver-pre-svn-00-engine-software-x11 "



# disabling this, since (due to OE bugs) it drags in whole Gtk+
#RRECOMMENDS_${SRCNAME} += "\
#  libevas-loader-svg \
#"
