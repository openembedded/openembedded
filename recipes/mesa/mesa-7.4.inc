SRC_URI = "${SOURCEFORGE_MIRROR}/mesa3d/MesaLib-${PV}.tar.bz2;name=archive \
           ${SOURCEFORGE_MIRROR}/mesa3d/MesaDemos-${PV}.tar.bz2;name=demos "

SRC_URI[archive.md5sum] = "7ecddb341a2691e0dfdb02f697109834"
SRC_URI[archive.sha256sum] = "6e945389add4e5b41f2c403ced13c343767565f2eacde4b16de2d0f9f8a6aac4"
SRC_URI[demos.md5sum] = "02816f10f30b1dc5e069e0f68c177c98"
SRC_URI[demos.sha256sum] = "c3de74d62f925e32030adb3d0edcfb3c7a4129fc92c48181a389eeed8f14b897"

PACKAGES =+ "${PN}-xprogs"
FILES_${PN}-xprogs = "${bindir}/glxdemo ${bindir}/glxgears ${bindir}/glxheads ${bindir}/glxinfo"

do_install_append () {
    install -d ${D}/${bindir}
    for i in glxdemo glxgears glxheads glxinfo; do
        install -m 0755 ${S}/progs/xdemos/${i} ${D}/${bindir}
    done
}
