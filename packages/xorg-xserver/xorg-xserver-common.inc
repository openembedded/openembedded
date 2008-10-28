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

RECOMMENDS_${PN} = "hal"

XORG_PN = "xorg-server"
SRC_URI = "${XORG_MIRROR}/individual/xserver/${XORG_PN}-${PV}.tar.bz2 \
	file://xorg.conf"

S = "${WORKDIR}/${XORG_PN}-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF += " --enable-xcalibrate \
                  ac_cv_file__usr_share_sgml_X11_defs_ent=no"

PACKAGES =+ "xserver-security-policy"
FILES_xserver-security-policy += "${libdir}/xserver/SecurityPolicy"
RRECOMMENDS_${PN} += "xserver-security-policy xkeyboard-config xorg-minimal-fonts rgb"

PACKAGES =+ "${PN}-xprint ${PN}-xvfb ${PN}-utils"

FILES_${PN}-xprint = "${libdir}/X11/xserver/*/print"
FILES_${PN}-xvfb = "${bindir}/Xvfb"
FILES_${PN}-utils = "${bindir}/scanpci ${bindir}/pcitweak ${bindir}/ioport ${bindir}/in[bwl] ${bindir}/out[bwl] ${bindir}/mmap[rw] ${bindir}/gtf ${bindir}/getconfig ${bindir}/getconfig.pl"
FILES_${PN} = "${bindir} ${libdir}/X11/Options ${libdir}/X11/Cards ${libdir}/X11/getconfig ${libdir}/X11/etc ${libdir}/modules ${libdir}/xorg/modules /etc/X11 "
FILES_${PN}-doc += "${libdir}/X11/doc /usr/share/X11/xkb/compiled/README.compiled"

FILES_${PN}-dbg += "${libdir}/xorg/modules/.debug \
                    ${libdir}/xorg/modules/*/.debug \
		    ${libdir}/xorg/modules/*/*/.debug \
		    "

CONFFILES_${PN} += "${sysconfdir}/X11/xorg.conf"

do_stage() {
	autotools_stage_all
}

do_install_append () {
	install -d ${D}/${sysconfdir}/X11
	install -m 0644 ${WORKDIR}/xorg.conf ${D}/${sysconfdir}/X11/
	ln -sf ${datadir}/fonts/X11 ${D}/${libdir}/X11/fonts
	chmod u+s ${D}/usr/bin/Xorg
}
