DESCRIPTION = "PowerTOP, a tool that helps you find what software is using the most power."
LICENSE = "GPLv2"

SRC_URI = "http://www.linuxpowertop.org/download/powertop-${PV}.tar.gz"

S = "${WORKDIR}/${PN}"


do_compile() {
       ${CC} -Wall -W -O1 -g powertop.c config.c -o powertop
}

do_install() {
        install -d ${D}${bindir}
        install -m 755 powertop ${D}${bindir}
}

