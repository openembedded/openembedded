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

SRC_URI[md5sum] = "37916e6f12bff470fb457ad2d382789b"
SRC_URI[sha256sum] = "b178c610fbbf2613ed1edeba2a11ed9c1ea042274465b2f3cd0a29cf1c7ebd9c"
