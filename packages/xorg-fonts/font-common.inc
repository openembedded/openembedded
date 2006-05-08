DESCRIPTION = "X font files"
SECTION = "x11/fonts"
LICENSE= "MIT-X"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/font/${PN}-X11R7.0-${PV}.tar.bz2"
S = "${WORKDIR}/${PN}-X11R7.0-${PV}"
FONT_DIR = "${datadir}/share/fonts"
DEPENDS = "encodings mkfontscale mkfontdir"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}


FILES_${PN} += " ${libdir}/X11/fonts/*.gz ${libdir}/X11/fonts/*/*.gz"

pkg_postinst_${PN} () {

        if [ "x$D" != "x" ]; then
                exit 1
        fi

        for fontdir in /usr/lib/X11/fonts/* /usr/lib/X11/fonts/*/*  ; do
                if test -d $fontdir ; then
                        mkfontdir $fontdir
                        mkfontscale $fontdir
                fi
        done
}
