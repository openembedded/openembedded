require xserver-common.inc

DEFAULT_PREFERENCE = "-1"

DEPENDS = "xmodmap xrandr xdpyinfo xtscal"
PV = "1.12+svn${SRCDATE}"
S = "${WORKDIR}/xserver-common"

PR = "r2"

SRC_URI = "${GPE_SVN} \
            file://Makefile.translation \
            file://Makefile.dpkg_ipkg \
	    file://svn_makefiles.patch;apply=yes \
	    file://keyboardless-buttonmap.patch;apply=yes \	   
	    file://softkeys-c7x0.patch;apply=yes \
 	    file://sl-cxx00-modmap.patch;apply=yes \
	    file://load-xmodmap-k26.patch;apply=yes \
	    file://Xserver-udev-input-helper.patch;apply=yes"
	    
