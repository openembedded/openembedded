LICENSE     = "LiPS"
DESCRIPTION = "Cellphone alarm daemon"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "glib-2.0 libiac gstreamer"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpephone autotools

EXTRA_OECONF="--disable-osc8k"

do_configure () {
	export PKG_CONFIG=${STAGING_BINDIR_NATIVE}/pkg-config
	oe_runconf
}
