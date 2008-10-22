DESCRIPTION = "Evas is the Enlightenment canvas API"
LICENSE = "MIT BSD"
# can also depend on valgrind, libsdl-x11, directfb
DEPENDS = "eet freetype jpeg libpng virtual/libx11 libxext libxrender fontconfig"
PV = "0.9.9.043+svnr${SRCREV}"
PR = "r1"


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

FILES_${PN}-dev += "${libdir}/evas/modules/*/*/*/*.a ${libdir}/evas/modules/*/*/*/*.la"
FILES_${PN}-dbg += "${libdir}/evas/modules/*/*/*/.debug/"

PACKAGES_DYNAMIC = "libevas-engine-* libevas-loader-* libevas-saver-*"

RRECOMMENDS_${PN} = "\
  libevas-engine-buffer \
  libevas-engine-fb \
  libevas-engine-software-generic \
  libevas-engine-software-x11 \
  libevas-engine-software-16 \
  libevas-engine-software-16-x11 \
  libevas-engine-xrender-x11 \
  \
  libevas-loader-png \
  libevas-loader-jpeg \
  libevas-loader-eet \
"

# disabling this, since (due to OE bugs) it drags in whole Gtk+
#RRECOMMENDS_${PN} += "\
#  libevas-loader-svg \
#"
