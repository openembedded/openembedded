DESCRIPTION = "GCalc is a calculator for GTK+ 1.2"
LICENSE="GPLv2"
PR = "r0"

DEPENDS = "gtk+-1.2"

SRC_URI = "http://jlime.com/downloads/development/software/gcalc-${PV}.tar.gz"

do_install() {
	oe_runmake install DESTDIR=${D}
}

SRC_URI[md5sum] = "624e94bba618672b4f11faf45a85bbfe"
SRC_URI[sha256sum] = "8a3e1464872e5e4049beb3cbc1052afe69816b6126bc095ad874c4c5ad229e15"
