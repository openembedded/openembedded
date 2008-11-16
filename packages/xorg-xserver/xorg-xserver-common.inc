HOMEPAGE = "http://www.x.org"
SECTION = "x11/base"
LICENSE = "MIT-X"

PROVIDES = "virtual/xserver"

DEPENDS = "hal fontconfig freetype flex-native lbxutil kbproto \ 
xf86driproto drm glproto randrproto renderproto fixesproto damageproto \
xcmiscproto xextproto xproto xf86miscproto xf86vidmodeproto xf86bigfontproto \
scrnsaverproto bigreqsproto resourceproto fontsproto inputproto \
xf86dgaproto videoproto compositeproto trapproto recordproto dmxproto \
resourceproto xineramaproto xtrans evieext libxkbfile libxfont libxau \
libfontenc libxdmcp libxxf86vm libxaw libxmu libxt libxpm libxext libx11 \
libxkbui libxxf86misc libxi libdmx libxtst libxres mesa libxcalibrate"

RECOMMENDS_${PN} = "hal libpciaccess"

XORG_PN = "xorg-server"
SRC_URI = "${XORG_MIRROR}/individual/xserver/${XORG_PN}-${PV}.tar.bz2"

S = "${WORKDIR}/${XORG_PN}-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF += " --enable-xcalibrate \
                  --enable-kdrive \
                  --enable-xephyr \
                  --with-default-font-path="/usr/share/fonts/X11/misc" \
                  ac_cv_file__usr_share_sgml_X11_defs_ent=no"

EXTRA_OECONF_append_arm = " ac_cv_header_linux_apm_bios_h=no "

PACKAGES =+ "xserver-security-policy"
FILES_xserver-security-policy += "${libdir}/xserver/SecurityPolicy"
RRECOMMENDS_${PN} += "xserver-security-policy xkeyboard-config xorg-minimal-fonts rgb xserver-xorg-conf"

PACKAGES =+ "${PN}-xprint ${PN}-xvfb ${PN}-utils ${PN}-xephyr"

FILES_${PN}-xprint = "${libdir}/X11/xserver/*/print"
FILES_${PN}-xvfb = "${bindir}/Xvfb"
FILES_${PN}-utils = "${bindir}/scanpci ${bindir}/pcitweak ${bindir}/ioport ${bindir}/in[bwl] ${bindir}/out[bwl] ${bindir}/mmap[rw] ${bindir}/gtf ${bindir}/getconfig ${bindir}/getconfig.pl"
FILES_${PN} = "${bindir} ${libdir}/X11/Options ${libdir}/X11/Cards ${libdir}/X11/getconfig ${libdir}/X11/etc ${libdir}/modules ${libdir}/xorg/modules /etc/X11 "
FILES_${PN}-doc += "${libdir}/X11/doc /usr/share/X11/xkb/compiled/README.compiled"
FILES_${PN}-xephyr = "${bindir}/Xephyr"

FILES_${PN}-dbg += "${libdir}/xorg/modules/.debug \
                    ${libdir}/xorg/modules/*/.debug \
		    ${libdir}/xorg/modules/*/*/.debug \
		    "

do_stage() {
	autotools_stage_all
}

do_install_append () {
	ln -sf ${datadir}/fonts/X11 ${D}/${libdir}/X11/fonts
}
