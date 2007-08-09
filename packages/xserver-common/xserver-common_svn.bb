require xserver-common.inc

DEFAULT_PREFERENCE = "-1"

DEPENDS = "xmodmap xrandr xdpyinfo xtscal"
PV = "1.12+svn${SRCDATE}"
S = "${WORKDIR}/xserver-common"

PR = "r2"

SRC_URI = "${GPE_SVN} \
            file://Makefile.translation \
            file://Makefile.dpkg_ipkg \
	    file://svn_makefiles.patch;patch=1 \
	    file://keyboardless-buttonmap.patch;patch=1 \	   
	    file://softkeys-c7x0.patch;patch=1 \
 	    file://sl-cxx00-modmap.patch;patch=1 \
	    file://load-xmodmap-k26.patch;patch=1 \
	    file://Xserver-udev-input-helper.patch;patch=1"
	    
