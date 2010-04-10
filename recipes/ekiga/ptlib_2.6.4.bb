DESCRIPTION = "Portable Tools Libary"
LICENSE = "MPL"

PR = "r1"

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

do_install_append() {
	chmod +x ${D}${libdir}/*
}

FILES_${PN} += "${libdir}/ptlib-${PV}/*/*/*.so"

do_stage() {
	autotools_stage_all
}





SRC_URI[md5sum] = "bcc8e2d5bb6be7e3fea857ce2f7fce5c"
SRC_URI[sha256sum] = "22eae4f6c72247f8ac79c57ce4469797ad3df67614758c5096b7ce9290bd10b4"
