LICENSE     = "LiPS"
DESCRIPTION = "Cellphone alarm daemon"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r1"

DEPENDS = "glib-2.0 libiac gstreamer"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpephone autotools

SRC_URI += " file://libtool.patch;patch=1"

EXTRA_OECONF="--disable-osc8k"

LDFLAGS += " -L${STAGING_LIBDIR}"

do_configure () {
	export PKG_CONFIG=${STAGING_BINDIR_NATIVE}/pkg-config
	oe_runconf
}

do_configure_prepend () {
	export PKG_CONFIG=${STAGING_BINDIR_NATIVE}/pkg-config
	autoreconf
}
