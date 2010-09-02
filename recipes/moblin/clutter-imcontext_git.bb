LICENSE = "LGPLv2.1"

SRCREV = "2cb6f0ff153db639a489e58e36802e0e928b1968"
PV = "0.1.4"
PR = "r0"
PR_append = "+git${SRCREV}"

DEPENDS = "glib-2.0 gtk+ libccss clutter"

SRC_URI = "git://git.moblin.org/${PN}.git;protocol=git"
S = "${WORKDIR}/git"

inherit autotools

do_configure_prepend () {
    echo "EXTRA_DIST=" > ${S}/gtk-doc.make
    echo "CLEANFILES=" >> ${S}/gtk-doc.make
}

