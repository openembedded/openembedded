DESCRIPTION = "Gpredict is a satellite tracking and prediction application"
HOMEPAGE = "http://gpredict.oz9aec.net/"
SECTION = "x11"
DEPENDS = "gtk+ glib-2.0 goocanvas curl gettext intltool-native"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig

SRC_URI[md5sum] = "5547ab7dd1fd2af3bbb85a5e2c4e1e69"
SRC_URI[sha256sum] = "b0f6beed8da1b2c513ba1f22593195c6097fc7ccfc66cba4bdbc16277238d5a3"
