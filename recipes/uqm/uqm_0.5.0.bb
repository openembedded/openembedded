DESCRIPTION = "Star Control 2 source port using SDL (see sc2.sourceforge.net)"
SECTION = "games"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl libsdl-image libsdl-net libvorbis libogg zlib"
SECTION = "games"
PRIORITY = "optional"
LICENSE = "GPL"

PR = "r2"

S = "${WORKDIR}/uqm-${PV}"

SRC_URI = "${SOURCEFORGE_MIRROR}/sc2/uqm-${PV}-source.tar.gz \
           file://build-opts.sh \
           file://build-oe.patch;patch=1;pnum=0 \
"

do_configure() {
	install ${WORKDIR}/build-opts.sh ${S}/
	./build-opts.sh ${STAGING_DIR_HOST}${layout_prefix} ${STAGING_BINDIR} ${STAGING_LIBDIR}
}

do_compile() {
	export ARCH="${TARGET_ARCH}"
	export CC="${CC}"
	export STAGING_INCDIR="${STAGING_INCDIR}"
	export STAGING_LIBDIR="${STAGING_LIBDIR}"
	./build.sh uqm
}

do_install() {
        install -d ${D}${bindir}
        install -m 0755 uqm ${D}${bindir}
}
