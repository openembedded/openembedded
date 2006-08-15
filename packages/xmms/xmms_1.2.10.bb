DESCRIPTION = "The X MultiMedia System"
HOMEPAGE = "http://www.xmms.org/"
LICENSE = "GPL"
SECTION = "x11/multimedia"
# TODO add esd
DEPENDS = "gtk+-1.2 libvorbis mikmod alsa-lib"

SRC_URI = "http://www.xmms.org/files/1.2.x/xmms-${PV}.tar.bz2 \
           file://gcc4.patch;patch=1 \
           file://xmms-config-dequote.patch;patch=1 \
	   file://acinclude.m4 \
           file://xmms.sh"
PR = "r2"

inherit autotools binconfig

# TODO enable esd
EXTRA_OECONF = "--disable-opengl --disable-esd \
                --with-vorbis-includes=${STAGING_INCDIR} \
                --with-ogg-includes=${STAGING_INCDIR} \
                --with-vorbis-libraries=${STAGING_LIBDIR} \
                --with-ogg-libraries=${STAGING_LIBDIR}"

do_configure_prepend() {
	cp ${WORKDIR}/acinclude.m4 ${S}
	rm ${S}/libxmms/acinclude.m4 || true
}

do_install_append() {
	install -m 0755 ${WORKDIR}/xmms.sh ${D}${bindir}
	install -d ${D}${datadir}/applications
	install xmms/xmms.desktop ${D}${datadir}/applications
	sed -i "s/Exec=xmms/Exec=xmms.sh/" ${D}${datadir}/applications/xmms.desktop
	install -d ${D}${datadir}/pixmaps
	install xmms/xmms_mini.xpm ${D}${datadir}/pixmaps
}

do_stage() {
	autotools_stage_all
}
