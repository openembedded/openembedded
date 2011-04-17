DESCRIPTION = "Tools for managing memory technology devices."
SECTION = "base"
DEPENDS = "zlib util-linux-ng lzo2"
#DEPENDS = "zlib lzo e2fsprogs util-linux"
HOMEPAGE = "http://www.linux-mtd.infradead.org/"
LICENSE = "GPLv2+"
PR = "r0"

TAG = "v${PV}"

SRC_URI = "git://git.infradead.org/mtd-utils.git;protocol=git;tag=${TAG} \
           file://add-exclusion-to-mkfs-jffs2-git-2.patch \
          "

S = "${WORKDIR}/git/"

EXTRA_OEMAKE = "'CC=${CC}' 'CFLAGS=${CFLAGS} -I${S}/include -DWITHOUT_XATTR' 'BUILDDIR=${S}'"

do_install () {
        oe_runmake install DESTDIR=${D} SBINDIR=${sbindir} MANDIR=${mandir} INCLUDEDIR=${includedir}
        install -d ${D}${includedir}/mtd/
        for f in ${S}/include/mtd/*.h; do
        install -m 0644 $f ${D}${includedir}/mtd/
        done
}

PACKAGES =+ "mkfs-jffs2 mkfs-ubifs"
FILES_mkfs-jffs2 = "${sbindir}/mkfs.jffs2"
FILES_mkfs-ubifs = "${sbindir}/mkfs.ubifs"

PARALLEL_MAKE = ""

BBCLASSEXTEND = "native"
NATIVE_INSTALL_WORKS = "1"
