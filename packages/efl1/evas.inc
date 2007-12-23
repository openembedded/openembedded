DESCRIPTION = "Evas is a hardware-accelerated canvas API that can draw \
anti-aliased text, smooth super and sub-images, alpha-blend, as well as drop \
down to using normal X11 primitives such as pixmaps, lines and rectangles if \
your CPU or graphics hardware are too slow."
LICENSE = "MIT"
# can also depend on valgrind, libsdl-x11, directfb
DEPENDS = "eet freetype jpeg virtual/libx11 libxext libxrender"
PV = "0.9.9.041+cvs${SRCDATE}"

inherit efl_library

# SRC_URI += "file://fix-configure.patch;patch=1"

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
    find "${D}" -name .debug -type d | xargs -iBLAH rm -rf "BLAH"
}

FILES_${PN}-dev += "${libdir}/evas/modules/*/*/*/*.a ${libdir}/evas/modules/*/*/*/*.la"
FILES_${PN}-dbg += "${libdir}/evas/modules/*/*/*/.debug/"
FILES_${PN} = "${libdir}/libevas*.so*"

PACKAGES_DYNAMIC = "libevas-engine-* libevas-loader-* libevas-saver-*"

RRECOMMENDS_${PN} = "\
  libevas-engine-buffer \
  libevas-engine-fb \
  libevas-engine-software-generic \
  libevas-engine-software-x11 \
  libevas-engine-software-16 \
  libevas-engine-xrender-x11 \
  \
  libevas-loader-png \
  libevas-loader-jpeg \
  libevas-loader-eet \
  libevas-loader-svg \
"
