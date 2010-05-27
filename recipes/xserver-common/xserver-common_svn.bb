require xserver-common.inc

DEFAULT_PREFERENCE = "-1"

DEPENDS = "xmodmap xrandr xdpyinfo xtscal"
PV = "1.12+svn${SRCDATE}"
S = "${WORKDIR}/xserver-common"

PR = "r2"

SRC_URI = "${GPE_SVN} \
            file://Makefile.translation \
            file://Makefile.dpkg_ipkg \
	    file://svn_makefiles.patch \
	    file://keyboardless-buttonmap.patch \	   
	    file://softkeys-c7x0.patch \
 	    file://sl-cxx00-modmap.patch \
	    file://load-xmodmap-k26.patch \
	    file://Xserver-udev-input-helper.patch"
	    
