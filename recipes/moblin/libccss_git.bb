SRC_URI = "git://anongit.freedesktop.org/git/ccss.git;protocol=git"
PV = "0.3.1+git${SRCREV}"
PR = "r0"

# nbtk needs libccss-0.3.1
SRCREV_pn-libccss = "cd63b0960ca782987d226811d1473e5745d2591d"

DEPENDS = "glib-2.0 cairo librsvg libsoup-2.4"

S = "${WORKDIR}/git"

inherit autotools

do_configure_prepend () {
	echo "EXTRA_DIST=" > ${S}/gtk-doc.make
	echo "CLEANFILES=" >> ${S}/gtk-doc.make
}
