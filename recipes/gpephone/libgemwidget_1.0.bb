LICENSE     = "LiPS"
DESCRIPTION = "Extended widget library for GPE phone environment."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "gtk+ libiac libgpephone gnome-vfs libxdamage libxcomposite libgpewidget"
PR          = "r0"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpephone pkgconfig autotools

SRC_URI += " file://disable-tests.patch;patch=1 file://libgemwidget-fixup.diff;patch=1"

FILES_${PN} += "${datadir}/gem"

do_stage () {
	autotools_stage_all
}
