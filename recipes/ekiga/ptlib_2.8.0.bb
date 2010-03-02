DESCRIPTION = "Portable Tools Libary"
LICENSE = "MPL"

inherit gnome

DEPENDS += "libgsm openldap openssl expat virtual/libsdl alsa-lib"

SRC_URI = "${SOURCEFORGE_MIRROR}/opalvoip/ptlib-${PV}.tar.bz2;name=ptlib \
"
SRC_URI[ptlib.md5sum] = "862ffac32bebbde97ca20320c5b478c6"
SRC_URI[ptlib.sha256sum] = "e5acadb55d1abd69163b8797bedabc592a567360da79f93dad185988338a5bd3"

EXTRA_OECONF = "  --enable-exceptions "

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


