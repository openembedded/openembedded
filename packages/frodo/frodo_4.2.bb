DESCRIPTION = "C64 Emulator based on SDL"
SECTION = "opie/applications"
PRIORITY = "optional"
DEPENDS = "libsdl-qpe"
LICENSE = "GPL"
SRCDATE = "20040801"
PR = "r1"

SRC_URI = "cvs://anoncvs:anoncvs@cvs.cebix.net/home/cvs/cebix;module=Frodo4 \
           file://m4.patch;patch=1 \
           file://configure.patch;patch=1 \
           file://frodorc \
           file://Frodo.png \
           file://frodo.desktop"
	   
S = "${WORKDIR}/Frodo4/Src"

inherit autotools

EXTRA_OECONF = "--disable-sdltest --enable-qtopia --with-sdl-exec-prefix=${STAGING_DIR}/${BUILD_SYS}"

do_install() {
        install -d ${D}${palmtopdir}/bin \
                   ${D}${palmtopdir}/apps/Games \
                   ${D}${palmtopdir}/pics
        install -m 0644 ${WORKDIR}/Frodo.png ${D}${palmtopdir}/pics/Frodo.png
        install -m 0644 ${WORKDIR}/frodo.desktop ${D}${palmtopdir}/apps/Games/frodo.desktop
        # start script and executable
        install -d ${D}${palmtopdir}/bin/${PN}
        install -m 0755 Frodo ${D}${palmtopdir}/bin/${PN}/Frodo
        cat <<STARTER_EOF > ${D}${palmtopdir}/bin/${PN}/frodostart
#!/bin/sh
cd ${palmtopdir}/bin/${PN}
./Frodo
STARTER_EOF
        chmod 0755 ${D}${palmtopdir}/bin/${PN}/frodostart
        ln -sf ${PN}/frodostart ${D}${palmtopdir}/bin/Frodo
        # conffiles
        install -d ${D}${sysconfdir}
        install -m 644 ${WORKDIR}/frodorc ${D}${sysconfdir}/frodorc
}

FILES_${PN} = "${palmtopdir} ${sysconfdir}"

#FIXME: Add postinst which copies /etc/frodorc into $HOME/.frodorc
