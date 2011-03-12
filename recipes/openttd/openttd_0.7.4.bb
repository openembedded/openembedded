require openttd.inc

# lzo2 not neccessary yet in 0.7.4
DEPENDS = "libsdl-net libpng zlib freetype fontconfig"

# Using the tar.bz2 for this release (they are missing for later releases).
SRC_URI ="http://binaries.openttd.org/releases/${PV}/${P}-source.tar.bz2"

# Version 0.7.4 can only handle opengfx
RRECOMMENDS_${PN} = "openttd-gfx"

PR = "r3"

# Override this function from openttd.inc because this 0.7.4's configure does not understand the 'lzo2' specific
# options and stops on seeing unknown options (Unlike what the real autotools would do. Hooray to people writing their
# own build systems!).
do_configure() {
  # The way the OTTD configure system handles the application's directories
  # isn't the way autotools does it. Mainly prefix is always prepended even if
  # absolute binary-dir and data-dir is given. 

  ${S}/configure \
	--host=${TARGET_SYS} \
	--windres=${MACHINE_DISPLAY_WIDTH_PIXELS}x${MACHINE_DISPLAY_HEIGHT_PIXELS} \
	--os=UNIX \
	--endian=${SITEINFO_ENDIANNESS} \
	--prefix-dir=${prefix} \
	--binary-dir=bin \
	--with-midi=/bin/true \
	--with-zlib=${STAGING_LIBDIR} \
	--with-png \
	--with-freetype \
	--without-icu \
	--without-allegro \
	--cc-build='${BUILD_CC}' \
	--cc-host='${CC}' \
	--cxx-build='${BUILD_CXX}' \
	--cxx-host='${CXX}' \
	--strip='${STRIP}' \
	--install-dir=${D}
}

do_install_append() {
	# Provide a placeholder sample.cat to allow the game being started.
	install -d ${D}${datadir}/games/openttd/data/
	touch ${D}${datadir}/games/openttd/data/sample.cat
}

SRC_URI_append_shr = " file://openttd.cfg"

do_install_append_shr() {
	install -d ${D}${datadir}/games/openttd/data/
	install -m 0644 ${WORKDIR}/openttd.cfg ${D}${datadir}/games/openttd/data/
}

SRC_URI[md5sum] = "30763b0dc6d77386a23261ad4b2cded8"
SRC_URI[sha256sum] = "014286af4b978fec3845fe276d40d07789acd4ac67b5f489f9bdfdf0eed6ad27"
