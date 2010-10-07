DESCRIPTION = "A bejeweled clone in Elementary"
HOMEPAGE = "http://gitorious.org/mokosuite2/mokojeweled"
AUTHOR = "Daniele Ricci"
LICENSE = "GPLv3"
DEPENDS = "elementary edje-native"
SECTION = "x11/games"

PV = "0.1+gitr${SRCPV}"
SRCREV = "caf3072c6c10114cb54fb5b35dfa89db3fd0ac75"

SRC_URI = "git://gitorious.org/mokosuite2/mokojeweled.git;protocol=git"
S = "${WORKDIR}/git"

CFLAGS += "-DOPENMOKO"
EXTRA_OECONF = " --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

do_configure_prepend() {
        autopoint --force
}

inherit gettext autotools
