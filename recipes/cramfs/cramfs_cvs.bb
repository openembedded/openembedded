DESCRIPTION = "Builds cramfs filesystems for embedded systems"
LICENSE = "GPLv2"
DEPENDS = "zlib"
SRCDATE = "20110110"
PV = "1.1+cvs${SRCDATE}"

SRC_URI = "cvs://anonymous@cramfs.cvs.sourceforge.net/cvsroot/cramfs;module=linux"
S = "${WORKDIR}/linux/scripts/cramfs"

EXTRA_OEMAKE = "\
    'CC=${CC}' \
    'CFLAGS=${CFLAGS}' \
    'LDFLAGS=${LDFLAGS}' \
"

BBCLASSEXTEND = "native"

do_install() {
	install -d ${D}${bindir}
	install mkcramfs ${D}${bindir}
	install cramfsck ${D}${bindir}
}

NATIVE_INSTALL_WORKS = "1"
