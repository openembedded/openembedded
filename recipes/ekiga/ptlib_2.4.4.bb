DESCRIPTION = "Portable Tools Libary"
LICENSE = "MPL"

inherit gnome

DEPENDS += "libgsm openldap openssl expat virtual/libsdl alsa-lib"

SRC_URI = "http://www.ekiga.org/admin/downloads/latest/sources/ekiga_3.0.2/ptlib-${PV}.tar.bz2"

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





SRC_URI[md5sum] = "221ea2f96ff6bae9cf604d8766eae526"
SRC_URI[sha256sum] = "c9ef4267490507fc9699634551b50c0c1c225d48e0c095a81be6fa5a1fa96a3a"
