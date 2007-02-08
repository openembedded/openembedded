require xserver-common.inc

DEFAULT_PREFERENCE = "-1"

DEPENDS = "xmodmap xrandr xdpyinfo xtscal"
PV = "1.12+svn${SRCDATE}"
S = "${WORKDIR}/xserver-common"

SRC_URI = "${GPE_SVN} \
            file://Makefile.translation \
            file://Makefile.dpkg_ipkg \
	    file://svn_makefiles.patch;patch=1 \
	    file://keyboardless-buttonmap.patch;patch=1"
