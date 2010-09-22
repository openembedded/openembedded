
inherit qt4x11

PR = "r1"

SRC_URI = "http://ktown.kde.org/~zrusin/examples/qgears2.tar.bz2 \
           file://0001-qt-embedded-patch.patch \
           file://0002-add-install-logic-to-pro-file.patch \
           "

S = ${WORKDIR}/qgears2

do_install() {
	export INSTALL_ROOT=${D}
	make install
}

SRC_URI[md5sum] = "1a5d0f555745c397216caa551fbda305" 
SRC_URI[sha256sum] = "dc86bb973dd904ef161a29066189ff1c48aa324a8800b83ef5415d904a0d2586"

