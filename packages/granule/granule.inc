DESCRIPTION = "Generic memory training with flash cards.  Automatic scheduling algorithm."
AUTHOR = "Vladislav Grinchenko <vlg@users.sourceforge.net>"
HOMEPAGE = "http://granule.sf.net"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "glib-2.0-native intltool-native gtkmm libxml2 libassa"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig

# enable small-screen mode for all sub-vga devices
EXTRA_OECONF_append_h3600 = " --enable-pda=yes "
EXTRA_OECONF_append_h3900 = " --enable-pda=yes "
EXTRA_OECONF_append_h2200 = " --enable-pda=yes "
EXTRA_OECONF_append_h4000 = " --enable-pda=yes "
EXTRA_OECONF_append_collie = " --enable-pda=yes "
EXTRA_OECONF_append_poodle = " --enable-pda=yes "
EXTRA_OECONF_append_mnci = " --enable-pda=yes "
EXTRA_OECONF_append_integral13 = " --enable-pda=yes "
