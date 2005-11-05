MAINTAINER = "Bob Davies  <tyggerbob@rogers.com>"
FEED_URIS_append_openzaurus = " x11##http://openzaurus.org/official/unstable/${DISTRO_VERSION}/feed/x11 \
                                gpe##http://openzaurus.org/official/unstable/${DISTRO_VERSION}/feed/gpe"
FEED_URIS_append_opensimpad = " x11##http://openzaurus.org/official/unstable/${DISTRO_VERSION}/feed/x11 \
                                gpe##http://openzaurus.org/official/unstable/${DISTRO_VERSION}/feed/gpe"
FEED_URIS_append_familiar   = " x11##http://familiar.handhelds.org/releases/${DISTRO_VERSION}/feed/x11"

PR = "r5"

export IMAGE_BASENAME = "sectest-gpe-image"

GUI_MACHINE_CLASS ?= "none"

GPE_EXTRA_DEPENDS += "${GPE_EXTRA_DEPENDS_${GUI_MACHINE_CLASS}}"
GPE_EXTRA_INSTALL += "${GPE_EXTRA_INSTALL_${GUI_MACHINE_CLASS}}"

GPE_EXTRA_THEMES = "gtk-theme-industrial gtk-industrial-engine matchbox-themes-extra-industrial"

#GPE_EXTRA_DEPENDS_bigscreen = "firefox linphone"
#GPE_EXTRA_INSTALL_bigscreen = "firefox linphone"
GPE_EXTRA_DEPENDS_bigscreen = "minimo"
GPE_EXTRA_INSTALL_bigscreen = "minimo gpe-task-games ${GPE_EXTRA_THEMES}"

GPE_EXTRA_DEPENDS_smallscreen = ""
GPE_EXTRA_INSTALL_smallscreen = "${GPE_EXTRA_THEMES}"

GPE_EXTRA_DEPENDS_none = ""
GPE_EXTRA_INSTALL_none = ""

XSERVER ?= "xserver-kdrive-fbdev"

DEPENDS = "task-bootstrap \
	   meta-sectest-gpe \
	   ${GPE_EXTRA_DEPENDS}"

export IPKG_INSTALL = "task-bootstrap gpe-task-base \
           	       gpe-task-pim gpe-task-settings \
	               sectest-task-apps ${GPE_EXTRA_DEPENDS} \
		       ${XSERVER} \
		       ${GPE_EXTRA_INSTALL}"

ROOTFS_POSTPROCESS_COMMAND += "zap_root_password; "

inherit image_ipk
LICENSE = MIT
