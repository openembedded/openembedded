
MAINTAINER = "Jeremy Grant <jeremy@thegrantclan.org>"

PR = "r1"

export IMAGE_BASENAME = "grant-image"

GRANT_MACHINE_CLASS ?= "none"

XSERVER ?= "xserver-kdrive-fbdev"

DEPENDS = "task-bootstrap \
	   meta-grant \
	   ${GRANT_EXTRA_DEPENDS}"

export IPKG_INSTALL = "task-bootstrap \
	               ${GPE_EXTRA_DEPENDS} \
		       ${XSERVER} "

ROOTFS_POSTPROCESS_COMMAND += "zap_root_password; "

inherit image_ipk
LICENSE = MIT
