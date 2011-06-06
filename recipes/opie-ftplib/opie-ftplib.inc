DESCRIPTION = "Opie FTP Library"
SECTION = "opie/libs"
PRIORITY = "optional"
LICENSE = "GPL"
I18N_FILES = "libftplib.ts"
APPNAME = "opie-ftplib"

S = "${WORKDIR}/ftplib"

inherit opie

do_install() {
    oe_libinstall -so libftplib ${D}${libdir}
    install -d ${D}${includedir}
    install -m 0664 ${S}/ftplib.h ${D}${includedir}
}
