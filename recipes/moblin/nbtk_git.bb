LICENSE = "LGPLv2.1"

SRCREV = "73958e79f0ad69dd4e63cb8e697bd80ecee1cc34"
PV = "0.8.0"
PR = "r1"
PR_append = "+git${SRCREV}"

DEPENDS = "glib-2.0 gtk+ libccss clutter-0.9"

SRC_URI = "git://git.moblin.org/${PN}.git;protocol=git"
S = "${WORKDIR}/git"

inherit autotools_stage

do_configure_prepend () {
    echo "EXTRA_DIST=" > ${S}/gtk-doc.make
    echo "CLEANFILES=" >> ${S}/gtk-doc.make
}

