DESCRIPTION = "Portable Tools Libary"
LICENSE = "MPL"

inherit gnome

DEPENDS += "libgsm openldap openssl expat virtual/libsdl alsa-lib"

SRC_URI = "${SOURCEFORGE_MIRROR}/opalvoip/ptlib-${PV}.tar.bz2"

do_configure() {
    libtoolize --force
	gnu-configize
	oe_runconf
}

do_compile_append() {
        sed -i -e s:${STAGING_DIR_TARGET}::g \
               -e s:/${TARGET_SYS}::g \
                  ptlib.pc
}

FILES_${PN} += "${libdir}/ptlib-${PV}/*/*/*.so"

do_stage() {
	autotools_stage_all
}





SRC_URI[md5sum] = "d478121cfc82da7c0f0ce0e53fc7c2fd"
SRC_URI[sha256sum] = "941ead5179f5bab8dd6e81806b6e52120dc5b98c6ced8128df24639af1eabedd"
