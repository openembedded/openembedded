#
# Meta package for maemo based system image
#

FEED_URIS_append_openzaurus = " x11##http://openzaurus.org/official/unstable/${DISTRO_VERSION}/feed/x11 \
                                maemo##http://openzaurus.org/official/unstable/${DISTRO_VERSION}/feed/maemo"
FEED_URIS_append_opensimpad = " x11##http://openzaurus.org/official/unstable/${DISTRO_VERSION}/feed/x11 \
                                maemo##http://openzaurus.org/official/unstable/${DISTRO_VERSION}/feed/maemo"
FEED_URIS_append_familiar   = " x11##http://familiar.handhelds.org/releases/${DISTRO_VERSION}/feed/x11"

PR = "r1"

export IMAGE_BASENAME = "maemo-image"

GUI_MACHINE_CLASS ?= "none"

MAEMO_EXTRA_DEPENDS = "scap"
MAEMO_EXTRA_INSTALL = "osso-af-services osso-af-base-apps scap"

#prefer some versions of the maemo stack
PREFERRED_VERSION_gtk+="gtk+-2.6.4-1.osso7"
PREFERRED_VERSION_dbus = "0.23.1-osso5"
PREFERRED_PROVIDER_gconf = "gconf-osso"

DEPENDS = "task-bootstrap \
	   meta-maemo \
	   ${MAEMO_EXTRA_DEPENDS}"

export IPKG_INSTALL = "task-bootstrap maemo-task-base \
	               maemo-task-apps ${MAEMO_EXTRA_INSTALL} \
		       ${XSERVER}"

inherit image_ipk
LICENSE = MIT
