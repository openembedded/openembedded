LICENSE = "LGPL"
DEPENDS = "glib-2.0 libsoup-2.4 libglade"

require gupnp.inc

inherit autotools pkgconfig

PACKAGES =+ "gssdp-tools"

FILES_gssdp-tools = "${bindir}/gssdp* ${datadir}/gssdp/*.glade"

SRC_URI[md5sum] = "dbb085088337e2dd8c0216c36523ea06"
SRC_URI[sha256sum] = "68a114ece326b258b26259d31b9bb59c10049ff0162bcaa0f4f7a7dea9d244dc"
