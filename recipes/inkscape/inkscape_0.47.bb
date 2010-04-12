SECTION = "x11/utils"
DESCRIPTION = "Inkscape is an SVG-based graphics editor featuring alpha \
blending, node editing, SVG to PNG export, and more. Its goal is for features \
similar to Illustrator, CorelDraw, Visio, etc."
DEPENDS = "poppler gsl libgc intltool-native gtk+ gtkmm glibmm libart-lgpl libxslt librsvg libxml2 libsigc++-1.2 popt"
LICENSE = "GPL"

#we know that GC version is 6.5, so we patch out the version check, since gc_open was already detected
SRC_URI = "${SOURCEFORGE_MIRROR}/inkscape/inkscape-${PV}.tar.bz2 \
           file://no-boehm-version-check.patch;patch=1"

S = "${WORKDIR}/inkscape-${PV}"

inherit autotools gettext mime gtk-icon-cache

EXTRA_OECONF = "--disable-mmx"

SRC_URI[md5sum] = "7b497c8f673e40b05295a29f6e2111f4"
SRC_URI[sha256sum] = "4985bc5bf1938d818fee31c72151a2d889300c0be00fab5dc94ccd84df39ef3a"
