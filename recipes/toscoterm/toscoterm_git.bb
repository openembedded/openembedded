DESCRIPTION = "A very small and simple terminal emulator"
SECTION = "x11/applications"
LICENSE = "GPLv3"
DEPENDS = "vte"
HOMEPAGE = "https://projetos.ossystems.com.br/projects/show/toscoterm"
SRCREV = "f02add76f365a2fecd2dbefc230ceaab20244f96"
PV = "0.0+gitr${SRCREV}"
PR = "r3"

SRC_URI = "git://projetos.ossystems.com.br/git/toscoterm.git;protocol=git"
S = "${WORKDIR}/git"

do_compile() {
	oe_runmake \
		CC="${CC}" \
		CFLAGS="${CFLAGS} `pkg-config --cflags gtk+-2.0` `pkg-config --cflags vte`" \
		LDFLAGS="${LDFLAGS} `pkg-config --libs gtk+-2.0` `pkg-config --libs vte`"
}

do_install() {
	oe_runmake PREFIX="/usr" DESTDIR="${D}" install
}
