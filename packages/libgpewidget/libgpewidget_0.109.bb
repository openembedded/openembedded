LICENSE = "LGPL"
DESCRIPTION = "libgpewidget contains a collection of widgets and other common code shared by many GPE applications."
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS = "gtk+ cairo libxrender gtk-doc intltool-native"

PACKAGES =+ "libgpewidget-bin"

PARALLEL_MAKE = ""

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2"

inherit pkgconfig autotools

FILES_libgpewidget-bin = "${bindir}"

EXTRA_OECONF = "--enable-cairo"

LDFLAGS += " -L${STAGING_LIBDIR}" 


SRC_URI += "file://pkg.m4"
STAGING_NATIVEDATADIR = ${STAGING_DIR}/${BUILD_SYS}/share
do_configure_prepend() {
	cp ${STAGING_NATIVEDATADIR}/aclocal/pkg.m4 ${STAGING_NATIVEDATADIR}/aclocal/pkg.m4.old
	install -m 0644 ${WORKDIR}/pkg.m4 ${STAGING_NATIVEDATADIR}/aclocal/pkg.m4
}

do_configure_append() {
install -m 0644 ${STAGING_NATIVEDATADIR}/aclocal/pkg.m4.old ${STAGING_NATIVEDATADIR}/aclocal/pkg.m4
}

do_stage () {
	autotools_stage_all
}

