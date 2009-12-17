DESCRIPTION = "Gstd: a Gstreamer-based streaming server"
HOMEPAGE = "http://sourceforge.net/projects/harrier/"
MAINTAINER = "harrier-devel@lists.sourceforge.net"
LICENSE = "BSD"
SECTION = "multimedia"
PRIORITY = "optional"

DEPENDS = "dbus dbus-glib gstreamer"
RDEPENDS = "gst-plugins-base"

SRCREV = "88b4ae3fd9973a503a85e194f17f364cdf903fb3"

PV = "1.0"
PR = "r5"
PR_append = "+gitr${SRCREV}"

SRC_URI = "git://harrier.git.sourceforge.net/gitroot/harrier/harrier;protocol=git \
           "

S = "${WORKDIR}/git"

inherit autotools pkgconfig

# We don't want to run autoconf or automake, unless you have 
# automake > 1.11 with vala support
do_configure() {
    oe_runconf
}

FILES_${PN} += "${datadir}/dbus-1/*/*.service"
FILES_${PN}-dev += "${datadir}/dbus-1/interfaces/*.xml"
