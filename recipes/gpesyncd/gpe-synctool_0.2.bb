DESCRIPTION = "Sync daemon for GPE and OpenSync"
LICENSE = "GPL"
DEPENDS = "gtk+ glib-2.0 libgpewidget"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools


SRC_URI[md5sum] = "83823c3d7abf80f71decea7abc4c7020"
SRC_URI[sha256sum] = "97428039697b9486a136d2f0ac54286af887853a38e0cec971407f52d29a2114"
