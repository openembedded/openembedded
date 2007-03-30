HOMEPAGE = "http://www.x.org"
SECTION = "x11/base"
LICENSE = "MIT-X"

RPROVIDES_${PN} = "virtual/xserver"
PROVIDES = "virtual/xserver"

MESA_VER ?= "6.5"

DEPENDS = "fontconfig freetype flex-native lbxutil kbproto \
xf86driproto libdrm glproto randrproto renderproto fixesproto damageproto \
xcmiscproto xextproto xproto xf86miscproto xf86vidmodeproto xf86bigfontproto \
scrnsaverproto bigreqsproto resourceproto fontsproto inputproto \
xf86dgaproto videoproto compositeproto trapproto recordproto dmxproto \
resourceproto xineramaproto xtrans evieext libxkbfile libxfont libxau \
libfontenc libxdmcp libxxf86vm libxaw libxmu libxt libxpm libxext libx11 \
libxkbui libxxf86misc libxi libdmx libxtst libxres mesa mkfontscale-native"

RDEPENDS_${PN} = "rgb"

XORG_PN = "xorg-server"
XORG_RELEASE = "${@["individual",bb.data.getVar('PV', d, 1)[0:7]+"/src"][bb.data.getVar('PV', d, 1)[0:4] == "X11R"]}"
SRC_URI = "${XORG_MIRROR}/${XORG_RELEASE}/xserver/${XORG_PN}-${PV}.tar.bz2 \
	${SOURCEFORGE_MIRROR}/mesa3d/MesaLib-${MESA_VER}.tar.bz2 \
	file://xorg.conf"

S = "${WORKDIR}/${XORG_PN}-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-builddocs --with-mesa-source=${WORKDIR}/Mesa-${MESA_VER}"

PACKAGES =+ "${PN}-xprint ${PN}-xvfb ${PN}-utils ${PN}-xnest ${PN}-dmx"

FILES_${PN}-xprint = "${libdir}/X11/xserver/*/print ${bindir}/Xprt"
FILES_${PN}-xvfb = "${bindir}/Xvfb"
FILES_${PN}-xnest = "${bindir}/Xnest"
FILES_${PN}-dmx = "${bindir}/Xdmx ${bindir}/dmx* ${bindir}/xdmxconfig ${bindir}/xdmx ${bindir}/vdltodmx"
FILES_${PN}-utils = "${bindir}/scanpci ${bindir}/pcitweak ${bindir}/ioport ${bindir}/in[bwl] ${bindir}/out[bwl] ${bindir}/mmap[rw] ${bindir}/gtf ${bindir}/getconfig ${bindir}/getconfig.pl"
FILES_${PN} = "${bindir} ${libdir}/X11/Options ${libdir}/X11/Cards ${libdir}/X11/getconfig ${libdir}/X11/etc ${libdir}/xserver/SecurityPolicy ${libdir}/xorg/modules/*.so ${libdir}/xorg/modules/*/*.so /etc/X11"
FILES_${PN}-doc += "${libdir}/X11/doc /usr/share/X11/xkb/compiled/README.compiled"
FILES_${PN}-dbg += "${libdir}/xorg/modules/.debug ${libdir}/xorg/modules/*/.debug"
FILES_${PN}-dev += "${libdir}/xorg/modules/*.la ${libdir}/xorg/modules/*/*.la"

do_stage() {
	autotools_stage_all
}

do_install_append () {
	install -d ${D}/etc/X11
	install -m 0644 ${WORKDIR}/xorg.conf ${D}/etc/X11/
}
