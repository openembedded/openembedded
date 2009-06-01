LICENSE = "LGPLv2.1"

SRCREV = "6a498c374d176be0ed3ef2cd9b2381f452af1de8"
PV = "0.8.0"
PR_append = "+git${SRCREV}"

DEPENDS = "glib-2.0 gtk+ libccss clutter-0.9"

SRC_URI = "git://git.moblin.org/${PN}.git;protocol=git"
S = "${WORKDIR}/git"

inherit autotools_stage

do_configure_prepend () {
    echo "EXTRA_DIST=" > ${S}/gtk-doc.make
    echo "CLEANFILES=" >> ${S}/gtk-doc.make
}

