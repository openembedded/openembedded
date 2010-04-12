DESCRIPTION = "Zile is lossy Emacs."
HOMEPAGE = "http://zile.sourceforge.net/"
LICENSE = "GPL"
DEPENDS = "ncurses"
SECTION = "console/editors"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/zile/zile-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "1fa62e2309fa52e26a5594cc38911aee"
SRC_URI[sha256sum] = "2822148fdf6f2054b51c776db21f71e817761c225b370ab3f3ce7efe3711368f"
