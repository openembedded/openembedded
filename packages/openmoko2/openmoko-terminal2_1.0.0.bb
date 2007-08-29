DESCRIPTION = "The OpenMoko Command Line Console"
SECTION = "openmoko/applications"
RDEPENDS += "mrxvt"
RCONFLICTS = "openmoko-terminal"
RREPLACES = "openmoko-terminal"
PR = "r5"

inherit openmoko2

SRC_URI = "file://openmoko-terminal.png \
           file://openmoko-terminal.desktop"

do_install() {
        install -d ${D}${datadir}/pixmaps
        install -d ${D}${datadir}/applications
        install -m 0644 ${WORKDIR}/openmoko-terminal.png ${D}${datadir}/pixmaps/
        install -m 0644 ${WORKDIR}/openmoko-terminal.desktop ${D}${datadir}/applications/
}

pkg_postinst_${PN}() {
        if [ "x$D" != "x" ]; then
                exit 1
        fi
		echo "adding font defaults to system-wide mrxvtrc..."
		cat <<EOF >> ${sysconfdir}/mrxvt/mrxvtrc
#
# ---------------------------------- FONTS ----------------------------------- #
#
Mrxvt.xft:                      1
Mrxvt.xftFont:                  Bitstream Vera Sans Mono
Mrxvt.xftSize:                  5
Mrxvt.xftAntialias:             1

# Don't load a multi-char font. This will reduce the line space if your multi
# char font has different dimensions than the regular font. You might need to
# comment it out if you want to use XIM and non-english fonts.
Mrxvt.xftNomFont:               1

# Font to use for tab bar / menus. This need not be mono-spaced ;).
Mrxvt.xftPFont:                 Bitstream Vera Sans
Mrxvt.xftPSize:                 6
EOF

}
