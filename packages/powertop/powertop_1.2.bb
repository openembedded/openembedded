DESCRIPTION = "PowerTOP, a tool that helps you find what software is using the most power."
HOMEPAGE = "http://www.linuxpowertop.org/"
LICENSE = "GPLv2"

SRC_URI = "http://www.linuxpowertop.org/download/powertop-${PV}.tar.gz"

do_install() {
    oe_runmake install DESTDIR=${D}
}
