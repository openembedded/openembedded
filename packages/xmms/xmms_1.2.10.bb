DESCRIPTION = "The X MultiMedia System"
HOMEPAGE = "http://www.xmms.org/"
LICENSE = "GPL"
SECTION = "x11/multimedia"
# TODO add esd
DEPENDS = "gtk+-1.2 libvorbis mikmod"

SRC_URI = "http://www.xmms.org/files/1.2.x/xmms-${PV}.tar.bz2 \
           file://gcc4.patch;patch=1 \
           file://xmms-config-dequote.patch;patch=1 \
	   file://acinclude.m4"
PR = "r1"

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

do_stage() {
	autotools_stage_all
}
