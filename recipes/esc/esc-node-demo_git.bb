DESCRIPTION = "Demo of Node.js as a Matrix backend"
HOMEPAGE = "http://wiki.github.com/jadonk/node/"
SECTION = "devel"
PRIORITY = "optional"

PV = "0"
PR = "r4"

SRC_URI = "git://gist.github.com/397547.git;protocol=git \
"

SRCREV = "b23123982341cc097e3ecee67a0a299e6017db99"
S = "${WORKDIR}/git"

DEMO_FILES = " \
    matrix_command_shell.js \
    hello_world.js \
    index.html \
"

do_install() {
    install -d ${D}${datadir}/esc-training
    for i in ${DEMO_FILES}; do
        install -m 0755 ${S}/${i} ${D}${datadir}/esc-training
    done
}

RDEPENDS_${PN} = "nodejs"
FILES_${PN} += "${datadir}/esc-training"

