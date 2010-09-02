LICENSE = "LGPLv2.1"

SRCREV = "caed93dd6ab6ae0cd7eb436357ceefa18f878981"
PV = "1.2.3"
PR = "r3"
PR_append = "+git${SRCREV}"

DEPENDS = "glib-2.0 gtk+ libccss clutter clutter-imcontext"

# 03_fix_FTBFS_port_to_gtk2.20.patch grabbed from http://launchpadlibrarian.net/48166967/nbtk_1.2.3-1_1.2.3-2.diff.gz

SRC_URI = "git://git.moblin.org/${PN}.git;protocol=git \
           file://03_fix_FTBFS_port_to_gtk2.20.patch \
"

S = "${WORKDIR}/git"

inherit autotools

do_configure_prepend () {
    echo "EXTRA_DIST=" > ${S}/gtk-doc.make
    echo "CLEANFILES=" >> ${S}/gtk-doc.make
}

