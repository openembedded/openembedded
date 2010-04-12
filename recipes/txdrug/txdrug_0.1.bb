DESCRIPTION = "Tx Drug Database"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "sqlite"
PR = "r3"

SRC_URI = "http://teax.sourceforge.net/txdrug-${PV}.tar.gz \
           file://opt/QtPalmtop"
S = "${WORKDIR}/txdrug-tar"

inherit palmtop

EXTRA_QMAKEVARS_POST += "LIBS+=-lsqlite TARGET=txdrug"

do_configure_prepend() {
        rm -f Makefile && qmake -project
}

do_configure_append() {
        sed -i "s/\-I\/usr\/include\/sqlite\ //g" Makefile
}

do_install() {
        install -d ${D}${palmtopdir}
        cp -Pfr `ls -dp ${WORKDIR}/opt/QtPalmtop/*|grep -v SCCS` ${D}${palmtopdir}/
        install -D -m 755 txdrug ${D}${palmtopdir}/bin/txdrug
}


SRC_URI[md5sum] = "c867374392559d6e475eeb03f6a81169"
SRC_URI[sha256sum] = "ee1044b61fc457ecc6025d06c5b9241994bd19e3d6ce98ae0827842caab00f0f"
