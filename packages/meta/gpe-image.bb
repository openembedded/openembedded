FEED_URIS_append_openzaurus = " x11##${FEED_BASE_URI}/feed/x11 "

PR = "r23"

export IMAGE_BASENAME = "gpe-image"

GUI_MACHINE_CLASS ?= "none"

GPE_EXTRA_DEPENDS += "${GPE_EXTRA_DEPENDS_${GUI_MACHINE_CLASS}}"
GPE_EXTRA_INSTALL += "${GPE_EXTRA_INSTALL_${GUI_MACHINE_CLASS}}"

GPE_EXTRA_THEMES = "gpe-theme-industrial"

GPE_EXTRA_DEPENDS_bigscreen = "${GPE_EXTRA_THEMES}"
GPE_EXTRA_INSTALL_bigscreen = "gpe-task-games ${GPE_EXTRA_THEMES}"

GPE_EXTRA_DEPENDS_smallscreen = "${GPE_EXTRA_THEMES}"
GPE_EXTRA_INSTALL_smallscreen = "gpe-task-games ${GPE_EXTRA_THEMES}"

GPE_EXTRA_DEPENDS_poodle += "gpe-theme-clearlooks figment gpe-task-connectivity "
GPE_EXTRA_DEPENDS_c7x0   += "gpe-theme-clearlooks sylpheed figment gpe-task-connectivity "
GPE_EXTRA_DEPENDS_akita  += "gpe-theme-clearlooks sylpheed figment gpe-task-connectivity "
GPE_EXTRA_DEPENDS_spitz  += "gpe-theme-clearlooks sylpheed figment gpe-task-connectivity "
GPE_EXTRA_DEPENDS_tosa   += "gpe-theme-clearlooks sylpheed figment gpe-task-connectivity "

GPE_EXTRA_DEPENDS_none = ""
GPE_EXTRA_INSTALL_none = ""

#GPE_EXTRA_DEPENDS_h3600 = "dillo2"
#GPE_EXTRA_INSTALL_h3600 = "dillo2"


XSERVER ?= "xserver-kdrive-fbdev"

DEPENDS = "task-bootstrap \
	   meta-gpe \
	   ${GPE_EXTRA_DEPENDS}"

export IPKG_INSTALL = "task-bootstrap gpe-task-base \
           	       gpe-task-pim gpe-task-settings \
	               gpe-task-apps ${GPE_EXTRA_DEPENDS} \
		       ${XSERVER} "

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp "
ROOTFS_POSTPROCESS_COMMAND += "zap_root_password; "

inherit image_ipk
LICENSE = MIT
