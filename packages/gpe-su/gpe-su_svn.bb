DESCRIPTION = "GPE Graphical root-shell frontend"
SECTION = "gpe"
LICENSE = "GPL"
DEPENDS = "libgpewidget"

inherit pkgconfig

SRC_URI = "${GPE_SVN} \
           file://svn-build.patch;patch=1"

S = "${WORKDIR}/${PN}"

DEFAULT_PREFERENCE = "-1"

