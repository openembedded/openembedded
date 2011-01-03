DESCRIPTION = "gstd: a Gstreamer-based streaming server"
HOMEPAGE = "http://sourceforge.net/projects/gstd/"
LICENSE = "Various"
SECTION = "multimedia"
PRIORITY = "optional"

inherit autotools pkgconfig

DEPENDS = "dbus dbus-glib gstreamer readline"

SRCREV = "b1b22984a3028531cbddea431acd1e6c3fd0edb8"

PV = "1.0"
PR = "r15"
PR_append = "+gitr${SRCREV}"

SRC_URI = "git://gstd.git.sourceforge.net/gitroot/gstd/gstd;protocol=git \
           "
S = "${WORKDIR}/git"

# We don't want to run autoconf or automake, unless you have 
# automake > 1.11 with vala support
do_configure() {
    oe_runconf
}

RDEPENDS_${PN} = "dbus dbus-glib gstreamer gst-plugins-base"
RRECOMMENDS_${PN} = "gstreamer-ti"

FILES_${PN} += "${datadir}/dbus-1/*/*.service"
FILES_${PN}-dev += "${datadir}/dbus-1/interfaces/*.xml"
