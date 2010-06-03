LICENSE = "GPL"
SRCDATE = "20060814"
PV = "0.0+cvs${SRCDATE}"
PR = "r4"

SRC_URI = "cvs://anonymous@linuxconsole.cvs.sourceforge.net/cvsroot/linuxconsole;module=ruby \
        file://serio.h \
        file://makefile.patch;striplevel=0 \
        file://snes232.patch;striplevel=0"

S = "${WORKDIR}/ruby/utils"

CFLAGS =+ "${LDFLAGS} -I. -I../linux/include -I../ruby-2.6/include"

do_configure() {
        install -d linux
        install -m 0644 ${WORKDIR}/serio.h linux/
}
do_install() {
        install -d ${D}${sbindir}
        install evtest inputattach jstest jscal fftest ${D}${sbindir}
}

