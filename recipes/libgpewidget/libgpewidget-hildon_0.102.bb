LICENSE     = "LGPL"
PR          = "r0"
DESCRIPTION = "libgpewidget contains a collection of widgets and other common code shared by many GPE applications."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "gtk+ libxrender gtk-doc intltool-native sdk-default-icons"
PROVIDES    = "libgpewidget"

DEFAULT_PREFERENCE = "-1"

inherit autotools pkgconfig

SRC_URI     = "${GPE_MIRROR}/libgpewidget-${PV}.tar.bz2"
S = "${WORKDIR}/libgpewidget-${PV}"

EXTRA_OECONF = "--enable-hildon"

do_stage () {
	oe_libinstall -C .libs -so libgpewidget ${STAGING_LIBDIR}
	autotools_stage_includes
}

RDEPENDS = "sdk-default-icons"
RPROVIDES = "libgpewidget"

SRC_URI[md5sum] = "9eb90850adf65ec0d0ff26833f7cb8c6"
SRC_URI[sha256sum] = "ac25c961899ac71b0df93b517ac12b7b3c3083397abe9053a77f1e763e573822"
