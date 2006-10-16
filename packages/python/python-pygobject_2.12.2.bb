DESCRIPTION = "Python GObject bindings"
SECTION = "devel/python"
LICENSE = "LGPL"
PR = "ml0"

SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/pygobject/2.12/pygobject-${PV}.tar.bz2"
S = "${WORKDIR}/pygobject-${PV}"

inherit autotools distutils-base pkgconfig

do_stage() {
	autotools_stage_all
	install -d ${STAGING_LIBDIR}/../share/pygobject/
	cp -dpfR docs/* ${STAGING_LIBDIR}/../share/pygobject/
}
