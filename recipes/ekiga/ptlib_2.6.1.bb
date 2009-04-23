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




