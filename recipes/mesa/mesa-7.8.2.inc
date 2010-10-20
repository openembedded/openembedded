SRC_URI += " \ 
            ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaDemos-${PV}.tar.bz2;name=demos \
            file://fix-progs-makefile.patch \
            file://glamo.patch \
           "

SRC_URI[archive.md5sum] = "6be2d343a0089bfd395ce02aaf8adb57"
SRC_URI[archive.sha256sum] = "505bf418dceba05837f4ea1b1972b9620c35f8cb94bc4d1e6d573c15f562576d"
SRC_URI[demos.md5sum] = "757d9e2e06f48b1a52848be9b0307ced"
SRC_URI[demos.sha256sum] = "ea7b9ebfb7a80de2b275c0c9124c8a505382ec48411a2794ab82542f9885ac3c"

PACKAGES =+ "${PN}-xprogs"
FILES_${PN}-xprogs = "${bindir}/glxdemo ${bindir}/glxgears ${bindir}/glxheads ${bindir}/glxinfo"

EXTRA_OECONF += " --disable-gallium"

do_install_append () {
    install -d ${D}/${bindir}
    for i in glxdemo glxgears glxheads glxinfo; do
        install -m 0755 ${S}/progs/xdemos/${i} ${D}/${bindir}
    done
}
