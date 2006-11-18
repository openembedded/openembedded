DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
PV = "1.12+svn${SRCDATE}"
PR = "r0"

PACKAGE_ARCH = "all"

DEFAULT_PREFERENCE = "-1"

DEPENDS = "xmodmap xrandr xdpyinfo xtscal"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo xtscal"


# we are using a gpe-style Makefile
inherit gpe

S = "${WORKDIR}/xserver-common"

SRC_URI = "${GPE_SVN} \
            file://Makefile.translation \
            file://Makefile.dpkg_ipkg \
	    file://svn_makefiles.patch;patch=1 \
	    file://keyboardless-buttonmap.patch;patch=1"
