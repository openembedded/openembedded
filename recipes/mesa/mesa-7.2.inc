SRC_URI = "${SOURCEFORGE_MIRROR}/mesa3d/MesaLib-${PV}.tar.bz2;name=archive \
           ${SOURCEFORGE_MIRROR}/mesa3d/MesaDemos-${PV}.tar.bz2;name=demos "

SRC_URI[archive.md5sum] = "04d379292e023df0b0266825cb0dbde5"
SRC_URI[archive.sha256sum] = "a9cc62ab760afeebcb1319a193508734a2d470cab8effab2776a2d3c65bd9cd2"
SRC_URI[demos.md5sum] = "22e03dc4038cd63f32c21eb60994892b"
SRC_URI[demos.sha256sum] = "3d73988ad3e87f6084a4593cc6b3aac63aca3e893d3e9409d892a6f51558e4c4"

PACKAGES =+ "${PN}-xprogs"
FILES_${PN}-xprogs = "${bindir}/glxdemo ${bindir}/glxgears ${bindir}/glxheads ${bindir}/glxinfo"

do_install_append () {
    install -d ${D}/${bindir}
    for i in glxdemo glxgears glxheads glxinfo; do
        install -m 0755 ${S}/progs/xdemos/${i} ${D}/${bindir}
    done
}
