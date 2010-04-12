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





SRC_URI[md5sum] = "7d8dcd999827d51ad4a15afe74aad181"
SRC_URI[sha256sum] = "c99897464bd07c73dbb72095a9806ddc0c26141230e34b181d7e742e78259e4b"
