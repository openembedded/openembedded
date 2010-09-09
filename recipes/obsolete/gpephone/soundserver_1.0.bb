LICENSE     = "LiPS"
DESCRIPTION = "Cellphone alarm daemon"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r2"

DEPENDS = "glib-2.0 libiac gstreamer"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpephone autotools

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

SRC_URI[md5sum] = "14cbf40e5c6ba1ac05a9309d392326fc"
SRC_URI[sha256sum] = "2cd45d30fcf862f65d3d9a096e69df1e6520920b01cc35fe66e1f21799645614"
