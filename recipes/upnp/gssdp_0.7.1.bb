LICENSE = "LGPL"
DEPENDS = "glib-2.0 libsoup-2.4 libglade"

SRC_URI = "http://gupnp.org/sources/${PN}/${PN}-${PV}.tar.gz"

inherit autotools_stage pkgconfig

PACKAGES =+ "gssdp-tools"

FILES_gssdp-tools = "${bindir}/gssdp* ${datadir}/gssdp/*.glade"

SRC_URI[md5sum] = "725c32e8f92a072cc34f0e091937df2a"
SRC_URI[sha256sum] = "8eaab799f699836770ec2fcc08abfef2f824a82ae959c6af7b39ffb6968b9fd7"
