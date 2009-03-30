DESCRIPTION = "XMMS embedded - lightweight audio player with video and codec plugins"
SECTION = "opie/multimedia"
DEPENDS = "zlib tremor glib-2.0 libmikmod \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libsidplay libmad libid3tag', d)}"
LICENSE = "GPL"
PR = "r6"

SRC_URI = "cvs://anonymous@xmms-embedded.cvs.sourceforge.net/cvsroot/xmms-embedded;module=xmms-embedded;date=${PV} \
           file://bogusincdir.patch;patch=1 \
           file://gtkremoval.patch;patch=1 \
           file://removenativeincdir.patch;patch=1 \
           file://glib2.patch;patch=1 \
           file://tremorlib.patch;patch=1 \
           file://bufferdefaults.patch;patch=1 \
           file://gcc34.patch;patch=1 \
           file://gcc34-enum.patch;patch=1 \
           file://mikmod-endian.patch;patch=1 \
           file://mikmod-update.patch;patch=1 \
           file://xmms.png"
S = "${WORKDIR}/xmms-embedded"

inherit palmtop

EXTRA_QMAKEVARS_POST += "LIBS+=-Wl,-rpath-link,${STAGING_LIBDIR} DEFINES+=_REENTRANT"

QMAKE_PROFILES = "xmms-e.pro"
export OE_QMAKE_LINK="${CXX}"

do_configure_prepend() {
    #remove all Makefiles - build will generate the correct ones using qmake
    find ${S} -name Makefile | xargs rm -f
}

do_compile() {
	oe_runmake "STAGING_DIR=${STAGING_EXECPREFIXDIR}"
}

do_install() {
    install -d ${D}${palmtopdir}/lib/xmms/Effect \
               ${D}${palmtopdir}/lib/xmms/General \
               ${D}${palmtopdir}/lib/xmms/Input \
               ${D}${palmtopdir}/lib/xmms/Output \
               ${D}${palmtopdir}/lib/xmms/skin \
               ${D}${palmtopdir}/bin \
               ${D}${palmtopdir}/apps/Applications \
               ${D}${palmtopdir}/pics
    install -m 0644 xmms/General/QPEgui/xmms.desktop ${D}${palmtopdir}/apps/Applications/xmms.desktop
    install -m 0644 ${WORKDIR}/xmms.png ${D}${palmtopdir}/pics/xmms.png
    install -m 0755 compiled/bin/xmms ${D}${palmtopdir}/bin/xmms
    oe_libinstall -so -C compiled libxmms ${D}${palmtopdir}/lib
    oe_libinstall -so -C compiled/xmms/General libQPEgui ${D}${palmtopdir}/lib/xmms/General
    for f in libfixpvorbisplugin libmplayer libshorten \
		libwav libxmms-mad libxmms-sid libmikmod
    do
        oe_libinstall -so -C compiled/xmms/Input $f ${D}${palmtopdir}/lib/xmms/Input
    done
    oe_libinstall -so -C compiled/xmms/Output liboss ${D}${palmtopdir}/lib/xmms/Output
    for f in eject.png fileadd.png main.png norep.png pause.png play.png rew.png \
		shuf.png stop.png ff.png filedel.png move.png noshuf.png plalap.png \
		rep.png save.png skinconf urladd.png
    do
        install -m 0644 Skins/winamp_xmms/${f} ${D}${palmtopdir}/lib/xmms/skin/${f}
    done
}

FILES-${PN}-dbg += "${palmtopdir}/lib/xmms/Input/.debug"
