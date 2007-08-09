DESCRIPTION = "Python GObject bindings"
SECTION = "devel/python"
LICENSE = "LGPL"
DEPENDS = "python-pygobject-native"
PR = "ml2"

SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/pygobject/2.12/pygobject-${PV}.tar.bz2"
S = "${WORKDIR}/pygobject-${PV}"

inherit autotools distutils-base pkgconfig

# otherwise the main package keeps snatching the .pc file away
# and therefore depends on glib-2.0-dev (which only the -dev
# package should).
PACKAGES =+ "${PN}-dev"

do_stage() {
	autotools_stage_all
	install -d ${STAGING_LIBDIR}/../share/pygobject/
	cp -dpfR docs/* ${STAGING_LIBDIR}/../share/pygobject/
	install -d ${STAGING_LIBDIR}/../share/gtk-doc/html/pygobject/
	cp docs/style.css ${STAGING_LIBDIR}/../share/gtk-doc/html/pygobject/
}
