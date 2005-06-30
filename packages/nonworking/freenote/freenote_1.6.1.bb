DESCRIPTION="Auto-Correction Paint Program for Opie/Qtopia"
SECTION="base"
PRIORITY="optional"
LICENSE="GPL"

SRC_URI = http://www.urban.ne.jp/home/kanemori/zaurus/FreeNote_${PV}_arm.tar.gz \
          file://${FILESDIR}/compile.patch;patch=1
S = ${WORKDIR}/FreeNote_${PV}_arm

inherit palmtop

do_configure_prepend() {
        qmake -project -o ${PN}.pro
}

do_install() {
        install -d ${D}/opt/QtPalmtop/{bin,apps/Applications,pics}
        install -D -m 755 freenoteeintu ${D}/opt/QtPalmtop/bin/freenoteeintu
        install -D -m 644 ${FILESDIR}/freenoteeintu.desktop ${D}/opt/QtPalmtop/apps/Applications/freenoteeintu.desktop
        install -d ${D}/opt/QtPalmtop/pics
        cp -a *.png ${D}/opt/QtPalmtop/pics/
}
