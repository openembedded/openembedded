DESCRIPTION = "A library of C functions that enable programs to send control strings to terminals in a way independent of the terminal type"
# Note that tparam.c is from emacs or glibc and appears to be GPL, whereas
# termcap.c is under the GNU LGPL.
LICENSE = "GPLv2"
PR = "0"

SRC_URI = "\
    ftp://ftp.linux.org.uk/pub/linux/libc/termcap-2.0.8.tar.gz \
    file://001_all_termcap-shared.patch \
    file://002_all_termcap-setuid.patch \
    file://003_all_termcap-inst-no-root.patch \
    file://004_all_termcap-compat-glibc21.patch \
    file://005_all_termcap-xref.patch \
    file://006_all_termcap-fix-tc.patch \
    file://007_all_termcap-ignore-p.patch \
    file://008_all_termcap-buffer.patch \
    file://009_all_termcap-bufsize--needs-011.patch \
    file://010_all_termcap-colon.patch \
    file://011_all_termcap-AAARGH.patch \
    file://012_all_libtermcap-compat-2.0.8-fPIC.patch;striplevel=0 \
    file://013_all_libtermcap-compat_bcopy_fix.patch;striplevel=0 \
"
SRC_URI[md5sum] = "b9256cccfd4ddf725e20bf100f8c001a"
SRC_URI[sha256sum] = "83764f2be5e9a7cb174ada280b26b2ca8a4fd645efdf8e41857143b84cea4e8f"

EXTRA_OEMAKE = "\
    'CC=${CC}' \
    'AR=${AR}' \
    'CFLAGS=${CFLAGS} -I.' \
"

do_install () {
    oe_libinstall -a -so -s libtermcap ${D}${libdir}
    install -d ${D}${infodir}
    install -m 0644 termcap.info* ${D}${infodir}/
    install -d ${D}${sysconfdir}
    install -m 0644 termcap.src ${D}${sysconfdir}/termcap
}

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND += "native nativesdk"
