DESCRIPTION = "A meta data manager API and framework (including Media)"
SRC_URI = "git://git.moblin.org/${PN}.git;protocol=git"
PV = "0.0"
PR_append = "+git${SRCREV}"
PR = "r3"

DEPENDS = "redland gtk+ dbus-glib clutter-gst-0.9 libexif taglib gupnp gupnp-av samba"
RDEPENDS = "xdg-user-dirs"

S = "${WORKDIR}/git"

FILES_${PN} =+ "${datadir}/dbus-1/services/"

inherit autotools_stage

do_compile_prepend() {
	sed -i -e '/#  warn /d' src/bkl-investigator.c
}

